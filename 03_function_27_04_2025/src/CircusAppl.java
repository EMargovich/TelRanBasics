import java.util.function.Function;

public class CircusAppl {

    public static void main(String[] args) {
        lightOn();
        entertainers();
        lightOff();
    }


    private static void lightOff() {
        System.out.println("Light off");
    }

    private static void entertainers() {
        juggler();
        singer();
        clown();
    }

    private static void clown() {
        System.out.println("My name is Crasty!\n I am is clown!");
    }

    private static void singer() {
        System.out.println("My name is Filippo!\n I am a singer.");
    }

    private static void juggler() {
        System.out.println("My name is John Smith.");
        System.out.println("I am is juggler.");
    }

    private static void lightOn() {
        System.out.println("Light on");
    }



}
