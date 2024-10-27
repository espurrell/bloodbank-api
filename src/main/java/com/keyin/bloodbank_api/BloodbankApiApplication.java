package com.keyin.bloodbank_api;

import com.keyin.bloodbank_api.repository.PersonRepository;
import com.keyin.bloodbank_api.repository.ReceiveRepository;
import com.keyin.bloodbank_api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloodbankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodbankApiApplication.class, args);
	}

	// Optional: Use CommandLineRunner to preload data into the database
	@Bean
	public CommandLineRunner initData(UserRepository userRepository,
									  PersonRepository personRepository,
									  ReceiveRepository receiveRepository,
									  DonationRepository donationRepository,
									  StockRepository stockRepository) {
		return args -> {
			// Preload some sample users
			userRepository.save(new User("employee1", "password123"));
			userRepository.save(new User("employee2", "password456"));

			// Preload some sample persons
			Person person1 = new Person(1, "John Doe", "123 Main St",
					LocalDate.of(1985, 5, 15), "555-555-5555",
					"M", "O+");
			Person person2 = new Person(2, "Jane Smith", "456 Oak Ave",
					LocalDate.of(1990, 8, 22), "555-123-4567",
					"F", "A+");

			personRepository.save(person1);
			personRepository.save(person2);

			// Preload some sample stocks
			stockRepository.save(new Stock("O-", 10));
			stockRepository.save(new Stock("A+", 20));

			// Preload some donations and receive events
			donationRepository.save(new Donation(LocalDate.now(), LocalTime.of(10, 30), person1, 500));
			receiveRepository.save(new Receive(LocalDate.now(), 2, "General Hospital", person2));

			System.out.println("Sample data loaded into the database.");
		};
	}
}

