package Lesson5;
//Урок 5. Хранение и обработка данных ч2: множество коллекций Map
//        Реализовать консольное приложение - телефонный справочник.
//        У одной фамилии может быть несколько номеров.
//        Пользователь может вводить команды:
//        1: ADD Ivanov 88005553535 - добавить в справочник новое значение. Первый аргумент - фамилия, второй - номер телефона
//        2: GET Ivanov - получить список всех номеров по фамилии
//        3: REMOVE Ivanov - удалить все номера по фамилии
//        4: LIST - Посмотреть все записи
//        5: EXIT - Завершить программу
//
//        Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом
//        .
//
//        Пример взаимодействия (=> - это вывод на консоль):
//        ADD Ivanov 8 800 555 35 35
//        ADD Ivanov 8 800 100 10 10
//        GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
//        ADD Petrov 8 555 12 34
//        LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
//        REMOVE Ivanov
//        LIST => Petrov = [8 555 12 34]
//        GET NoName => Не найдена запись с фамилией "NoName"
//        REMOVE NoName => Не найдена запись с фамилией "NoName"3

import java.util.*;

public class PhoneBook {
    public static Map<String, Set<String>> tel = new HashMap<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();

            String[] split = input.split(" ");
            String command = split[0];

            switch (command) {
                case "ADD" -> addContact(split);
                case "GET" -> getNumbers(split);
                case "REMOVE" -> removeContact(split);
                case "LIST" -> listContacts();
                case "EXIT" -> {
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Неверная команда.");
            }
        }
    }

    public static void addContact(String[] command) {
        if (command.length < 3) {
            System.out.println("Неверный формат команды ADD.");
            return;
        }

        String lastName = command[1];
        String phoneNumber = command[2];

        Set<String> numberSet = tel.getOrDefault(lastName, new HashSet<>());
        numberSet.add(phoneNumber);
        tel.put(lastName, numberSet);

        System.out.println(tel);

    }

    public static void getNumbers(String[] command) {
        if (command.length < 2) {
            System.out.println("Неверный формат команды GET.");
            return;
        }

        String lastName = command[1];
        Set<String> numberSet = tel.get(lastName);

        if (numberSet == null) {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        } else {
            System.out.println(numberSet);
        }
    }

    public static void removeContact(String[] command) {
        if (command.length < 2) {
            System.out.println("Неверный формат команды REMOVE.");
            return;
        }

        String lastName = command[1];
        Set<String> numberSet = tel.remove(lastName);

        if (numberSet == null) {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        } else {
            System.out.println("Записи с фамилией \"" + lastName + "\" удалены.");
        }
    }

    public static void listContacts() {
        for (Map.Entry<String, Set<String>> entry : tel.entrySet()) {
            String lastName = entry.getKey();
            Set<String> numberSet = entry.getValue();
            System.out.println(lastName + " = " + numberSet);
        }
    }
}
