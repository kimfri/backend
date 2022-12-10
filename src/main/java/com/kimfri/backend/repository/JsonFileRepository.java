package com.kimfri.backend.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Component
@Qualifier("JsonFileRepository")
public class JsonFileRepository implements FileDao {


  @Value("${system.config.dir}")
  private String prop;

  @Override
  public List<String> findAll() {
    Path path = Paths.get(prop, "configfile.txt");
    System.err.println("Will read from : " + prop.toString());
    return Arrays.asList("kalle", "pelle", "tjalle");
  }
}
