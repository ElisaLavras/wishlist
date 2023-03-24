package com.magalu.wishListService.service;

import com.magalu.wishListService.model.Product;
import com.magalu.wishListService.model.WishProduct;

import java.util.List;

public interface IWishProductService {

    List<WishProduct> get(String clientId);
    WishProduct get(String clientId,String productId);
    boolean remove(String clientId,String productId);
    WishProduct add(String clientId, Product productId);

}
