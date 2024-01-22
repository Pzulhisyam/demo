package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.example.demo.repository", "com.example.demo.repositoryImpl" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		{
			Abstract ab = new Citi();
			Banks bank = new Banks();
			bank.setBankName("City");
			bank.setBankNum(ab.getInterest());
			System.out.println("Citi rate" + bank.getBankNum());

			MountainBike mb = new MountainBike(3,100,25);
			System.out.println(mb.toString());

			for (int i = 1; i <= 5; i++) {

				System.out.println("i = " + i);
			}
		}


	}


}
