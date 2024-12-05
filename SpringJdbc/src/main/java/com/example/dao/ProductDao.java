package com.example.dao;

import java.util.List;

import com.example.beans.Product;

public interface ProductDao {

	boolean saveProduct(Product p);

	boolean deleteProduct(int pid);

	List<Product> FindAll();

	boolean modifyProduct(int pid, int qty, double price);

	List<Product> getByPrice();

}
