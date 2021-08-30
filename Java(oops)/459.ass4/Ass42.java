import java.util.Scanner;

public class Ass42 {
    public static void main(String[] args) {

        double iid, bas, hrs;
        String nam;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the clerk's id: ");
        iid = sc.nextDouble();
        System.out.println("Enter the clerk's name: ");
        sc.nextLine();
        nam = sc.nextLine();
        System.out.println("Enter the clerk's basic pay: ");
        bas = sc.nextDouble();
        System.out.println("Enter the clerk's extra hours he/she has done: ");
        hrs = sc.nextDouble();

        Clerk ck = new Clerk(iid, nam, bas, hrs);
        ck.salary();
        System.out.println("***********************************************************************");

        System.out.println("Enter the officer's id: ");
        iid = sc.nextDouble();
        System.out.println("Enter the officer's name: ");
        sc.nextLine();
        nam = sc.nextLine();
        System.out.println("Enter the officer's basic pay: ");
        bas = sc.nextDouble();

        Officer ofr = new Officer(iid, nam, bas);
        ofr.salary();
        System.out.println("***********************************************************************");

        System.out.println("Enter the manager's id: ");
        iid = sc.nextDouble();
        System.out.println("Enter the manager's name: ");
        sc.nextLine();
        nam = sc.nextLine();
        System.out.println("Enter the manager's basic pay: ");
        bas = sc.nextDouble();

        Manager mng = new Manager(iid, nam, bas);
        mng.salary();
        System.out.println("***********************************************************************");

        sc.close();
    }

}

abstract class Employee {
    protected double id, basic, sal, hra, da;
    protected String name;

    abstract void salary();
}

class Clerk extends Employee {
    private double ext_hr;

    Clerk(double val, String nm, double bs, double hr) {
        id = val;
        name = nm;
        basic = bs;
        ext_hr = hr;
    }

    protected void salary() {
        sal = basic + (20 * ext_hr);
        System.out.println("The salary of clerk " + this.name + " with id " + this.id + " is: " + sal);
    }

}

class Officer extends Employee {

    Officer(double val, String nm, double bs) {
        id = val;
        name = nm;
        basic = bs;
        da = bs * (0.02);
        hra = bs * (0.04);
    }

    protected void salary() {
        sal = basic + hra + da;
        System.out.println("The salary of officer " + this.name + " with id " + this.id + " is: " + sal);
    }

}

class Manager extends Employee {

    Manager(double val, String nm, double bs) {
        id = val;
        name = nm;
        basic = bs;
        hra = (0.04) * bs;
        da = (0.05) * bs;
    }

    protected void salary() {
        sal = basic + da + hra;
        System.out.println("The salary of manager " + this.name + " with id " + this.id + " is: " + sal);
    }

}