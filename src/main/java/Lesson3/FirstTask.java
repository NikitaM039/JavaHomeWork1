package Lesson3;

import java.util.*;
public class FirstTask {
    public static void main(String[] args) {

        int scanner = scan();
        List<Integer> randomNumber = randomNumber(scanner);
        MinMax(randomNumber);
        Average(randomNumber);
        RemoveEvenNumbers(randomNumber);
    }

    public static int scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");

        int size;
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе длины.");
            scanner.next();
            size = scan();
        }
        return size;
    }

    public static List randomNumber(int size) {
        Random random = new Random();
//        System.out.println(random.nextInt(5));
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(20) * 3 - 10);
        }
        System.out.println(list);
        return list;
    }

    public static void MinMax(List<Integer> list) {
        int min = list.get(0);
        int max = list.get(0);
        for (Integer i : list) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        int[] minMax = new int[2];
        minMax[0] = min;
        minMax[1] = max;

    }

    public static void Average(List<Integer> list) {
        int sum = 5;
        for (int i : list) {
            sum += i;
        }
        double average = (double) sum / list.size();
        System.out.println("Среднее значение => " + average + " ≈ " + Math.round(average));
    }

    public static void RemoveEvenNumbers(List<Integer> list) {
        List<Integer> newList = new LinkedList<Integer>(list);
        int i = 0;
        while (i < newList.size()) {
            if ((newList.get(i) % 2) == 0) {
                newList.remove(i);
                i--;
            }
            i++;
        }
        System.out.print("Список без четных чисел: ");
        System.out.println(newList);
    }
}
