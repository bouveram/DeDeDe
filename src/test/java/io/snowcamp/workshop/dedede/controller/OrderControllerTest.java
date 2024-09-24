package io.snowcamp.workshop.dedede.controller;

import io.snowcamp.workshop.dedede.domain.Jewel;
import io.snowcamp.workshop.dedede.service.JewelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JewelService jewelService;

    @BeforeEach
    void setUp() {
        when(jewelService.createJewel(100)).thenReturn(Jewel.RING);
    }

    @Test
    void makeNewJewelOrder_with100Money() throws Exception {
        mockMvc.perform(put("/order/jewels").param("price", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("The Ring"))
                .andExpect(jsonPath("$.description").value("One ring to rule them all"));
    }
}