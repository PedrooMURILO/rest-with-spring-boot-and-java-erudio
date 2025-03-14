package io.github.PedrooMURILO.services;

import io.github.PedrooMURILO.data.dto.v1.PersonDTO;
import io.github.PedrooMURILO.data.dto.v2.PersonDTOV2;
import io.github.PedrooMURILO.exception.ResourceNotFoundException;
import io.github.PedrooMURILO.mapper.custom.PersonMapper;
import io.github.PedrooMURILO.model.Person;
import io.github.PedrooMURILO.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static io.github.PedrooMURILO.mapper.ObjectMapper.parseListObjects;
import static io.github.PedrooMURILO.mapper.ObjectMapper.parseObject;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one Person!");
        var entity = converter.convertDTOToEntity(person);
        return converter.convertEntityToDTO(personRepository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }
}
