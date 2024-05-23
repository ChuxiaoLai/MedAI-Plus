package com.med.medai.bizmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BiMqMessageProducerTest {

    @Resource
    private BiMqMessageProducer producer;

    @Test
    void sendMessage() {
        producer.sendMessage("进入死信队列~~~~1111");
    }
}