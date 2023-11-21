package com.grpc.microservice.services;

import com.grpc.microservice.ProductServiceGrpc.ProductServiceImplBase;
import com.grpc.microservice.Result;
import com.grpc.microservice.Product.Builder;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import com.grpc.microservice.NoParam;
import com.grpc.microservice.Product;
import com.grpc.microservice.ProductDescription;
import com.grpc.microservice.ProductId;
import com.grpc.microservice.ProductList;

@GrpcService
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
                                        .setSuccess(true)                            .addProducts(p1) 
                                        .addProducts(p2) 
                                        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }               

    @Override
    public void updateProduct(Product request, StreamObserver<Result> responseObserver) {
        super.updateProduct(request, responseObserver);
    }
    
}
