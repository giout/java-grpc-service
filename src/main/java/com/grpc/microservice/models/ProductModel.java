package com.grpc.microservice.models;

public class ProductModel {
    public int id;
    public String description;

    public ProductModel(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
