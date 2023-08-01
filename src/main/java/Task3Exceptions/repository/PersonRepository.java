package Task3Exceptions.repository;

import Task3Exceptions.model.Person;

import java.io.IOException;

public interface PersonRepository <T extends Person>{
    void create(T person);
    void save() throws IOException;
}
