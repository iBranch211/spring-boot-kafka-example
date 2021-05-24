package com.spring.kafka.service;

import com.spring.kafka.common.AppConstants;
import com.spring.kafka.model.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafKaProducerService {

    final KafkaTemplate<String, Object> kafkaTemplate;

    public void saveCreateUserLog(User user) {
        log.info(String.format("#### -> Producing user -> %s", user));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME_USER, user);
    }
}