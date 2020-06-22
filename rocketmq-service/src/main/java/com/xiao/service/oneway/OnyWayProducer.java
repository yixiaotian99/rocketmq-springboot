package com.xiao.service.oneway;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:41
 * @Description 单向传输，没有任何回调函数，
 * 适用于对吞吐量要求特别高的场景，如 日志收集
 **/
@Slf4j
@Component
public class OnyWayProducer {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public String sendOneWay(String msg) {
        msg = msg + ":" + DateUtil.now();
        log.info("send oneway msg:{}", msg);

        //对吞吐量要求特别高的场景，使用单向传输
        rocketMQTemplate.sendOneWay("test_oneway_topic", msg);

        return msg;
    }


}
