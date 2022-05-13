package com.revature.p2backend;

import com.revature.p2backend.beans.repositories.CartRepository;
import com.revature.p2backend.beans.repositories.ProductRepository;
import com.revature.p2backend.beans.repositories.UserRepository;
import com.revature.p2backend.entities.Product;
import com.revature.p2backend.entities.Transactions;
import com.revature.p2backend.entities.*;
import com.revature.p2backend.utilities.StorageManager;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;

@SpringBootApplication
public class P2BackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(P2BackendApplication.class, args);
		System.out.println("start spring project");

		StorageManager storageManager = new StorageManager();
		storageManager.addAnnotatedClass(User.class);
		storageManager.addAnnotatedClass(Transactions.class);
		storageManager.addAnnotatedClass(Product.class);
		//context.start(); //for beans
		Session session = storageManager.initializeDataSource();


		User user = new User("czhu","password","chenxi","zhu", "chenxi@email.com","4444-4444-4444-4444","111-111-1111","john doe lane","free city","free state","USA");
		User user1 = new User("moneyman","password","james","franco", "jf@email.com","4444-4444-4444-4444","111-111-1111","john doe lane","free city","free state","USA");

		UserRepository uRepo = new UserRepository(session);
		uRepo.save(user);
		uRepo.save(user1);

		Product product = new Product("watch", "watch", 500.25, 100);
		Product product1 = new Product("earring", "earring", 125.39, 50);
		Product product2 = new Product("necklace", "necklace", 199.99, 60);

		ProductRepository pRepo = new ProductRepository(session);
		pRepo.save(product);
		pRepo.save(product1);
		pRepo.save(product2);

/*
		CartRepository cart = new CartRepository(session);
		cart.addProduct(product);
		cart.addProduct(product1);
		cart.addProduct(product2);


 */



	}

}
