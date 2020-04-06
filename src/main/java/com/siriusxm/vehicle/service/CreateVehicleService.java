package com.siriusxm.vehicle.service;

import com.siriusxm.vehicle.exception.VehicleException;
import com.siriusxm.vehicle.model.Vehicle;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.siriusxm.vehicle.util.VehicleExceptionCode.ACTIVE_VEHICLE_NOT_FOUND;

@Service
public class CreateVehicleService {

    @Async
    public void createVehicle(Vehicle vehicle) throws VehicleException, InterruptedException {
        Thread.sleep(5000);
        throw new VehicleException(ACTIVE_VEHICLE_NOT_FOUND);
    }

    public String getData(int id) {
        String resultData = "resultData";
        return resultData;
    }
}
