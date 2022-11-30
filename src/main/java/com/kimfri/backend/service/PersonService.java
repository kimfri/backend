package com.kimfri.backend.service;

import com.kimfri.backend.repository.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("PersonService")
public class PersonService implements IPersonService {

  @Autowired
  @Qualifier("JsonFileRepository")
  private FileDao fileDao;

  @Override
  public List<String> getAllPersonNames() {
    return fileDao.findAll();
  }
}
