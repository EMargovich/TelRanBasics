import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework_03 {

    public static void main(String[] args) {
        double res;

        // Part 1
      //  res = max(50,6);
      //  System.out.println(res);
      //  res = abs(-50);
      // System.out.println(res);
      //  res = min(50,6);
      //  System.out.println(res);


        System.out.println("\nCheck of the value by divisible by 3");
        checkDivision();
        checkDivision();

        System.out.println("\nCheck of the sum of three numbers for evenness and positivity");
        checkSum();

        System.out.println("\nCredit check");
        creditCheck();



    }

    private static void creditCheck() {

        boolean debt = false;

        //Get debt presence
        String st = reader("Please, indicate the presence of debt. Y/N:  ");

        switch (st) {
            case "Y" -> debt = true;
            case "N" -> debt = false;
            default ->  st = reader("Answer is not correct. Please, indicate the presence of debt. Y/N");
        }

        //Get income
        double income = -1.0;
        st = reader("Please, enter the income: ");
        do {
            try {
                income = Double.parseDouble(st);
            } catch (NumberFormatException exc) {
                st = reader("Input is not correct. Please, enter the income: ");
            }
        } while (income == -1.0);

        //Get age
        int age = -1;
        st = reader("Please, enter the age: ");
        do {
            try {
                age = Integer.parseInt(st);
            } catch (NumberFormatException exc) {
                st = reader("Input is not correct. Please, enter the age: ");
            }
        } while (age == -1.0);

        boolean credit = (!debt) & (income > 12000) & (age >= 21);

        if (credit) System.out.println("Loan approved.");
        else System.out.println("Loan not approved.");

    }

    //This method get string from console and check the value by divisible by 3
    private static void checkDivision () {

        String st = reader("Enter the number: ");

        try {
            double num = Double.parseDouble(st);
            String mes = num % 3 == 0 ? "" : " not";
            System.out.println("Your number is" + mes + " divisible by 3");
        }
        catch (NumberFormatException exc) {
            System.out.println("Incorrect data entered!");
        }


    }

    //This method checks the sum of three numbers for evenness and positivity
    private static void checkSum() {

        double n1, n2, n3, sum;

        try {
            String st = reader("Enter the first number: ");
            n1 = Double.parseDouble(st);
            st = reader("Enter the second number: ");
            n2 = Double.parseDouble(st);
            st = reader("Enter the third number: ");
            n3 = Double.parseDouble(st);

            sum = n1 + n2 + n3;

            String msg = ((sum > 0) && (sum % 2 == 0)) ?
                    "The sum of three numbers is evenness and positivity" : String.valueOf(sum);
            System.out.println(msg);
        }
        catch (NumberFormatException exc) {
            System.out.println("Incorrect data entered!");
        }
    }

    private static double max(double a, double b) {
        return a > b ? a : b;
    }

    private static double min(double a, double b) {
        return a < b ? a : b;
    }

    private static double abs(double a) {
        return a > 0 ? a : -a;
    }

    //The method give string with question and return string from console
    private static String reader(String text) {

        String inf = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));

        System.out.println(text);

        try {
            inf = br.readLine();
        }
        catch (IOException exc) {
            System.out.println("IO Exception " + exc);
        }

        return inf;
    }


}
