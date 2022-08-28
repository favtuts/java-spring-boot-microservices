package com.favtuts.demo.sbstarter.services;

import com.favtuts.demo.sbstarter.dto.VehicleQueryDTO;

import java.util.List;
import java.util.UUID;

public interface VehicleQueryService {

    public VehicleQueryDTO getVehicle(UUID id);
    public List<VehicleQueryDTO> listAllVehicles();
}
