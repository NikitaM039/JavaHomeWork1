package StudentsAndUniversity;

//1. Добавить преподавателей. Сделать TeacherView и доделать GroupService
//        2*. Реализовать UniversityApp, в котором будет поддерживаться while(true) {...} взаимотношение со всеми вью
//        с вводом команд в реальном режиме.
//        Возможный набор команд:
//        1. /get-student
//        2. /get-student name
//        3. /get-student id
//        6./get-group 11А
//        4. /create-student Ivan_Morozov 18 11A
//        5. /delete-teacher Maria_Pavlova
//        7./set-group-student-by-id 2 11Б
//
//        Имя пусть в консоли пишется через нижний прочерк, но заменяется на пробел впоследствии

import StudentsAndUniversity.controllers.GroupController;
import StudentsAndUniversity.controllers.StudentController;
import StudentsAndUniversity.controllers.TeacherController;
import StudentsAndUniversity.repositories.StudentRepository;
import StudentsAndUniversity.repositories.TeacherRepository;
import StudentsAndUniversity.services.GroupService;
import StudentsAndUniversity.services.StudentService;
import StudentsAndUniversity.services.TeacherService;
import StudentsAndUniversity.view.GroupView;
import StudentsAndUniversity.view.SortType;
import StudentsAndUniversity.view.StudentView;
import StudentsAndUniversity.view.TeacherView;
public class Main {

    private static StudentRepository studentRepository;
    private static TeacherRepository teacherRepository;

    private static StudentService studentService;
    private static TeacherService teacherService;
    private static StudentController studentController;
    private static TeacherController teacherController;


    public static void main(String[] args) {
        StudentView view = getStudentController();
        TeacherView teacherView = getTeacherController();
        GroupView groupView = getGroupView();


//        -------------------------------------------------------------------------

        view.create("Ivan Morozov", 18, "02", "11Б");
        view.create("Ivan Morozov", 18, "02", "11Б");
        view.create("Petr Vorobev", 19, "03", "10А");
        view.create("Sidor Sidorov", 20, "112", "10А");
        view.create("Elena Ivanova", 19, "911", "10А");
        view.create("Anna Morozova", 17, "01", "11А");

//        groupView.printAllFromGroup("11Б");
//        view.sendOnConsole();
        groupView.printAllFromGroupandId("11Б",Long.parseLong("2"));

//        view.sendOnConsole(SortType.NAME);
//        view.sendOnConsole(SortType.ID);
//
//        view.removeUser("Ivan Morozov");
//
//        view.sendOnConsole();

//        -------------------------------------------------------------------------

        teacherView.create("IVan Morozov_teacher", 28, "022", "11Б");
        teacherView.create("SIdor Sidorov_teacher", 40, "1122", "10А");
        teacherView.create("PEtr Vorobev_teacher", 29, "032", "10А");
        teacherView.create("IVan Morozov_teacher", 28, "022", "11Б");
        teacherView.create("Maria Pavlova", 35, "777", "12C");


        UniversityApp universityApp;
        boolean t = true;

        do {
            System.out.println("Введите строку для поиска: ");
            universityApp = new UniversityApp();
            System.out.println(universityApp.GetNum());
            switch (universityApp.GetNum()) {
                case 1:   //get-student
                    view.sendOnConsole();
                    t = false;
                    break;
                case 2://get-student name
                    view.sendOnConsole(SortType.NAME);
                    t = false;
                    break;
                case 3://get-student id
                    view.sendOnConsole(SortType.ID);
                    t = false;
                    break;
                case 4://create-student Ivan_Morozov 18 11A
                    view.create(
                            universityApp.getString1()[1].replace("_", " "),
                            Integer.parseInt(universityApp.getString1()[2]),
                            " ",
                            universityApp.getString1()[3]
                    );
                    view.sendOnConsole();
                    t = false;
                    break;
                case 5: //delete-teacher Maria_Pavlova
                    teacherView.removeUser(
                            universityApp.getString_1().replace("_", " ")
                    );
                    teacherView.sendOnConsole();
                    t = false;
                    break;
                case 6://get-group 11А
                    groupView.printAllFromGroup(universityApp.getString_1());
                    t = false;
                    break;
                case 7:  //set-group-student-by-id 2 11Б
                    groupView.printAllFromGroupandId(
                            universityApp.getString_2(),
                            Long.parseLong(universityApp.getString_1())
                    );
                    t = false;
                    break;
                default:
                    break;
            }
        } while (t);


//        groupView.printAllFromGroup("11Б");

//        teacherView.sendOnConsole();
//        teacherView.sendOnConsole(SortType.NAME);
//        teacherView.sendOnConsole(SortType.ID);
//
//        teacherView.removeUser("IVan Morozov_teacher");
//        teacherView.sendOnConsole();


    }


    private static StudentView getStudentController() {
        studentRepository = new StudentRepository();
        studentService = new StudentService(studentRepository);
        studentController = new StudentController(studentService);
        return new StudentView(studentController);
    }

    private static TeacherView getTeacherController() {
        teacherRepository = new TeacherRepository();
        teacherService = new TeacherService(teacherRepository);
        teacherController = new TeacherController(teacherService);
        return new TeacherView(teacherController);
    }


    private static GroupView getGroupView() {
        GroupService groupService = new GroupService(studentService, teacherService);
        GroupController groupController = new GroupController(groupService);
        return new GroupView(groupController);
    }

}
