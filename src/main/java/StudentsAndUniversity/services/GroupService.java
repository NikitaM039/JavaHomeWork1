package StudentsAndUniversity.services;

import StudentsAndUniversity.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupService {
    private final StudentService studentService;
    private final TeacherService teacherService;


    public GroupService(StudentService studentService,  TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public List<User> getAllUsersFromGroup(String groupTitle) {
        List<User> teachers = new ArrayList<>(teacherService.getAllByTitile(groupTitle));
        List<User> users = new ArrayList<>(studentService.getAllByTitile(groupTitle));
//        teachers.addAll(users);
        Collections.addAll(teachers,users.toArray(new User[0]));

        return teachers;
    }

    public List<User> getAllUsersFromGroupandId (String groupTitle, Long Id) {
//        List<User> teachers = new ArrayList<>(teacherService.getAllByTitile(groupTitle));
        List<User> users = new ArrayList<>(studentService.getAllByTitleandId(groupTitle, Id));
//        teachers.addAll(users);
//        Collections.addAll(teachers,users.toArray(new User[0]));

        return users;
    }


}
