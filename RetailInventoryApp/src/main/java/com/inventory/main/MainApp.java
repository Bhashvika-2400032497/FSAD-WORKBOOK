package com.inventory.main;

import java.util.Scanner;
import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();
        int choice;

        do {
            System.out.println("\n==== Retail Inventory Menu ====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. Update Product Price & Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.print("Enter Product Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Enter Description: ");
                String desc = sc.nextLine();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                Product p = new Product(name, desc, price, qty);
                dao.addProduct(p);
                System.out.println("✅ Product Added Successfully");
                break;

            case 2:
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();

                Product prod = dao.getProduct(id);
                if (prod != null) {
                    System.out.println("Name: " + prod.getName());
                    System.out.println("Description: " + prod.getDescription());
                    System.out.println("Price: " + prod.getPrice());
                    System.out.println("Quantity: " + prod.getQuantity());
                } else {
                    System.out.println("❌ Product Not Found");
                }
                break;

            case 3:
                System.out.print("Enter Product ID: ");
                int uid = sc.nextInt();

                System.out.print("Enter New Price: ");
                double newPrice = sc.nextDouble();

                System.out.print("Enter New Quantity: ");
                int newQty = sc.nextInt();

                dao.updateProduct(uid, newPrice, newQty);
                System.out.println("✅ Product Updated Successfully");
                break;

            case 4:
                System.out.print("Enter Product ID to Delete: ");
                int did = sc.nextInt();

                dao.deleteProduct(did);
                System.out.println("✅ Product Deleted Successfully");
                break;

            case 5:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("❌ Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}

