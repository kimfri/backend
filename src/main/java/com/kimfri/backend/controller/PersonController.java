package com.kimfri.backend.controller;

import com.kimfri.backend.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


//    System.err.println("prop: '" + prop + "'");
//    Path path = Paths.get(prop);
//    System.err.println("path: " + path.toString() + " is a dir:" + Files.isDirectory(path));
//    Path path2 = Paths.get(prop, "configfile.txt");
//    try {
//      Files.readAllLines(path2).stream().forEach(System.err::println);
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }


    return new ResponseEntity<>(allPersonNames, HttpStatus.OK);
  }
}
