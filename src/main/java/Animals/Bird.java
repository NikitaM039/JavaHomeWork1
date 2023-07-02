package Animals;

public class Bird extends Dog{

    public Bird(String name, String color, int old, double weight) {
        super(name, color, old, weight);
        this.portion = 0.15;
        numberBird++;
    }

    public Bird(String name, String color, int old) {
        this(name, color, old,-1);
    }

    public Bird(String name, String color) {
        this(name, color,-1);
    }

    public Bird(String name) {
        this(name, "not defained");
    }

    private static int numberBird = 0;

    public static int getNumberBird() { return numberBird; }

    @Override
    public String getVoice() {
        return "Чык-чырык";
    }

    @Override
    public String getPlay() {
        return "Птица играет";
    }

    @Override
    public String getMoving() {
        return "Птица полетела";
    }
}
