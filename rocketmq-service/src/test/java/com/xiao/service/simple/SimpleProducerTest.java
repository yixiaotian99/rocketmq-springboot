package com.xiao.service.simple;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 16:25
 * @Description TODO
 **/
@SpringBootTest
class SimpleProducerTest {


    @Autowired
    private SimpleProducer simpleProducer;

    @Test
    void sendMsg() {

        for (int i = 0; i <10 ; i++) {

            simpleProducer.sendMsg("我是测试的i:" + i);
            ThreadUtil.sleep(2000);
        }
    }
}