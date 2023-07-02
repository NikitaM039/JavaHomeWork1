package Animals;

public class Dog extends Animals {

    public Dog(String name, String color, int old, double weight) {
        super(name, color, old, weight);
        this.portion = 3;
        numberDog++;
    }


    public Dog(String name, String color, int old) {
        this(name, color, old, 12);
    }


    public Dog(String name, String color) {
        this(name, color, 2);
    }

    public Dog(String name) {
        this(name, "Триколор");
    }

    private static int numberDog = 0;

    public static int getNumberDog() {
        return numberDog;
    }

    @Override
    public String getVoice() {
        return "Ваф";
    }

    @Override
    public String getPlay() {
        return "Играет";
    }

    @Override
    public String getMoving() {
        return "Побежал";
    }

    @Override
    protected double getEat(double eat) {
        double difference = eat - portion;
        if (difference == 0) {
            System.out.println("ID-" + this.ID + "(" + this.getName() + ")" + ": Я наелся\n");
        } else if (difference > 0) {
            System.out.printf("ID-" + this.ID + "(" + this.getName() + ")" + ": Я съел слишком много, здесь осталось %f еды\n", difference);
        } else {
            System.out.printf("ID-" + this.ID + "(" + this.getName() + ")" + ": Я голоден, мне нужно еще %s килограмм еды\n", Math.abs(difference));
        }
        return difference;
    }


}
