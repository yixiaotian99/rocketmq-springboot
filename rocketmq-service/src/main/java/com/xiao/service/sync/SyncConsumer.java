package com.xiao.service.sync;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 19:53
 * @Description 同步队列消费者
 **/
@Slf4j
@Component
@RocketMQMessageListener(topic = "test_sync_topic", consumerGroup = "test-consumer-group")
public class SyncConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String msg) {
        log.info("consumer sync msg:{}", msg);
    }
}
