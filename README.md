# Vehicle Registration

## Compile

### Prerequisites
Maven 3.3.3 or higher is required. <br>
JDK 1.8 or higher is required.

### Sample build command that skips tests
```
mvn clean package -DskipTests
```

You should see the following if successful
```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 10.614 s
[INFO] Finished at: 2018-11-30T12:09:44-05:00
[INFO] Final Memory: 35M/148M
[INFO] ------------------------------------------------------------------------

```

### Sample build without running tests

```
mvn clean install -DskipTests
```

### run all tests and build
`mvn clean install`



# 1) Check the asyncronous rest endpoint

1) Use postman or soapUI to hit the rest endpoint using debug mode.

2) see the output response in the postman and in the response headers, find the location.

# 2) Check the error handling by passing the invalid transmissionType

# 3) Check the Logging using AOP

1) Place debug pointer in the com.siriusxm.vehicle.util.LoggingAspect methods to see in the console if the logs are printing.
