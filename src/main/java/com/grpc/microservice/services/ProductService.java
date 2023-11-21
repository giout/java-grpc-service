package com.grpc.microservice.services;

import com.grpc.microservice.ProductServiceGrpc.ProductServiceImplBase;
import com.grpc.microservice.db.ProductCrud;
import com.grpc.microservice.Result;
import com.grpc.microservice.Product.Builder;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import com.grpc.microservice.NoParam;
import com.grpc.microservice.Product;
import com.grpc.microservice.ProductDescription;
import com.grpc.microservice.ProductId;
import com.grpc.microservice.ProductList;

import java.util.ArrayList;

import com.grpc.microservice.db.ProductType;

@GrpcService
public class ProductService extends ProductServiceImplBase {
    ProductCrud crud = new ProductCrud();

    @Override
    public void createProduct(ProductDescription request, StreamObserver<Result> responseObserver) {
        boolean op = crud.insert(request.getDescription());

        Result response = Result.newBuilder()
                                .setSuccess(op)
                                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteProduct(ProductId request, StreamObserver<Result> responseObserver) {
        boolean op = crud.delete(request.getId());

        Result response = Result.newBuilder()
                                .setSuccess(op)
                                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void readProduct(NoParam request, StreamObserver<ProductList> responseObserver) {
        /* 
        ArrayList<ProductType> products = crud.select();
        ProductList.Builder listBuilder = ProductList.newBuilder();

        ProductList products = listBuilder.build();

        responseObserver.onNext(products);
        responseObserver.onCompleted(); */
    }               

    @Override
    public void updateProduct(Product request, StreamObserver<Result> responseObserver) {
        boolean op = crud.update(request.getId(), request.getDescription());

        Result response = Result.newBuilder()
                                .setSuccess(op)
                                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
}
