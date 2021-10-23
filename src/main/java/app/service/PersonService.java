package app.service;

import app.dto.SignUpDTO;
import app.entities.Person;
import app.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonService {

  @Autowired
  PersonRepo personRepo;

  public void savePerson(SignUpDTO signUpDTO){

    Person person = new Person();
    person.setPersonName(signUpDTO.getUsername());
    person.setInsTs(new Date());

    personRepo.save(person);
  }

}
