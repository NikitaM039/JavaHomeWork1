package Animals;

import java.util.ArrayList;
public class Pets {
    public static void main(String[] args) {
        ArrayList<Animals> pet = new ArrayList<>();
        Dog dog = new Dog("Бубэн");
        Cat cat = new Cat("Кетка","Коричневый");
        Bird bird = new Bird("Вуди","Серый",2,0.50);
        pet.add(bird);
        pet.add(dog);
        pet.add(cat);
        System.out.println("Звери");
        for (int i = 0; i < pet.size(); i++) {
            System.out.println(pet.get(i));
        }
        System.out.println();
        System.out.println("Действия");
        for (int i = 0; i < pet.size(); i++) {
            System.out.printf("%S - %S - %S\n", pet.get(i).getVoice(), pet.get(i).getPlay(), pet.get(i).getMoving());
        }
        System.out.println();
        System.out.println("Кормежка");
        for (int i = 0; i < pet.size(); i++) {
            pet.get(i).getEat(2);
        }

    }
}
