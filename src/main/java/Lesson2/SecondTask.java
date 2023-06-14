package Lesson2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;

public class SecondTask {
    public static int[] getArray(int length, int min, int max){
        Random rand = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) array[i] = rand.nextInt((max - min) + 1) + min;
        return array;
    }
    public static int[] bobbleSortArray(int[]array) throws IOException {

        Logger logger = Logger.getLogger(SecondTask.class.getName());
        logger.setUseParentHandlers(false);

        FileHandler fh = new FileHandler("log.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.addHandler(fh);

        int[] arr = array.clone();
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                    logger.info(arr[i] + "<=>" + arr[i+1] ); // Вывод в лог
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        int[] array1 = getArray(10,1,10);
        int[] array2 = bobbleSortArray(array1);
        System.out.println("Исх. массив: " + Arrays.toString(array1));
        System.out.println("Рез. массив: " + Arrays.toString(array2));
    }
}
