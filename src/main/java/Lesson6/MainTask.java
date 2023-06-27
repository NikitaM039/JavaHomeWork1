package Lesson6;

//Урок 6. Хранение и обработка данных ч3: множество коллекций Set
//        Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
//        Реализовать в java.
//        Создать множество ноутбуков (ArrayList).
//        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
//        Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет.
//        Выводить только те ноутбуки, что соответствуют условию

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class MainTask {
    public static void main(String[] args) {

        Notebook N1 = new Notebook(15.6, 4, 8, "black");
        N1.setObjectName("N1");
        Notebook N2 = new Notebook(16.0, 8, 16, "white");
        N2.setObjectName("N2");
        Notebook N3 = new Notebook(12.0, 4, 8, "black");
        N3.setObjectName("N3");
        Notebook N4 = new Notebook(12.0, 4, 8, "black");
        N4.setObjectName("N4");
        Notebook N5 = new Notebook(17.0, 16, 16, "pink");
        N5.setObjectName("N5");

        List<Notebook> list = new ArrayList<>();

        Collections.addAll(list, N1, N2, N3, N4, N5);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите, искомое количество ядер (если не хотите искать по этому параметру, введите -1): ");
        Integer scannerCPU = scanner.nextInt();

        System.out.println("Введите, искомый размер RAM (если не хотите искать по этому параметру, введите -1): ");
        Integer scannerRam = scanner.nextInt();

        System.out.println("Введите, искомый размер экрана в дюймах (если не хотите искать по этому параметру, введите -1): ");
        Double scannerScreen = scanner.nextDouble();

        System.out.println("Введите, искомый цвет (если не хотите искать по этому параметру, введите -1): ");
        String scannerColor = scanner.next();


        boolean foundMatch = false;
        for (Notebook elem : list) {
            if ((scannerCPU == -1 || elem.getCPU().equals(scannerCPU)) &&
                    (scannerRam == -1 || elem.getRAM().equals(scannerRam)) &&
                    (scannerScreen == -1 || elem.getScreen().equals(scannerScreen)) &&
                    (scannerColor.equals("-1") || elem.getColor().equals(scannerColor))) {
                System.out.println(elem.getObjectName() + " => " + elem.getCPU() + " CPU; " + elem.getRAM() + " RAM; " + elem.getScreen() + " Screen; " + elem.getColor() + " Color; ");
                foundMatch = true;
            }
        }

        if (!foundMatch) {
            System.out.println("По вашему запросу ничего не найдено.");
        }
    }
}
