public class TaxIsraelAppl {
    public static void main(String[] args) {
        double tax = calcTaxIsrael(100000, 2.25);
        System.out.println(tax);
    }

    public static double calcTaxIsrael(double salary, double taxAllowance) {
        double res = - taxAllowance * 219;

        if(salary < 7010) {
            res = res + salary * 0.1;
            return res >= 0 ? res : 0;
        } else {
            res = res + 7_010*0.1;
        }

        if (salary >= 7011 && salary < 10_060) {
            res = res + (salary - 7011) * 0.14;
            return res >= 0 ? res : 0;
        } else {
            res = res + (10_060 - 7011) * 0.14;
        }

        if (salary >= 10_061 && salary < 16_150) {
            res = res + (salary - 10_061) * 0.2;
            return res >= 0 ? res : 0;
        } else {
            res = res + (16_150 - 10_061) * 0.2;
        }

        if (salary >= 16_151 && salary < 22_440) {
            res = res + (salary - 16_151) * 0.31;
            return res >= 0 ? res : 0;
        } else {
            res = res + (22_440 - 16_151) * 0.31;
        }

        if (salary >= 22_441 && salary < 46_690) {
            res = res + (salary - 22_441) * 0.35;
            return res >= 0 ? res : 0;
        } else {
            res = res + (46_690 - 22_441) * 0.35;
        }

        if (salary  >= 46_691 && salary < 60_130) {
            res = res + (salary - 46_691) * 0.47;
            return res >= 0 ? res : 0;
        } else {
            res = res + (60_130 - 46_691) * 0.47;
        }

        res = res + (salary - 60_131) * 0.5;

        return res >= 0 ? res : 0;
    }
}
