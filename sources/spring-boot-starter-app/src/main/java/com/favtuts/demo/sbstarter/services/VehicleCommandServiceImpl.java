package com.favtuts.demo.sbstarter.services;

import com.favtuts.demo.sbstarter.dto.VehicleCreateDTO;
import com.favtuts.demo.sbstarter.dto.VehicleQueryDTO;
import com.favtuts.demo.sbstarter.dto.VehicleUpdateDTO;
import com.favtuts.demo.sbstarter.entities.Status;
import com.favtuts.demo.sbstarter.entities.Vehicle;
import com.favtuts.demo.sbstarter.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public UUID createVehicle(VehicleCreateDTO vehicleCreateDTO) {
        Vehicle newVehicle = new Vehicle();

        newVehicle.setId(UUID.randomUUID());
        newVehicle.setVehicleIdentityNumber(vehicleCreateDTO.getVehicleIdentityNumber());
        newVehicle.setMake(vehicleCreateDTO.getMake());
        newVehicle.setModel(vehicleCreateDTO.getModel());
        newVehicle.setStatus(String.valueOf(Status.FOR_SALE));

        return vehicleRepository.save(newVehicle).getId();
    }

    @Override
    public VehicleQueryDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO) {
        if (vehicleRepository.findById(id).isPresent()) {
            Vehicle existingVehicle = vehicleRepository.findById(id).get();

            existingVehicle.setMake(vehicleUpdateDTO.getMake());
            existingVehicle.setModel(vehicleUpdateDTO.getModel());

            Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

            return new VehicleQueryDTO(updatedVehicle.getId(), updatedVehicle.getVehicleIdentityNumber(),
                    updatedVehicle.getMake(), updatedVehicle.getModel());
        } else {
            return null;
        }
    }
}
