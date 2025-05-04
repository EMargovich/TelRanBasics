public class BooleanOperationAppl {
    public static void main(String[] args) {
        int age = 13;
        
        checkArmy(age);
    
    }

    private static void checkArmy(int age) {
        if(!(age >= 18) || !(age < 45)) {
            System.out.println("You are not go to the army!");

        } else {
            System.out.println("Go to army!");
        }

    }



}
