package com.example.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.beans.Product;
import com.example.services.*;
public class TestProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService pservice = (ProductService) ctx.getBean("productServiceImpl");
		int choice=0;
		do {
			System.out.println("Enter your choice: ");
			System.out.println("1. Add product \n2. Delete Product \n3. Display Product");
			System.out.println("4. Modify product \n5. display by price \n6. Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				boolean res = pservice.AddProduct();
				if(res) {
					System.out.println("Data inserted: ");
				}
				break;
			case 2:
				res = pservice.deleteProduct();
				if(res) {
					System.out.println("Date deleted: ");
				}
			case 3: 
				List<Product> plist = pservice.getAll();
				if(plist!=null) {
					plist.forEach(System.out::println);
				}
				break;
			case 4:
				res = pservice.modify();
				if(res) {
					System.out.println("Product details updated successfully: ");
				}
				break;
			case 5:
				plist = pservice.byPrice();
				if(plist!=null) {
					plist.forEach(System.out::println);
				}
				break;
			case 6:
				System.out.println("Thank you visit again..");
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}while(choice!=6);

	}

}
