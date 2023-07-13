/**
 *         Есть класс Фрукта. У фрукта есть вес.
 *         Есть 3 наследника: апельсин, яблоко и золотое яблоко.
 *         Нужно создать класс "Коробка с фруктами", в которую можно класть фрукты какого-то типа.
 *         После создания коробка пустая. В нее можно добавлять фрукты с помощью метода add().
 *         У коробки можно узнать сумарный вес с помощью метода getWeight().
 *         Содержимое коробки можно пересыпать в другую коробку. При этом исходная коробка очищается, а вторая наполняется.
 */

package BoxWithFruits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Main {

    public static void main(String[] args) {
//        Box<String> stringBox = new Box<>(); // не должно компилироваться

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange(1));
        orangeBox.add(new Orange(2));
//        orangeBox.add(new Apple(2));       // не должно компилироваться
//        orangeBox.add(new GoldenApple(2)); // не должно компилироваться

        System.out.println(orangeBox.getWeight()); // 3

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(1));
        appleBox.add(new GoldenApple(2)); // допустимый вариант
        System.out.println(appleBox.getWeight()); // 3

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(5)); // допустимый вариант
//        goldenAppleBox.add(new Apple(5));       // не должно компилироваться
        System.out.println(goldenAppleBox.getWeight()); // 5

        goldenAppleBox.moveTo(appleBox); // допустимый вариант
//        appleBox.moveTo(goldenAppleBox); // не должно компилироваться
//        orangeBox.moveTo(appleBox);      // не должно компилироваться

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox.moveTo(orangeBox2);
        System.out.println(orangeBox.getWeight()); // 0
        System.out.println(orangeBox2.getWeight()); // 3
    }

    // FIXME: 06.07.2023 Добавить нужный дженерик.
    static class Box<T extends Fruit> implements Iterable<T>{
        private List<T> fruits;

        public Box() {
            this.fruits = new ArrayList<>();
        }


        public void add(T fruit) {
            fruits.add(fruit);
        }


        public int getWeight(){
            int Sum = 0;
            for (T fruit: fruits) {
                Sum += fruit.getWeight();
            }
            return Sum;
        }


        public void moveTo (Box<? super T> fruits){
            for (T fruit: this.fruits) {
                fruits.add(fruit);
            }
            this.fruits.clear();
        }

        /**
         * Имплементированный итератор (foreach)
         * @return
         */

        @Override
        public Iterator<T> iterator() {
            Iterator<T> iter = new Iterator<T>() {
                int index;
                @Override
                public boolean hasNext() {
                    return index < fruits.size();
                }

                @Override
                public T next() {
                    return fruits.get(index++);
                }
            };
            return iter;
        }

    }

    static class Fruit {
        private final int weight;

        public Fruit(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class Orange extends Fruit {
        public Orange(int weight) {
            super(weight);
        }
    }

    static class Apple extends Fruit {
        public Apple(int weight) {
            super(weight);
        }
    }

    static class GoldenApple extends Apple {
        public GoldenApple(int weight) {
            super(weight);
        }
    }
}
