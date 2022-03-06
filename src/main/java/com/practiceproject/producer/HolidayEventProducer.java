package com.practiceproject.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practiceproject.dto.HolidayDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * The {@code HolidayEventProducer} class asynchronously publish messages
 * into the kafka topic.
 *
 * @author pablo.napoli
 *
 */
@Component
@Slf4j
public class HolidayEventProducer {
    @Autowired
    KafkaTemplate<Long,String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Publish a message into the Kafka topic.
     *
     * @param holidayDTO The message to be published.
     * @throws JsonProcessingException
     */
    public void sendHolidayEvent(HolidayDTO holidayDTO) throws JsonProcessingException {
        Long key = holidayDTO.getId();
        String value = objectMapper.writeValueAsString(holidayDTO);

        ListenableFuture<SendResult<Long,String>> listenableFuture =  kafkaTemplate.sendDefault(key,value);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Long, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);
            }

            @Override
            public void onSuccess(SendResult<Long, String> result) {
                handleSuccess(key, value, result);
            }
        });
    }

    private void handleSuccess(Long key, String value, SendResult<Long, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}",
                key, value, result.getRecordMetadata().partition());
    }

    private void handleFailure(Long key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }
    }
}
