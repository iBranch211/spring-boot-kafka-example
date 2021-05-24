package com.spring.kafka.service;

import com.spring.kafka.common.AppConstants;
import com.spring.kafka.model.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KafKaConsumerService {


    @KafkaListener(topics = AppConstants.TOPIC_NAME_USER, groupId = AppConstants.GROUP_ID)
    public void consume(User user) {
        log.info(String.format("User created -> %s", user));
    }
}
