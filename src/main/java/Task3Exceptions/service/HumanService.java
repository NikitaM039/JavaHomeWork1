package Task3Exceptions.service;

import Task3Exceptions.model.Human;
import Task3Exceptions.repository.PersonRepository;

import java.io.IOException;

public class HumanService implements PersonService<Human>{
    private final PersonRepository<Human> personRepository;

    public HumanService(PersonRepository<Human> personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void create(Human human){
        personRepository.create(human);
    }

    @Override
    public void save() throws IOException {
        personRepository.save();
    }
}
