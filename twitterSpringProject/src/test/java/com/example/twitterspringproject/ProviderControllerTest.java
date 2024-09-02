package com.example.twitterspringproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProviderControllerTest extends BaseITTest{

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    private String BASE_URL;

    @BeforeEach
    void setup(){
        this.BASE_URL = String.format("http://localhost:%d/twitter/", this.port);
    }

    @WithMockUser(roles = "ROLE_USER")
    @Test
    void testApiProviderTest_OK() throws Exception {
        mockMvc.perform(get(this.BASE_URL + "/users/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(""));
    }
}
