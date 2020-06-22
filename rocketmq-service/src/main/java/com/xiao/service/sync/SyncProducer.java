package com.xiao.service.sync;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:04
 * @Description 同步发送消息，可以保证消息到达，
 * 适用于高可用场景，如发送重要邮件通知
 **/
@Slf4j
@Component
public class SyncProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    /**
     * 同步发送消息
     *
     * @param msg
     * @return
     */
    public String sendSync(String msg) {

        msg = msg + ":" + DateUtil.now();
        log.info("send sync msg:{}", msg);

        SendResult syncTopic = rocketMQTemplate.syncSend("test_sync_topic", msg);

        log.info("sync msg result:{}", JSONUtil.toJsonStr(syncTopic));

        return msg;
    }

}
