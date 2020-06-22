package com.xiao.service.async;

import cn.hutool.core.thread.ThreadUtil;
import com.xiao.service.sync.SyncProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:08
 * @Description TODO
 **/
@SpringBootTest
class SyncProducerTest {

    @Autowired
    private SyncProducer syncProducer;

    @Test
    void sendSync() {

        for (int i = 0; i < 10; i++) {
            syncProducer.sendSync("同步消息i:" + i);

            ThreadUtil.sleep(500);
        }
    }
}