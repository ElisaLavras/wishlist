package com.magalu.wishListService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Document("wish_product")
public class WishProduct {
    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "created_date")
    private LocalDate createdDate;

    @Field(name = "updated_date")
    private LocalDate updatedDate;

    @Field(name = "active")
    private boolean active;

    @Field(name = "product_id")
    private String productId;

    @Field(name = "product_name")
    private String productName;

    @Field(name = "client_id")
    private String clientId;


}
