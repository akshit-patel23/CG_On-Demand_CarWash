package com.itransform.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private UUID orderId;

    private UUID userId;
    private UUID washerId;
    private String location;
    private LocalDateTime requestedTime;
    private String status;
    private String carModel;
    private String carNumber;
    private String serviceType;
    private String paymentStatus;
    private Double amount;
    private LocalDateTime completedTime;
}
