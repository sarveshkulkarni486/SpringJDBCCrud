package com.example.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Product;
import com.example.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	Scanner sc = new Scanner(System.in);
	@Autowired
	ProductDao pdao;

	@Override
	public boolean AddProduct() {
		System.out.println("Enter product id: ");
		int id = sc.nextInt();
		System.out.println("Enter product name: ");
		String pname = sc.next();
		System.out.println("Enter product quantity: ");
		int qty = sc.nextInt();
		System.out.println("Enter product price: ");
		double price = sc.nextDouble();
		System.out.println("Enter product date in dd/mm/yyyy format: ");
		String dt = sc.next();
		LocalDate ldt = LocalDate.parse(dt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter cid: ");
		int cid = sc.nextInt();
		Product p = new Product(id, pname, qty, price, ldt, cid);
		return pdao.saveProduct(p);
	
	}

	@Override
	public boolean deleteProduct() {
		System.out.println("Enter pid: ");
		int pid = sc.nextInt();
		return pdao.deleteProduct(pid);
	}

	@Override
	public List<Product> getAll() {
		return pdao.FindAll();
	}

	@Override
	public boolean modify() {
		System.out.println("Enter pid: ");
		int pid = sc.nextInt();
		System.out.println("Enter qty: ");
		int qty = sc.nextInt();
		System.out.println("Enter price: ");
		double price = sc.nextDouble();
		return pdao.modifyProduct(pid, qty, price);
	}

	@Override
	public List<Product> byPrice() {
		return pdao.getByPrice();
	}

}
