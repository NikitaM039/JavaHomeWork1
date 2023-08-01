package Task3Exceptions.view;

import Task3Exceptions.model.Person;

import java.io.IOException;
import java.text.ParseException;

public interface PersonView <T extends Person>{
    void create(T person);
    void save() throws IOException;

    boolean checkNumberParams(String strHuman);
    T validationHumanString(String[] params) throws Exception;
}
