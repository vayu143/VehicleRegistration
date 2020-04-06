package com.siriusxm.vehicle.exception;

import com.siriusxm.vehicle.utility.TransmissionType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CustomerTypeSubSetValidator implements ConstraintValidator<CustomerTypeSubset, TransmissionType> {
    private TransmissionType[] subset;

    @Override
    public void initialize(CustomerTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(TransmissionType value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
