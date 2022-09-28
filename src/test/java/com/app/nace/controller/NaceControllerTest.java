package com.app.nace.controller;

import com.app.nace.domain.Nace;
import com.app.nace.service.NaceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(NaceController.class)
public class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private NaceService naceService;

    private Nace nace = new Nace(398481L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
            "This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.",
            "", "", "", "A");

    @Test
    public void save_shouldCreateNace() throws Exception {
        mockMvc.perform(post("/nace")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nace)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void getNaceById_shouldReturnNace() throws Exception {
        when(naceService.getNaceById(any())).thenReturn(nace);
        this.mockMvc.perform(get("/nace/398481"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("Order").value(398481))
                .andExpect(jsonPath("Code").value("A"))
                .andDo(print());
    }

    @Test
    public void getAllNaces_shouldReturnEmpty() throws Exception {
        when(naceService.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/nace/all"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getAllNaces_shouldReturnAll() throws Exception {
        when(naceService.findAll()).thenReturn(Arrays.asList(nace));
        mockMvc.perform(get("/nace/all"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
