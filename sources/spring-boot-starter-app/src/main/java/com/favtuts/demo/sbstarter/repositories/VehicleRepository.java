package com.favtuts.demo.sbstarter.repositories;

import com.favtuts.demo.sbstarter.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
}
