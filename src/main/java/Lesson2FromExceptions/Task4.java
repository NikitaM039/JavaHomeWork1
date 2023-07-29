package Lesson2FromExceptions;

import java.util.Scanner;

/*
    Разработайте программу, которая выбросит Exception,
    когда пользователь вводит пустую строку.
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Task4 {
    public static void main(String[] args) {
        System.out.println("Введена строка: " + readConsole());
    }

    private static String readConsole() {
        System.out.print("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        if (result.trim().equals("")) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        return result.trim();
    }
}