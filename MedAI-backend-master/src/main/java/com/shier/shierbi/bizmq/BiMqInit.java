package com.shier.shierbi.bizmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.shier.shierbi.constant.BiMqConstant;

import java.util.HashMap;
import java.util.Map;

import static com.shier.shierbi.constant.BiMqConstant.*;

/**
 * @author Shier
 * CreateTime 2023/6/24 16:08
 * 用于BI项目,创建测试测序用到的交换机和队列 (仅执行一次)
 */
public class BiMqInit {
    public static void main(String[] args) throws Exception {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            // 设置 rabbitmq 对应的信息
            factory.setHost(BiMqConstant.BI_MQ_HOST);
//            factory.setPort(5672);
            factory.setUsername(BiMqConstant.BI_MQ_USERNAME);
            factory.setPassword(BiMqConstant.BI_MQ_PASSWORD);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String biExchange = BiMqConstant.BI_EXCHANGE_NAME;
            channel.exchangeDeclare(biExchange, BiMqConstant.BI_DIRECT_EXCHANGE);

            // 创建BI分析队列
            Map<String,Object> map = new HashMap<>();

            // BI分析队列绑定死信交换机
            map.put("x-dead-letter-exchange", BiMqConstant.BI_DLX_EXCHANGE_NAME);
            map.put("x-dead-letter-routing-key", BiMqConstant.BI_DLX_ROUTING_KEY);
            String queueName = BiMqConstant.BI_QUEUE;
            channel.queueDeclare(queueName,true,false,false,null);  /// null -> map
            channel.queueBind(queueName,BiMqConstant.BI_EXCHANGE_NAME,BiMqConstant.BI_ROUTING_KEY);

            //创建死信队列和死信交换机
            //创建死信队列
            channel.queueDeclare(BiMqConstant.BI_DLX_QUEUE_NAME,true,false,false,null);
            //创建死信交换机
            channel.exchangeDeclare(BiMqConstant.BI_DLX_EXCHANGE_NAME,BiMqConstant.BI_DIRECT_EXCHANGE);

            channel.queueBind(BiMqConstant.BI_DLX_QUEUE_NAME,BiMqConstant.BI_DLX_EXCHANGE_NAME,BiMqConstant.BI_DLX_ROUTING_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
