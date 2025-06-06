package com.itransform.order_service.service.impl;

import com.itransform.order_service.dto.OrderRequestDto;
import com.itransform.order_service.dto.OrderResponseDto;
import com.itransform.order_service.entity.Order;
import com.itransform.order_service.repository.OrderRepository;
import com.itransform.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = new Order();

        order.setWasherId(requestDto.getWasherId());
        order.setLocation(requestDto.getLocation());
        order.setRequestedTime(requestDto.getRequestedTime());
        order.setCarModel(requestDto.getCarModel());
        order.setCarNumber(requestDto.getCarNumber());
        order.setServiceType(requestDto.getServiceType());
        order.setPaymentStatus(requestDto.getPaymentStatus());
        order.setAmount(requestDto.getAmount());
        order.setStatus("PENDING");


        Order savedOrder = orderRepository.save(order);
        return mapToDto(savedOrder);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDto getOrderById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return mapToDto(order);
    }

    @Override
    public List<OrderResponseDto> getOrdersByUserId(UUID userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDto> getOrdersByWasherId(UUID washerId) {
        return orderRepository.findByWasherId(washerId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDto updateOrderStatus(UUID id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        order.setStatus(status);
        Order updatedOrder = orderRepository.save(order);
        return mapToDto(updatedOrder);
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    private OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getOrderId());
        dto.setUserId(order.getUserId());
        dto.setWasherId(order.getWasherId());
        dto.setLocation(order.getLocation());
        dto.setRequestedTime(order.getRequestedTime());
        dto.setCarModel(order.getCarModel());
        dto.setCarNumber(order.getCarNumber());
        dto.setServiceType(order.getServiceType());
        dto.setPaymentStatus(order.getPaymentStatus());
        dto.setAmount(order.getAmount());
        dto.setStatus(order.getStatus());
        dto.setCompletedTime(order.getCompletedTime());
        return dto;
    }
}
