package com.kimfri.backend.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("JsonFileRepository")
public class JsonFileRepository implements FileDao {

  @Override
  public List<String> findAll() {
    return null;
  }
}
