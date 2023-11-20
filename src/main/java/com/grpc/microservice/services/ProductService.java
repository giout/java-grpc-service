package com.grpc.microservice.services;

import java.util.ArrayList;

import org.lognet.springboot.grpc.GRpcService;

import com.grpc.microservice.ProductServiceGrpc.ProductServiceImplBase;
import com.grpc.microservice.Result;
import com.grpc.microservice.Product.Builder;

import io.grpc.stub.StreamObserver;

import com.grpc.microservice.NoParam;
import com.grpc.microservice.Product;
import com.grpc.microservice.ProductDescription;
import com.grpc.microservice.ProductId;
import com.grpc.microservice.ProductList;

@GRpcService
public class ProductService extends ProductServiceImplBase {

    @Override
    public void createProduct(ProductDescription request, StreamObserver<Result> responseObserver) {
        super.createProduct(request, responseObserver);
    }

    @Override
    public void deleteProduct(ProductId request, StreamObserver<Result> responseObserver) {
        super.deleteProduct(request, responseObserver);
    }

    @Override
    public void readProduct(NoParam request, StreamObserver<ProductList> responseObserver) {

        Builder p1=Product.newBuilder().setDescription("Sopa").setId(1);

        Builder p2=Product.newBuilder().setDescription("Refresco").setId(2);
        

        ProductList response = ProductList.newBuilder()
                                    .setSuccess(true)
                                    .setProducts(1, p1)
                                    .setProducts(1, p2)
                                    .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }               

    @Override
    public void updateProduct(Product request, StreamObserver<Result> responseObserver) {
        super.updateProduct(request, responseObserver);
    }
    
}
