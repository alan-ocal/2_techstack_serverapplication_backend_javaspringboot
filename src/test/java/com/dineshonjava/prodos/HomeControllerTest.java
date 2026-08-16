package com.dineshonjava.prodos;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest; //1
import org.springframework.test.web.servlet.MockMvc; //2
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
//1
@WebMvcTest(HomeController.class)
public class HomeControllerTest {


    @Autowired
    private MockMvc mockMvc; //2

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) //the server must return a 200 OK status
                .andExpect(content().string(containsString ("Hello, Spring Boot!"))); //the return response message must be "Hello, Spring Boot! "
    }
}
