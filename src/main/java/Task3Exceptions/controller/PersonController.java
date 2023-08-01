package Task3Exceptions.controller;

import Task3Exceptions.model.Person;

import java.io.IOException;

public interface PersonController <T extends Person>{
    void create(T person);
    void save() throws IOException;
}
