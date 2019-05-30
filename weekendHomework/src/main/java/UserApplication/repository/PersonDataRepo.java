package UserApplication.repository;

import UserApplication.model.PersonData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface PersonDataRepo extends CrudRepository<PersonData,Long> {

}
