package ToyLottery;

public class Toy {
    private final String art;
    private final String name;
    private int quantity;
    private short chance;

    public Toy(String art, String name, int quantity, short chance) {
        this.art = art;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }

    public String getArt() {
        return art;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public short getChance() {
        return chance;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setChance(short chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "Игрушка: " +
                "\tартикул = " + art + "," +
                "\tНазвание = " + name + "," +
                "\tКол-во = " + quantity + "," +
                "\t%% выпадения = " + chance;
    }
    public String toShortString(){
        return "Игрушка: " +
                "\tартикул = " + art + "," +
                "\tНазвание = " + name + "\n";
    }
}
