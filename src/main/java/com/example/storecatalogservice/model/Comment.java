package com.example.storecatalogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Comment {

    @JsonIgnore
    private Long id;

    private String text;


    private Timestamp createdAt;

    private Long profile_id;
    private Long product_id;
}
