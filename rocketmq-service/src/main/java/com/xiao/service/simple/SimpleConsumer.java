package com.xiao.service.simple;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 19:53
 * @Description 简单队列消费者
 **/
@Slf4j
@Component
@RocketMQMessageListener(topic = "cart-item-add-topic", consumerGroup = "cart-consumer-group")
public class SimpleConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String msg) {
        log.info("consumer msg:{}", msg);
    }
}
