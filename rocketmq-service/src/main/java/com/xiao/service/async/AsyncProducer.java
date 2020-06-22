package com.xiao.service.async;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:33
 * @Description 异步生产者
 * 适合于高吞吐量应用
 **/
@Slf4j
@Component
public class AsyncProducer {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    /**
     * 异步发送消息，有回调函数
     * @param msg
     * @return
     */
    public String sendAsync(String msg) {
        msg = msg + ":" + DateUtil.now();
        log.info("send async msg:{}", msg);

        rocketMQTemplate.asyncSend("test_async_topic", msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("send async success, result:{}", JSONUtil.toJsonStr(sendResult));
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("send async success, error:{}", throwable.fillInStackTrace());
            }
        });

        return msg;
    }

}
