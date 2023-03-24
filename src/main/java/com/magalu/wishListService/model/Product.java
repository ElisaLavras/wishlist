package com.magalu.wishListService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Document("product")
public class Product {
    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "name")
    private String name;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Field(name = "created_date")
    private LocalDate createdDate;
}
