package com.example.demo.logging;

import com.example.demo.model.AuditLog;
import com.example.demo.repository.AuditLogRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuditLogConsumer {

    private final AuditLogRepository auditLogRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AuditLogConsumer(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @KafkaListener(
            topics = "user-activity-logs",
            groupId = "audit-log-group",
            properties = "auto.offset.reset=earliest"
    )    public void consumeLog(String message) {
        System.out.println("Received Kafka message: " + message); // Debugging
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            AuditLog log = new AuditLog();
            log.setAction(jsonNode.get("action").asText());
            log.setUserId(jsonNode.get("userId").asText());
            log.setTimestamp(jsonNode.get("timestamp").asLong());

            auditLogRepository.save(log); // Store log in DB
            System.out.println("Audit log saved: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
