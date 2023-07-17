package StudentsAndUniversity.view;

import StudentsAndUniversity.controllers.GroupController;

public class GroupView {
    private final GroupController controller;

    public GroupView(GroupController controller) {
        this.controller = controller;
    }

    public void printAllFromGroup(String groupTitle) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("ПРЕПОДАВАТЕЛИ  И СТУДЕНТЫ ГРУППЫ " + groupTitle);
        controller.getAllUsersFromGroup(groupTitle).forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
    }

    public void printAllFromGroupandId(String groupTitle, Long Id) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("СТУДЕНТЫ ГРУППЫ " + groupTitle + " " + Id);
        controller.getAllUsersFromGroupandId(groupTitle, Id).forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
    }

}
