package com.grpc.microservice.db;

import java.util.ArrayList;

import com.grpc.microservice.models.ProductModel;

import java.sql.*;

public class ProductCrud {
    Cnn cnn;
    PreparedStatement selectProducts;
    PreparedStatement insertProduct;
    PreparedStatement updateProduct;
    PreparedStatement deleteProduct;

    public ProductCrud(){
        this.cnn = new Cnn();   

        try {
            cnn.createConnection();

            selectProducts = cnn.connection.prepareStatement("SELECT * FROM products");
            insertProduct = cnn.connection.prepareStatement("INSERT INTO products (description) VALUES (?)");
            updateProduct = cnn.connection.prepareStatement("UPDATE products SET description=? WHERE id=?");
            deleteProduct = cnn.connection.prepareStatement("DELETE FROM products WHERE id=?");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<ProductModel> select(){
        try {
            ResultSet list = selectProducts.executeQuery();
            ArrayList<ProductModel> products = new ArrayList<>();

            while(list.next()){
                String description = list.getString(1);
                int id = list.getInt(2);
                products.add(new ProductModel(id, description));
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(String description){
        try {
            insertProduct.setString(1, description);
            insertProduct.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int id, String description){
        try {
            updateProduct.setString(1, description);
            updateProduct.setInt(2, id);
            updateProduct.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id){
        try {
            deleteProduct.setInt(1, id);
            deleteProduct.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
