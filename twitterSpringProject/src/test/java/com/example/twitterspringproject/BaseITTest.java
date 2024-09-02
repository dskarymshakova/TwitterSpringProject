package com.example.twitterspringproject;

import com.example.twitterspringproject.configuration.AppTestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.ObjectNameManager;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:app-context.properties")
//@Import(value=AppTestConfiguration.class)
@AutoConfigureMockMvc
public class BaseITTest {
    @Autowired
    protected ObjectMapper objectMapper;
}
