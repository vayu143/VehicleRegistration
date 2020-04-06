package com.siriusxm.vehicle.controller;

import com.siriusxm.vehicle.model.Vehicle;
import com.siriusxm.vehicle.service.CreateVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class VehicleController {

    @Autowired
    private CreateVehicleService createVehicleService;

    @PostMapping(path = "/vehicle-api/v1/vehicles/vehicle", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle, UriComponentsBuilder b) throws Exception {

        createVehicleService.createVehicle(vehicle);

        UriComponents uriComponents = b.path("/vehicle-api/v1/vehicles/vehicle/{vehicleId}").buildAndExpand(UUID.randomUUID());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(vehicle, headers, HttpStatus.OK);
    }
}
