package com.kimfri.backend.controller;

import com.kimfri.backend.service.IPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class PersonControllerTest {

  @InjectMocks
  PersonController personController;

  @Mock
  IPersonService iPersonService;

  private MockMvc mockMvc;

  //https://github.com/TechPrimers/test-controller-example
  //https://www.youtube.com/watch?v=pNiRNRgi5Ws&ab_channel=DanVega

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
  }
  @Test
  void kallekula() throws Exception {
    mockMvc.perform(get("/kalle"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello"));
  }

  @Test
  void pelle() throws Exception {
    when(iPersonService.getAllPersonNames()).thenReturn(Arrays.asList("apa", "bepa"));
    mockMvc.perform(get("/pelle"))
        .andExpect(status().isOk());

    verify(iPersonService).getAllPersonNames();
  }
}