package com.example.demo;

import com.example.demo.enteties.SPID;
import com.example.demo.enteties.Status;
import com.example.demo.enteties.User;
import com.example.demo.service.SPIDService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	public UserService userService;

	@Autowired
	public SPIDService spidService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User createdUser1 = userService.createUser(new User(1, "Fabjo", "Koci"));
		User createdUser2 = userService.createUser(new User(2, "Jhon", "Big"));

		userService.editUser(createdUser1, 1, "jake", "ara");
		userService.editUser(createdUser2, 2, "dev", "lushi");

		SPID createdSpid1 = spidService.createSpid(new SPID(1, createdUser1, Status.PENDING, "Spidi i Fabjos"));
		SPID createdSpid2 = spidService.createSpid(new SPID(2, createdUser1, Status.PENDING, "Spidi i Jhoon"));

		spidService.editSpid(createdSpid1, 1, createdUser1, Status.APPROVED, "Spidi i Fabjos");
		spidService.editSpid(createdSpid2, 2, createdUser2, Status.APPROVED, "Spidi i Jhoon");

		System.out.println("List of spids:\n");
		System.out.println("ID: " + createdSpid1.getId() + " Status: " + createdSpid1.getStatus() + " Description: " + createdSpid1.getDescription());
		System.out.println("ID: " + createdSpid2.getId() + " Status: " + createdSpid2.getStatus() + " Description: " + createdSpid2.getDescription());

		System.out.println("\nList of spids connected to a user:\n");
		System.out.println("Username: " + createdUser1.getUsername() + " is connected to SPID: " + createdSpid1.getUser().getUsername().equals(createdUser1.getUsername()));
		System.out.println("Username: " + createdUser2.getUsername() + " is connected to SPID: " + createdSpid2.getUser().getUsername().equals(createdUser2.getUsername()));

	}
}