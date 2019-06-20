package com.zr.demo.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 *	 消费者服务
 * @author Administrator
 *
 */
@Service
public class MessageConsumerService2 {

    @JmsListener(destination="ccc")
    public void receiveMessage(String text) {    // 进行消息接收处理
        System.err.println("【*** 消费者2接收消息 ***】" + text);
    }
}
