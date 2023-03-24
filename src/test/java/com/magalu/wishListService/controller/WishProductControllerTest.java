package com.magalu.wishListService.controller;

import com.magalu.wishListService.model.WishProduct;
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

public class WishProductControllerTest {
    private WishProductController controller;
    @Mock
    private WishProductService service;

    private String productId = "ProductId";

    private WishProduct wishProduct;
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
    }
    @Test
    public void getTest(){
        List<WishProduct> list = Collections.singletonList(wishProduct);
        Mockito.when(service.get(wishProduct.getClientId())).thenReturn(list);

        controller = new WishProductController(service);

        Assert.assertEquals(controller.get(wishProduct.getClientId()).getBody(),list);
    }

    @Test
    public void getByProductId(){
        Mockito.when(service.get(wishProduct.getClientId(), wishProduct.getProductId())).thenReturn(wishProduct);

        controller = new WishProductController(service);

        Assert.assertEquals(controller.get(wishProduct.getClientId(), wishProduct.getProductId()).getBody(),wishProduct);
    }

    @Test
    public void removeProductFromWishList(){
        Mockito.when(service.remove(wishProduct.getClientId(), wishProduct.getProductId())).thenReturn(true);

        controller = new WishProductController(service);

        Assert.assertTrue(controller.remove(wishProduct.getClientId(), wishProduct.getProductId()).getBody());
    }
}
