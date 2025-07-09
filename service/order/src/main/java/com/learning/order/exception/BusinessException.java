package com.learning.order.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {
    public BusinessException(String msg) {
        super(msg);
    }
}

