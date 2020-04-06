package com.siriusxm.vehicle.util;

import com.siriusxm.vehicle.exception.VehicleException;
import com.siriusxm.vehicle.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.siriusxm.vehicle.controller.VehicleController.createVehicle(..))")
    public void logTest(JoinPoint joinPoint) {
        Object[] lArgs = joinPoint.getArgs();
        Vehicle vehicle = (Vehicle) lArgs[0];
        log.info("Logged the request using AOP: {}", vehicle.toString());
    }

    @AfterThrowing(
            pointcut = "execution(* com.siriusxm.vehicle.*.*.*(..))",
            throwing = "ex")
    public void catchAllSQLSyntaxErrors(VehicleException ex) {
        log.info("Logged the Exception stacktrace using AOP: {}", ex.getMessage());
    }
}
