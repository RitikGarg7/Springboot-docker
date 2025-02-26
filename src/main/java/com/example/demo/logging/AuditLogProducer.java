package com.example.demo.logging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuditLogProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AuditLogProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void logUserAction(String action, String userId) {
        try {
            Map<String, Object> logEntry = new HashMap<>();
            logEntry.put("action", action);
            logEntry.put("userId", userId);
            logEntry.put("timestamp", System.currentTimeMillis());

            String message = objectMapper.writeValueAsString(logEntry);
            kafkaTemplate.send("user-activity-logs", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
