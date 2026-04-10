package com.DmVaAlex.techstore.controller;

import com.DmVaAlex.techstore.entity.Order;
import com.DmVaAlex.techstore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ с id " + id + " не найден"));
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderRepository.save(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order order) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ с id " + id + " не найден"));
        existing.setTotalPrice(order.getTotalPrice());
        existing.setProducts(order.getProducts());
        existing.setUser(order.getUser());
        return ResponseEntity.ok(orderRepository.save(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ с id " + id + " не найден"));
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}