package ToyLottery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Toy Robot       = new Toy("art-r1","Робот", 15, (short) 10);
        Toy Barbie      = new Toy("art-d1","Барби", 23, (short) 10);
        Toy Car         = new Toy("art-c1","Машинка", 37, (short) 20);
        Toy Lego  = new Toy("art-e1","Лего", 52, (short) 20);
        Toy Trinket     = new Toy("art-t1","Безделушка", 157, (short) 40);

        Lottery raffleToy = new Lottery();

        raffleToy.add(Robot);
        raffleToy.add(Barbie);
        raffleToy.add(Car);
        raffleToy.add(Lego);
        raffleToy.add(Trinket);

        raffleToy.showList();
        System.out.println("==========");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Команды - add, edit, del, list, win, exit");
            System.out.print("Введите команду: >");
            switch (scanner.nextLine()) {
                case "add" -> {
                    if (raffleToy.add(raffleToy.getToyConsole())){
                        System.out.println("Игрушка добавлена!");
                    }
                }
                case "edit" -> {
                    System.out.print("Введите артикул игрушки для изменения: >");
                    raffleToy.edit(scanner.nextLine());
                }
                case "del" -> {
                    System.out.print("Введите артикул игрушки для удаления: >");
                    raffleToy.delete(scanner.nextLine());
                }
                case "list" -> raffleToy.showList();
                case "win" -> raffleToy.winlot();
                case "exit" -> System.exit(0);
            }
        }
    }
}
