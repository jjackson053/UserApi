package UserApplication.service;

import UserApplication.model.PersonData;
import UserApplication.repository.PersonDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDataService {

    @Autowired
    PersonDataRepo personDataRepo;


    public void createPersonData(PersonData personData){
     personDataRepo.save(personData);
    }

    public Optional<PersonData> getPersonData (Long id) {
    return personDataRepo.findById(id);
    }

    public Iterable<PersonData> getAllPersonData(){
        return personDataRepo.findAll();
    }
    public void deletePersonData(Long id){
        personDataRepo.deleteById(id);
    }
    public void updatePersonData(PersonData personData, Long id){
        for(int i = 0; i< personDataRepo.count(); i++){
         if(personDataRepo.existsById(id)){
             personDataRepo.save(personData);
         }
        }
    }
}

