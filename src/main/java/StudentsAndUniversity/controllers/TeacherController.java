package StudentsAndUniversity.controllers;

import StudentsAndUniversity.models.Teacher;
import StudentsAndUniversity.services.UserService;

import java.util.List;
public class TeacherController implements UserController {
    private final UserService<Teacher> teacherService;

    public TeacherController(UserService<Teacher> teacherService) {
        this.teacherService = teacherService;
    }

    //@PostMethod("/students")
    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        teacherService.create(fullName, age, phoneNumber, groupTitle);
    }

    //@GetMethod("/students")
    @Override
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    //@DeleteMethod("/students")
    @Override
    public int remove(String fullName) {
        return teacherService.remove(fullName);
    }

    @Override
    public List<Teacher> getAllSortByFullName() {
        return teacherService.getAllSortByFullName();
    }

    @Override
    public List<Teacher> getAllSortById() {
        return teacherService.getAllSortById();

    }
}
