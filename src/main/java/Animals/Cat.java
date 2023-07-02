package Animals;

public class Cat extends Dog {

    public Cat(String name, String color, int old, double weight) {
        super(name, color, old, weight);
        this.portion = 2.0;
        numberCat++;
    }


    public Cat(String name, String color, int old) {
        this(name, color, old, 4);
    }


    public Cat(String name, String color) {
        this(name, color, 3);
    }


    public Cat(String name) {
        this(name, "not defained");
    }

    private static int numberCat = 0;

    public static int getNumberCat() {
        return numberCat;
    }

    @Override
    public String getVoice() {
        return "Мяу";
    }


    @Override
    public String getPlay() {
        return "Кот играется с клубком";
    }

    @Override
    public String getMoving() {
        return "Тыгыдычит";
    }

}
