package kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @description: producer
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-22
 **/
public class ProducerExam {
    private static final Logger logger = LoggerFactory.getLogger(ProducerExam.class);

    public static void main(String[] args) {
        producerTest();
    }

    static void producerTest() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.8.4.15:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }
}
