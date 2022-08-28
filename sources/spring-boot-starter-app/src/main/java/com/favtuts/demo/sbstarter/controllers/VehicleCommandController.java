package com.favtuts.demo.sbstarter.controllers;

import com.favtuts.demo.sbstarter.dto.VehicleCreateDTO;
import com.favtuts.demo.sbstarter.dto.VehicleQueryDTO;
import com.favtuts.demo.sbstarter.dto.VehicleUpdateDTO;
import com.favtuts.demo.sbstarter.services.VehicleCommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/vehicles")
@Api(tags = "Vehicle Commands", value = "VehicleCommands", description = "Controller for Vehicle Commands")
public class VehicleCommandController {

    @Autowired
    private VehicleCommandService vehicleCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new vehicle")
    public ResponseEntity<UUID> createVehicle(@Valid @RequestBody VehicleCreateDTO vehicleCreateDTO) {
        return new ResponseEntity<>(vehicleCommandService.createVehicle(vehicleCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an existing vehicle")
    public ResponseEntity<VehicleQueryDTO> updateVehicle(@PathVariable(value = "id") UUID id,
                                                         @Valid @RequestBody VehicleUpdateDTO vehicleUpdateDTO) {
        return new ResponseEntity<>(vehicleCommandService.updateVehicle(id, vehicleUpdateDTO), HttpStatus.OK);
    }
}
