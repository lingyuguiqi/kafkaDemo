package com.lin.demo.producer;

import com.lin.demo.constant.Constant;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class KafkaProducer1 {
    private final Producer<String, String> producer;


    private KafkaProducer1() {
        Properties props = new Properties();
        // 此处配置的是kafka的端口
        props.put("metadata.broker.list", "127.0.0.1:9092");
        props.put("zk.connect", "127.0.0.1:2181");

        // 配置value的序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        // 配置key的序列化类
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");

        props.put("request.required.acks", "-1");

        producer = new Producer<String, String>(new ProducerConfig(props));
    }

    void produce() throws InterruptedException {
        int messageNo = 1000;
        final int COUNT = 10000;

        while (true) {
            ++messageNo;
            String key = String.valueOf(messageNo);
            String data = "INFO JobScheduler: Finished job streaming job 1493090727000 ms.0 from job set of time 1493090727000 ms" + key;
            producer.send(new KeyedMessage<String, String>(Constant.TOPIC, key, data));
            System.out.println(data);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new KafkaProducer1().produce();
    }
}
