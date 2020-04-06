package com.siriusxm.vehicle.util;

public enum VehicleExceptionCode implements ErrorCode {

    ACTIVE_VEHICLE_NOT_FOUND(CODE_700, "Vehicle not found");

    private final int id;
    private final String message;

    VehicleExceptionCode(int id, String msg) {
        this.id = id;
        this.message = msg;
    }

    public int getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }
}