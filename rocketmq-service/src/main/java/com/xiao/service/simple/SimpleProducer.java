package com.xiao.service.simple;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 16:13
 * @Description 创建简单生产者
 **/
@Slf4j
@Component
public class SimpleProducer {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public String sendMsg(String msg) {

        msg = msg + ":" + DateUtil.now();
        log.info("send msg:{}", msg);


        rocketMQTemplate.convertAndSend("cart-item-add-topic", msg);

        return msg;
    }

}
