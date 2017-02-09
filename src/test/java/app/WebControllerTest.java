package app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.*;

/**
 * Created by cameronblanchard on 2/2/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

    @Autowired
    private MockMvc mvc;
    @Test
    public void createAddressBook() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/createAddressBook"))
                .andExpect(status().isOk());
    }

    @Test
    public void addBuddy() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/createAddressBook"))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/addBuddy?id=1&name=Cameron&number=1234567890"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"name\":\"Cameron\",\"number\":\"1234567890\"}")));
    }

    @Test
    public void getBuddies() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/createAddressBook"))
                .andExpect(status().isOk());


        mvc.perform(MockMvcRequestBuilders.get("/getBuddies?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"name\":\"Cameron\",\"number\":\"1234567890\"}]")));
    }

}