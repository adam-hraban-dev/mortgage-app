package cz.ahraban.mortgage.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.ahraban.mortgage.domainapi.CustomerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCustomer() throws Exception {
        MvcResult updatedCustomerResult = mockMvc.perform(MockMvcRequestBuilders.post("/customer")
                                                                                .contentType(MediaType.APPLICATION_JSON)
                                                                                .content(objectMapper.writeValueAsString(CustomerDTO.builder()
                                                                                                                                    .firstName("A")
                                                                                                                                    .lastName("B")
                                                                                                                                    .email("a@b.c")
                                                                                                                                    .build())))
                                                 .andExpect(status().isCreated())
                                                 .andReturn();

        String responseBody = updatedCustomerResult.getResponse().getContentAsString();
        CustomerDTO responseDTO = objectMapper.readValue(responseBody, CustomerDTO.class);

        Assertions.assertEquals(responseDTO.getId(), 1);
        Assertions.assertEquals(responseDTO.getFirstName(), "A");
        Assertions.assertEquals(responseDTO.getLastName(), "B");
        Assertions.assertEquals(responseDTO.getEmail(), "a@b.c");
    }
}
