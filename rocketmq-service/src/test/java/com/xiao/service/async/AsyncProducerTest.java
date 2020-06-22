package com.xiao.service.async;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:37
 * @Description TODO
 **/
@SpringBootTest
class AsyncProducerTest {


    @Autowired
    private AsyncProducer asyncProducer;

    @Test
    void sendAsync() {

        for (int i = 0; i < 10; i++) {
            asyncProducer.sendAsync("发送异步消息i: " + i);

            ThreadUtil.sleep(1000);
        }

    }
}