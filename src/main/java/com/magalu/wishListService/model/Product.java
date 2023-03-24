package com.magalu.wishListService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@Builder
@Document("product")
public class Product {
    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "name")
    private String name;
}
