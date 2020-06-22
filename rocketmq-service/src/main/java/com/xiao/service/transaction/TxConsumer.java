package com.xiao.service.transaction;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-22 20:54
 * @Description 事务消费者
 **/
@Slf4j
@Component
@RocketMQTransactionListener
public class TxConsumer implements RocketMQLocalTransactionListener {


    /**
     * 执行本地事务，如存储db等操作，当消息推送到 half topic 之后回调
     *
     * @param message
     * @param o
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {


        //获取当前事务状态
        String flag = String.valueOf(message.getHeaders().get("rocketmq_FLAG"));

        log.info("执行本地事务, flag:{}, message:{}", flag, JSONUtil.toJsonStr(message));

        //模拟失败情况
        if (Math.random() > 0.8) {
            return RocketMQLocalTransactionState.COMMIT;
        } else if (Math.random() > 0.5) {
            return RocketMQLocalTransactionState.ROLLBACK;
        } else if (Math.random() > 0.3) {
            ThreadUtil.sleep(4000);
        }

        return RocketMQLocalTransactionState.UNKNOWN;
    }


    /**
     * 当超时还未回调时，broker 主动查询事务状态
     *
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {

        log.info("执行事务回查, message:{}", JSONUtil.toJsonStr(message));

        return RocketMQLocalTransactionState.COMMIT;
    }
}
