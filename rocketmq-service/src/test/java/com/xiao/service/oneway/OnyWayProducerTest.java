package com.xiao.service.oneway;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:43
 * @Description TODO
 **/
@SpringBootTest
class OnyWayProducerTest {

    @Autowired
    private OnyWayProducer onyWayProducer;


    @Test
    void sendOneWay() {

        for (int i = 0; i < 10; i++) {
            onyWayProducer.sendOneWay("单向消息i: " + i);

            ThreadUtil.sleep(1000);
        }

    }
}