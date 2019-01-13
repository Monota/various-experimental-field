package tokyo.monota.study.kafka.serde;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import tokyo.monota.study.kafka.data.Alert;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class AlertKeySerde implements Serializer<Alert>, Deserializer<Alert> {

    @Override
    public byte[] serialize(String topic, Alert data) {

        if (data == null) {
            return null;
        }

        return data.getStageId().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public Alert deserialize(String topic, byte[] data) {
        return null;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // NOOP
    }

    @Override
    public void close() {
        // NOOP
    }
}
