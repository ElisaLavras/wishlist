package com.magalu.wishListService.service.impl;

import com.magalu.wishListService.exception.WishProductException;
import com.magalu.wishListService.exception.WishProductNotFundException;
import com.magalu.wishListService.model.Product;
import com.magalu.wishListService.model.WishProduct;
import com.magalu.wishListService.repository.IWishProductRepository;
import com.magalu.wishListService.service.IWishProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WishProductService implements IWishProductService {

    private IWishProductRepository repository;

    @Override
    public List<WishProduct> get(String clientId) {
        return repository.findByClientId(clientId);
    }

    @Override
    public WishProduct get(String clientId, String productId) {
        Optional<WishProduct> wishProduct = Optional.ofNullable(repository.findByClientIdAndProductId(clientId,productId));
        if (wishProduct.isPresent())
            return wishProduct.get();
        throw new WishProductNotFundException("Produto não encontrado na wishlist do cliente!");
    }

    @Override
    public boolean remove(String clientId, String productId) {
       WishProduct wishProduct = this.get(clientId, productId);
       wishProduct.setActive(false);
       wishProduct.setUpdatedDate(LocalDate.now());
       repository.save(wishProduct);

       return true;
    }

    @Override
    public WishProduct add(String clientId, Product product) {
        List<WishProduct> wishlist= this.get(clientId);
        if(wishlist.size()>=20)
            throw new WishProductException("WishList do cliente está lotada!");

        if (wishlist.stream().anyMatch(wishProduct -> wishProduct.getProductId().equals(product.getId())))
            throw new WishProductException("Produto ja se encontra naWishList do cliente!");

        return repository.insert(WishProduct.builder()
                .productId(product.getId())
                .clientId(clientId)
                .productName(product.getName())
                .active(true)
                .createdDate(LocalDate.now())
                .updatedDate(LocalDate.now()).build());

    }
}
