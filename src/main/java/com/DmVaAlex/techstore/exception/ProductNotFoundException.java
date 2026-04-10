package com.DmVaAlex.techstore.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Товар с id " + id + " не найден");
    }
}