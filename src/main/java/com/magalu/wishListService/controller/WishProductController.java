package com.magalu.wishListService.controller;

import com.magalu.wishListService.model.Product;
import com.magalu.wishListService.model.WishProduct;
import com.magalu.wishListService.service.IWishProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/wish")
public class WishProductController {

    private IWishProductService service;
    @GetMapping("/{client_id}")
    public ResponseEntity<List<WishProduct>> get(@PathVariable(name = "client_id")String clientId){
        return new ResponseEntity<>(service.get(clientId), HttpStatus.OK);
    }
    @GetMapping("product/{client_id}")
    public ResponseEntity<WishProduct> get(@PathVariable(name = "client_id")String clientId, @RequestParam(name = "product_id") String productId) {
        return new ResponseEntity<>(service.get(clientId,productId), HttpStatus.OK);
    }

    @DeleteMapping("product/{client_id}")
    public ResponseEntity<Boolean> remove(@PathVariable(name = "client_id")String clientId, @RequestParam(name = "product_id") String productId) {
        return new ResponseEntity<>( service.remove(clientId,productId), HttpStatus.OK);
    }
    @PostMapping("/{client_id}")
    public ResponseEntity<WishProduct> add(@PathVariable(name = "client_id")String clientId, @RequestBody Product product) {
        return new ResponseEntity<>(service.add(clientId,product), HttpStatus.OK);
    }
}
