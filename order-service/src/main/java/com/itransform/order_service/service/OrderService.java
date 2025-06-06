package com.itransform.order_service.service;

import com.itransform.order_service.dto.OrderRequestDto;
import com.itransform.order_service.dto.OrderResponseDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto requestDto);
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto getOrderById(UUID orderId);
    OrderResponseDto updateOrderStatus(UUID orderId, String newStatus);
    void deleteOrder(UUID orderId);

    public List<OrderResponseDto> getOrdersByUserId(UUID userId);
    public List<OrderResponseDto> getOrdersByWasherId(UUID userId);
}
