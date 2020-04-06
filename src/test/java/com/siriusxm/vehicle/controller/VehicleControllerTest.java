package com.siriusxm.vehicle.controller;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void correctVehicleRequest() throws Exception {
        String jsonMimeType = "application/json";
        String vehicle = "{\n" +
                "  \"vin\": \"1A4AABBC5KD501999\",\n" +
                "  \"year\": 2019,\n" +
                "  \"make\": \"FCA\",\n" +
                "  \"model\": \"RAM\",\n" +
                "  \"transmissionType\": \"MANUAL\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/vehicle-api/v1/vehicles/vehicle")
                .content(vehicle)
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(jsonMimeType));
    }

    @Test
    public void inValidVehicleRequest() throws Exception {
        String jsonMimeType = "application/json";
        String vehicle = "{\n" +
                "  \"vin\": \"1A4AABBC5KD501999\",\n" +
                "  \"year\": 2019,\n" +
                "  \"make\": \"FCA\",\n" +
                "  \"model\": \"RAM\",\n" +
                "  \"transmissionType\": \"MANU\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/vehicle-api/v1/vehicles/vehicle")
                .content(vehicle)
                .contentType(jsonMimeType))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is("Validation Failed")))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(jsonMimeType));
    }
}
