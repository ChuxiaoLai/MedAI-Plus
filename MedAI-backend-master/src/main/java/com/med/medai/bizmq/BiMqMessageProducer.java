package com.med.medai.bizmq;

import com.med.medai.constant.BiMqConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lcx
 * BI项目 生产者
 */
@Component
public class BiMqMessageProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(BiMqConstant.BI_EXCHANGE_NAME,BiMqConstant.BI_ROUTING_KEY, message);
    }
}
