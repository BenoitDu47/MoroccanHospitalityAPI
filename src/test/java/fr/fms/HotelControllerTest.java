package fr.fms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import fr.fms.service.HotelServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelServiceImpl hotelService;

    @Test
    public void testGetHotels() throws Exception {
        mockMvc.perform(get("/hotels"))
                .andExpect(status().isOk());
    }
}

