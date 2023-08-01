package Task3Exceptions.service;

import Task3Exceptions.model.Person;

import java.io.IOException;

public interface PersonService <T extends Person>{
    void create(T person);
    void save() throws IOException;
}
