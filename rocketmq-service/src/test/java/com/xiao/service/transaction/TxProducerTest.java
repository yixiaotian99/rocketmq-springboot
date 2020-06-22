package com.xiao.service.transaction;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 21:00
 * @Description TODO
 **/
@SpringBootTest
class TxProducerTest {


    @Autowired
    private TxProducer txProducer;

    @Test
    void sendTxMsg() {

        for (int i = 0; i < 10; i++) {

            txProducer.sendTxMsg("推送事务消息i: " + i);

            ThreadUtil.sleep(1000);
        }
    }
}