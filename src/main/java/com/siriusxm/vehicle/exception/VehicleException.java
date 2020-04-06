package com.siriusxm.vehicle.exception;

import com.siriusxm.vehicle.util.VehicleExceptionCode;

public class VehicleException extends Exception {

    private final VehicleExceptionCode code;

    public VehicleException(VehicleExceptionCode code) {
        super();
        this.code = code;
    }

    public VehicleException(VehicleExceptionCode code, Throwable cause) {
        super(code.getMessage(), cause);
        this.code = code;
    }

    public VehicleException(Throwable cause, VehicleExceptionCode code) {
        super(cause);
        this.code = code;
    }

    public int getCode() {
        return this.code.getId();
    }

    public String getMessage() {
        return this.code.getMessage();
    }
}