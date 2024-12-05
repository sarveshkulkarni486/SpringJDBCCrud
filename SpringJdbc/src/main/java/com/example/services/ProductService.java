package com.example.services;

import java.util.List;

import com.example.beans.Product;

public interface ProductService {

	boolean AddProduct();

	boolean deleteProduct();

	List<Product> getAll();

	boolean modify();

	List<Product> byPrice();

}
