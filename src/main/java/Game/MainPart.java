package Game;

import java.lang.reflect.*;

public class MainPart {
    public static final String ANSI_RESET   = "\u001B[0m";
    public static final String ANSI_RED     = "\u001B[31m";
    public static final String ANSI_GREEN   = "\u001B[32m";
    public static final String ANSI_YELLOW  = "\u001B[33m";
    public static final String ANSI_PURPLE  = "\u001B[35m";

    public static void main(String[] args) {
        Render render = new Render();

        Building building1 = new Building(100);
        building1.setCurrentHealthPoint(74);

        Hero hero1 = new Hero(100, 100);
        hero1.setCurrentHealthPoint(66);
        hero1.setCurrentManaPoint(33);

        Neutral neutral1 = new Neutral(100);
        neutral1.setCurrentHealthPoint(15);

        // В консоли должно быть примерно так: Текущий уровень здоровья: 50, максимальный уровень здоровья: 100

        System.out.println("Здание 1");
        render.showIndicator(building1);

        System.out.println("Герой 1");
        render.showIndicator(hero1);

        System.out.println("Нейтральный 1");
        render.showIndicator(neutral1);

    }

    static class Render {
        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            // Не должно быть упоминания конкретных классов!!!
            if (object instanceof HealthImpl){
                int maxHealth = ((HealthImpl) object).getMaxHealthPoint();
                int curHealth = ((HealthImpl) object).getCurrentHealthPoint();
                System.out.println(getColor(maxHealth) + "Максимальный уровень здоровья:" + maxHealth + ANSI_RESET);
                System.out.println(getColor(curHealth) + "Текущий уровень здоровья:" + curHealth + ANSI_RESET);
            }
            if (object instanceof ManaImpl){
                int maxMana = ((ManaImpl) object).getMaxManaPoint();
                int curMana = ((ManaImpl) object).getCurrentManaPoint();
                System.out.println(getColor(maxMana) + "Максимальный уровень маны:" + maxMana + ANSI_RESET);
                System.out.println(getColor(curMana) + "Текущий уровень маны:" + curMana + ANSI_RESET);
            }
        }
        private String getColor(int res){
            String color = ANSI_GREEN;
            if (res < 75) color = ANSI_YELLOW;
            if (res < 50) color = ANSI_PURPLE;
            if (res < 25) color = ANSI_RED;
            return color;
        }

    }

    static class Building implements HealthImpl {
        private final int maxHealthPoint;
        private int currentHealthPoint;
        public Building(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }
        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }

        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }
    }

    static class Hero implements HealthImpl, ManaImpl {
        private final int maxHealthPoint;
        private int currentHealthPoint;
        private final int maxManaPoint;
        private int currentManaPoint;
        public Hero(int maxHealthPoint, int maxManaPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.maxManaPoint = maxManaPoint;

            this.currentHealthPoint = maxHealthPoint;
            this.currentManaPoint = maxManaPoint;
        }
        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }
        public void setCurrentManaPoint(int currentManaPoint) {
            this.currentManaPoint = currentManaPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }
        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }
        @Override
        public int getCurrentManaPoint() {
            return currentManaPoint;
        }
        @Override
        public int getMaxManaPoint() {
            return maxManaPoint;
        }
    }

    static class Neutral implements HealthImpl {
        private final int maxHealthPoint;
        private int currentHealthPoint;
        public Neutral(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }
        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }
        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }
    }
}
