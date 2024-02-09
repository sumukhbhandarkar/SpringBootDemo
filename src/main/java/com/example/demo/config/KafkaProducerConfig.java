//package com.example.demo.config;
//
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaProducerConfig {
//
//    @Value(value = "${spring.kafka.bootstrap-address}")
//    private String bootstrapAddress;
//
//    /*
//    BOOTSTRAP_SERVERS_CONFIGS -> Host and port on which kafka is running
//    KEY_SERIALIZER_CLASS_CONFIG -> Serializer class to be used for the key
//    VALUE_SERIALIZER_CLASS_CONFIG -> Serializer class for value
//    (We are using StringSerializer.class for serializing both key,value)
//     */
//    @Bean
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(
//                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress
//        );
//        configProps.put(
//                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class
//        );
//        configProps.put(
//                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
//        );
//        return configProps;
//    }
//
//    /*
//    Responsible to create kafka producer instances
//     */
//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    /*
//    Responsible to send messages to the respective topics.
//     */
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}
