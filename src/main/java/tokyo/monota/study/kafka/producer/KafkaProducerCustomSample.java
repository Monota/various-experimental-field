package tokyo.monota.study.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import tokyo.monota.study.kafka.data.Alert;

import java.util.Properties;

public class KafkaProducerCustomSample {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("acks", "all");
        props.put("retries", "3");
        props.put("max.in.flight.requests.per.connection", "5");
        props.put("key.serializer", "tokyo.monota.study.kafka.serde.AlertKeySerde");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("partitioner.class", "tokyo.monota.study.kafka.partitioner.AlertLevelPartitioner");

        Producer<Alert, String> producer = new KafkaProducer<>(props);

        Alert alert = new Alert(0, "Stage 0", "CRITICAL", "Stage 0 stopped");

        ProducerRecord producerRecord = new ProducerRecord<Alert, String>("healthtrend", alert, alert.getAlertMessage());

        // send asynchronously.
        producer.send(producerRecord, new AlertCallback());

        // wait until send complete.
        producer.close();
    }
}
