package com.favtuts.demo.sbstarter.services;

import com.favtuts.demo.sbstarter.dto.VehicleCreateDTO;
import com.favtuts.demo.sbstarter.dto.VehicleQueryDTO;
import com.favtuts.demo.sbstarter.dto.VehicleUpdateDTO;

import java.util.UUID;

public interface VehicleCommandService {

    public UUID createVehicle(VehicleCreateDTO vehicleCreateDTO);
    public VehicleQueryDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO);

}
