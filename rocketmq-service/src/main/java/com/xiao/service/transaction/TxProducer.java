package com.xiao.service.transaction;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:49
 * @Description 分布式事务消息
 **/
@Slf4j
@Component
public class TxProducer {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public String sendTxMsg(String msg) {
        msg = msg + ":" + DateUtil.now();
        log.info("send async msg:{}", msg);

        //使用事务推送消息
        Message<String> message = MessageBuilder.withPayload(msg).build();
        rocketMQTemplate.sendMessageInTransaction("test_tx_topic", message, null);

        return msg;
    }
}
