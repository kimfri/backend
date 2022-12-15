package com.kimfri.backend.controller;

import com.kimfri.backend.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

  @Autowired
  @Qualifier("PersonService")
  IPersonService personService;

  public PersonController(IPersonService personService) {
    this.personService = personService;
  }

  @Value("${system.config.dir}")
  private String prop;


  @GetMapping(value = "/persons")
  public ResponseEntity<List<String>> getPersons() {
    final List<String> allPersonNames = personService.getAllPersonNames();

    return new ResponseEntity<>(allPersonNames, HttpStatus.OK);
  }

  @GetMapping(value = "/kalle")
  public ResponseEntity<String> getKalle() {
    return new ResponseEntity<>("Hello", HttpStatus.OK);
  }

  @GetMapping(value = "/pelle")
  public ResponseEntity<List<String>> getPalle() {
    return new ResponseEntity<>(personService.getAllPersonNames(), HttpStatus.OK);
  }

}
