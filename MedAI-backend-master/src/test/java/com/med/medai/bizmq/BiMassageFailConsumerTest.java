package com.med.medai.bizmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BiMassageFailConsumerTest {

    @Resource
    private BiMassageFailConsumer biMassageFailConsumer;


    @Test
    void receiveMessage() {

    }
}