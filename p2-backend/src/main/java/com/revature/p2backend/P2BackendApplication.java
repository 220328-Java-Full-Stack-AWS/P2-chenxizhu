package com.revature.p2backend;

import com.revature.p2backend.entities.Product;
import com.revature.p2backend.entities.Transactions;
import com.revature.p2backend.entities.User;
import com.revature.p2backend.utilities.StorageManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P2BackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(P2BackendApplication.class, args);
		System.out.println("start spring project");

		StorageManager storageManager = new StorageManager();
		storageManager.addAnnotatedClass(User.class);

		storageManager.addAnnotatedClass(Transactions.class);
		storageManager.addAnnotatedClass(Product.class);

		Product product = new Product("watch", "watch", 500.25, 100);
		Product product1 = new Product("earring", "earring", 125.39, 50);
		Product product2 = new Product("necklace", "necklace", 199.99, 60);
	}

}
