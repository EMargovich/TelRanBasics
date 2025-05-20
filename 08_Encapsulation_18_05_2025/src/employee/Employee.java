package employee;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private double taxAlloance;
    private String gender;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getTaxAlloance() {
        return taxAlloance;
    }

    public String getGender() {
        return gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTaxAlloance(double taxAlloance) {
        this.taxAlloance = taxAlloance;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee(int id, String name, double salary, double taxAlloance, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.taxAlloance = taxAlloance;
        this.gender = gender;
    }

    public void display() {
        System.out.println("ID: " + id + ", name: " + name + ", salary: "
            + salary + ", tax: " + taxAlloance + ", gender " + gender);
    }

    public double calcTaxIsrael() {
        double[] level = {0, 7010, 10060, 16150, 22440, 46690, 60130};
        double[] rates = {0.1, 0.14, 0.2, 0.31, 0.35, 0.47, 0.5};
        double res = -(taxAlloance*223);
        for (int i = 0; i < level.length-1; i++) {
            if(salary > level[i] && salary <= level[i + 1]) {
                res = res + (salary - level[i])*rates[i];
                return res < 0 ? 0 : res;
            } else {
                res = res + (level[i + 1] - level[i]) * rates[i];
            }
        }
        res = res * (salary - level[level.length - 1]) * rates[rates.length - 1];
        return  res < 0 ? 0 : res;
    }

    public static double salaryNetto(double salary, double tax) {
        return salary - tax;
    }
}
