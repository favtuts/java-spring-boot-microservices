package com.favtuts.demo.sbstarter;

import com.favtuts.demo.sbstarter.entities.Vehicle;
import com.favtuts.demo.sbstarter.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@SpringBootApplication
public class SpringBootStarterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterAppApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public void run(String... args) throws Exception {

		Vehicle audi = new Vehicle();
		audi.setId(UUID.randomUUID());
		audi.setVehicleIdentityNumber("Reg#1234");
		audi.setMake("Audi");
		audi.setModel("Q5");

		vehicleRepository.save(audi);

		Vehicle tesla = new Vehicle();
		tesla.setId(UUID.randomUUID());
		tesla.setVehicleIdentityNumber("Reg#6789");
		tesla.setMake("Tesla");
		tesla.setModel("Model S");

		vehicleRepository.save(tesla);
	}
}