package StudentsAndUniversity;

import java.util.Scanner;

public class UniversityApp {

    Scanner scanner = new Scanner(System.in);

    String[] string1 = scanner.nextLine().split(" ");

    public String[] getString1() {
        return string1;
    }

    public String getString_1() {
        return string1[1];
    }

    public String getString_2() {
        return string1[2];
    }


    public int GetNum() {
        String str = string1[0];

        if (str.startsWith("/get-student")) {
            if (str.equals("/get-student") && string1.length == 1) {
                return 1;
            } else if (str.equals("/get-student") && getString_1().equals("name")) {
                return 2;
            } else if (str.equals("/get-student") && getString_1().equals("id")) {
                return 3;
            }
        } else if (str.equals("/create-student") && string1.length == 4) {
            return 4;
        } else if (str.equals("/delete-teacher") && string1.length == 2) {
            return 5;
        } else if (str.equals("/get-group") && string1.length == 2) {
            return 6;
        } else if (str.equals("/set-group-student-by-id") && string1.length == 3) {
            return 7;
        }

        return -1;
    }

}