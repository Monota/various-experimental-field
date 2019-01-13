package tokyo.monota.study.kafka.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

public class AlertLevelPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object objectKey, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        final List<PartitionInfo> partitionInfoList = cluster.availablePartitionsForTopic(topic);
        final int partitionSize = partitionInfoList.size();
        final int criticalPartition = partitionSize - 1;
        final int partitionCount = partitionSize - 1;

        final String key = (String) objectKey;

        if (key.contains("CRITICAL")) {
            return criticalPartition;
        } else {
            return Math.abs(key.hashCode()) % partitionCount;
        }
    }

    @Override
    public void close() {
        // NOOP
    }

    @Override
    public void configure(Map<String, ?> configs) {
        // NOOP
    }
}
