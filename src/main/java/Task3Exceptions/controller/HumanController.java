package Task3Exceptions.controller;

import Task3Exceptions.model.Human;
import Task3Exceptions.service.PersonService;

import java.io.IOException;

public class HumanController implements PersonController<Human>{
    private final PersonService<Human> humanService;

    public HumanController(PersonService<Human> humanService) {
        this.humanService = humanService;
    }

    @Override
    public void create(Human human) {
        humanService.create(human);
    }

    @Override
    public void save() throws IOException {
        humanService.save();
    }
}
