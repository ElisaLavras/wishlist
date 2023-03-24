package com.magalu.wishListService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class WishProductException extends RuntimeException {
    public WishProductException(String message){
        super(message);
    }
}