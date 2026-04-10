package com.DmVaAlex.techstore.service;

import com.DmVaAlex.techstore.entity.Order;
import com.DmVaAlex.techstore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ с id " + id + " не найден"));
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Long id, Order order) {
        Order existing = getById(id);
        existing.setUser(order.getUser());
        existing.setProducts(order.getProducts());
        existing.setTotalPrice(order.getTotalPrice());
        return orderRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        orderRepository.deleteById(id);
    }
}