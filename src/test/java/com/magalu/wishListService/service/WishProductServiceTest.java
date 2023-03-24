package com.magalu.wishListService.service;

import com.magalu.wishListService.exception.WishProductNotFundException;
import com.magalu.wishListService.model.Product;
import com.magalu.wishListService.model.WishProduct;
import com.magalu.wishListService.repository.IWishProductRepository;
import com.magalu.wishListService.service.impl.WishProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class WishProductServiceTest {

    private WishProductService service;
    @Mock
    private IWishProductRepository repository;

    private String productId = "ProductId";

    private WishProduct wishProduct;
    private Product product;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        wishProduct = WishProduct.builder()
                .productId("ProductId")
                .productName("Product Name")
                .createdDate(LocalDate.now())
                .updatedDate(LocalDate.now())
                .clientId("ClientId")
                .build();
        product = Product.builder().id(productId).name("Product name").build();
    }

    @Test
    public void getTest(){
        List<WishProduct> list = Collections.singletonList(wishProduct);
        Mockito.when(repository.findByClientId(wishProduct.getClientId())).thenReturn(list);
        service = getService();
        Assert.assertEquals(service.get(wishProduct.getClientId()),list);
    }

    @Test
    public void getByProductId(){
        Mockito.when(repository.findByClientIdAndProductId(wishProduct.getClientId(), wishProduct.getProductId())).thenReturn(wishProduct);
        service = getService();
        Assert.assertEquals(service.get(wishProduct.getClientId(), wishProduct.getProductId()),wishProduct);
    }

    @Test(expected = WishProductNotFundException.class)
    public void getByProductIdNotFund(){
        Mockito.when(repository.findByClientIdAndProductId(wishProduct.getClientId(), wishProduct.getProductId())).thenReturn(null);
        service = getService();
        service.get(wishProduct.getClientId(), wishProduct.getProductId());
    }
    private WishProductService getService(){
        return new WishProductService(repository);
    }
}
