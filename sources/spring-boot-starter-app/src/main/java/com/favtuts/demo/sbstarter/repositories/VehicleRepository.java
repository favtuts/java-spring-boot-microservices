package com.favtuts.demo.sbstarter.repositories;

import com.favtuts.demo.sbstarter.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
}
