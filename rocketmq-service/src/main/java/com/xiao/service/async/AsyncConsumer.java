package com.xiao.service.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 19:53
 * @Description 异步队列消费者
 **/
@Slf4j
@Component
@RocketMQMessageListener(topic = "test_async_topic", consumerGroup = "test-async_consumer-group")
public class AsyncConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String msg) {
        log.info("consumer async msg:{}", msg);
    }
}
