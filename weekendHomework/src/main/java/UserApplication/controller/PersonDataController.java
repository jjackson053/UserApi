package UserApplication.controller;

import UserApplication.model.PersonData;
import UserApplication.service.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
//@CrossOrigin("*")
@CrossOrigin (origins = "http://localhost:4200")

public class PersonDataController {

    @Autowired
    private PersonDataService personDataService;

    @RequestMapping(value = "/personData", method = RequestMethod.GET)
    public ResponseEntity<Iterable<PersonData>> getPersonDataRecords(){
        Iterable<PersonData> allPersonData = personDataService.getAllPersonData();
        return new ResponseEntity<>(allPersonData , HttpStatus.OK);
    }

    @RequestMapping(value = "/personData", method = RequestMethod.POST)
    public ResponseEntity<?> createPersonDataRecord(@RequestBody PersonData personData){
        personDataService.createPersonData(personData);

        HttpHeaders responseHeader = new HttpHeaders();
        URI newpersonData = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(personData.getId())
                            .toUri();
        responseHeader.setLocation(newpersonData);
        return new ResponseEntity<>(null,responseHeader,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/personData/{personDataId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonDataRecord(@PathVariable Long personDataId){
        return new ResponseEntity<>(personDataService.getPersonData(personDataId),HttpStatus.OK);
    }

    @RequestMapping(value = "/personData/{personDataId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePersonDataRecord (@RequestBody PersonData personData, @PathVariable Long personDataId){
    personDataService.updatePersonData(personData,personDataId);
    return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/personData/{personDataId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePersonDataRecord (@PathVariable Long personDataId){
        personDataService.deletePersonData(personDataId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
