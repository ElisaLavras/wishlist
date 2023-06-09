package com.magalu.wishListService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class WishProductNotFundException extends RuntimeException {
    public WishProductNotFundException(String message){
        super(message);
    }
}
