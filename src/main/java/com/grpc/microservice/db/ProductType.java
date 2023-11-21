package com.grpc.microservice.db;

public class ProductType {
    public int id;
    public String description;

    public ProductType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
