package com.example.storecatalogservice.service;

import com.example.storecatalogservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductCatalogService {

    @Autowired
    private RestTemplate restTemplate;

    public Catalog getProductById(Long productId) {
        List<Product> productList = new ArrayList<>();


            Product product = restTemplate.getForObject("http://localhost:8081/products/" + productId, Product.class);
            Rating rating = restTemplate.getForObject("http://localhost:8082/ratings/" + productId, Rating.class);


        return new Catalog(product.getTitle(), rating.getRating());

    }


    public User getUserData(Long userId) {

        UserRating ratings = restTemplate.getForObject("http://localhost:8082/ratings/users/" + userId, UserRating.class);

        User user = restTemplate.getForObject("http://localhost:8083/profile/" + userId, User.class);

        UserCart cart = restTemplate.getForObject("http://localhost:8084/cart/" + userId, UserCart.class);

        user.setCartList(cart);
        user.setUserRating(ratings);

        return user;
    }
}
