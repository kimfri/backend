package com.kimfri.backend.controller;

import com.kimfri.backend.service.IPersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class PersonControllerTest {

  @Mock
  IPersonService iPersonService;

  @Autowired
  PersonController personController;

  @Test
  void getPersons() {
    when(iPersonService.getAllPersonNames()).thenReturn(Arrays.asList("kalle"));
    final ResponseEntity<List<String>> persons = personController.getPersons();
    System.err.println("Size of responseBody " + persons.getBody().size());
    System.err.println("Code: " + persons.getStatusCode().toString());
  }
}