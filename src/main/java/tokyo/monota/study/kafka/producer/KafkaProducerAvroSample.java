package tokyo.monota.study.kafka.producer;

import com.kakfainaction.Alert;
import com.kakfainaction.alert_status;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Calendar;
import java.util.Properties;

public class KafkaProducerAvroSample {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");

        props.put("key.serializer", "org.apache.kafka.common.serialization.LongSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializer.KafkaAvroSerializer");

        Producer<Long, Alert> producer = new KafkaProducer<>(props);

        Alert alert = new Alert();
        alert.setSensorId(12345L);
        alert.setTime(Calendar.getInstance().getTimeInMillis());
        alert.setStatus(alert_status.Critical);
        System.out.println(alert.toString());

        ProducerRecord<Long, Alert> producerRecord = new ProducerRecord<>("avrotest", alert.getSensorId(), alert);

        // send asynchronously.
        producer.send(producerRecord);

        // wait until send complete.
        producer.close();
    }
}
