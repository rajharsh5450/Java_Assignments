import java.util.*;

public class Ass2
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        
        //Question 1
        System.out.println("This Is for Question 1:(Currency Calculator)");
        
        int val;
        String str;
        System.out.println("Enter number of currency to be purchased: ");
        val= sc.nextInt();
        System.out.println("Enter code (only $, EUR, £  for now) of currency to be purchased: ");
        str= sc.next();
        
        Currency curr = new Currency(val, str);
        System.out.println(val+ " "+ str+ " wrt to 1Rupee is: " + curr.calc());

        System.out.println();

        //Question 2
        System.out.println("This Is for Question 2:(Telephone Bill Calculator):");
        
        double unitC;
        String phn, nam;
        
        System.out.println("Enter name of Consumer: ");
        nam= sc.next();
        System.out.println("Enter phone no. of Consumer: ");
        phn= sc.next();
        System.out.println("Enter unit consumed by Consumer: ");
        unitC= sc.nextDouble();

        TelephoneBill tel= new TelephoneBill(phn, nam, unitC);
        tel.display();
        sc.close();
    }
}

class Currency
{
    private String currencyCode, currencyName;
    private double exchangeRate, amount;

    Currency(double val, String cCode)
    {
        this();
        amount= val;
        if(cCode.equals("EUR")== true)
        {
            currencyCode = cCode;
            currencyName = "Euro";
            exchangeRate = 88.54;
        }
        else if(cCode.equals("£") == true)
        {
            currencyCode = cCode;
            currencyName = "Pound";
            exchangeRate = 100.12;
        }
    }
    
    Currency()
    {
        currencyCode = "$";
        currencyName = "US DOLLAR";
        exchangeRate = 70.32;
        amount = 1;
    }
    
    double calc()
    {
        return this.amount*this.exchangeRate;
    }
}

class TelephoneBill
{
    private String ph, name;
    private double unit, bill;
    private final double hire_charge= 50;
    TelephoneBill(String phno, String nm, double unit_cons)
    {
        ph= phno;
        name= nm;
        unit= unit_cons;
    }

    void display()
    {
        System.out.println("The Telephone bill for "+ name +" is (keeping hiring charge= 50): "+ calc_bill());
    }

    double calc_bill()
    {
        int ct=0;
        bill+= hire_charge;
        while((unit>0) && (ct>=0)== true)
        {
            if(ct==0)
            {
                bill+= 1.00;
                unit-= 100.00;
                ct++;
            }
            else if(ct==1)
            {
                bill+= 1.50;
                unit-=100.00;
                ct++;
            }
            else if(ct==2)
            {
                bill+= 2.00;
                ct= -1;
            }
        }
        return bill;
    }
}
