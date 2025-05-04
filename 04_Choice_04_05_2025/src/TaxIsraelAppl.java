public class TaxIsraelAppl {
    public static void main(String[] args) {
        double tax = calcTaxIsrael(8000, 2.25);
    }

    public static double calcTaxIsrael(double salary, double taxAllowance) {
        double res = -  taxAllowance * 584;

        if(salary < 7010) {
            res = res + salary * 0.1;
            return res >= 0 ? res : 0;
        } else {
            res = res + 7_010*0.1;
        }

        if (salary >= 7010 && salary < 10_060) {
            res = res + (salary - 7010) * 0.14;
            return res >= 0 ? res : 0;
        } else {
            res = res + (10_060 - 7010) * 0.14;
        }

        return res;
    }
}
