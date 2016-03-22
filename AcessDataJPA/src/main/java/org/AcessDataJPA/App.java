package org.AcessDataJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		log.info("Countries found with findAll():");
		for (Country country1 : countryRepository.findAll()) {
			log.info(country1.toString());
		}
		
		Country country2 = countryRepository.findOne(3);
		log.info("Country found with findOne(3):");
		log.info(country2.toString());
		
		log.info("Country found with findByCurrency(EUR)");
		for (Country country3 : countryRepository.findByCurrency("EUR")) {
			log.info(country3.toString());
		}
		

	}
}
