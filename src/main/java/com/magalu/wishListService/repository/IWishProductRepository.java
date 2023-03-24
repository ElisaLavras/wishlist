package com.magalu.wishListService.repository;

import com.magalu.wishListService.model.WishProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IWishProductRepository extends MongoRepository<WishProduct,String> {
    List<WishProduct> findByClientId(String clientId);
    WishProduct findByClientIdAndProductId(String clientId, String productId);

}
