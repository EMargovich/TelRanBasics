import java.util.Scanner;

public class TestConsole {
    public static void main(String[] args) {

        System.out.println("Stream test");
        try {
            int s = Integer.parseInt(System.console().readLine());
            System.out.println(s);
        }
        catch (NumberFormatException exc) {
            System.out.println("Введены некорректные данные!");
        }

        System.out.println("Console test");
        String s = System.console().readLine();
        System.out.println(s);

        System.out.println("Scanner test");
        Scanner coin = new Scanner(System.in);
        if(coin.hasNextInt()) {
            int a = coin.nextInt();
            System.out.println(a);
        }
        else System.out.println("Value not correct!");

        String b = coin.nextLine();
        System.out.println(b);

        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter string:");
        if(scan2.hasNextLine()) {
            String st = scan2.nextLine();
            System.out.println(st);
        }
    }
}
