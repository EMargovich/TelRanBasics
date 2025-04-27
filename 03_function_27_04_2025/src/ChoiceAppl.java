public class ChoiceAppl {

    public static void main(String[] args) {
        int height = 185;

        String st = height > 192 ? "V1:I am very tall" : "V1:I am not very tall";

        System.out.println(st);

        if(height > 192) {
            System.out.println("V2:I am very tall!");
        }
        else System.out.println("V2: Not a tall!");

        System.out.println("My height: " + height);




    }

}
