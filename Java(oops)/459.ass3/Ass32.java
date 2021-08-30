import java.util.*;

public class Ass32
{
    public static void main(String[] args)
    {
        //Name
        System.out.println("First Name : " + args[0]);
        System.out.println("Last Name : " + args[1]);
        System.out.println();
        
        //Date of birth
        String[] d = args[2].split("/",0);
        Validate val= new Validate();
        val.validate_DOB(d);

        //Mail address
        String email = args[3];
        String[] domain = email.split("@",2);
        if(domain[1].contains("."))
        {
            System.out.println("Domain Name : " + domain[1]);
        }
        else 
        {
            System.out.println("*Please enter a valid mail id with a domain.");
        }
    }
}

class Validate
{
    private boolean valid_dob = true;
    void validate_DOB(String[] dob)
    {
        if (Integer.parseInt(dob[0]) > 31)
        {
            valid_dob = false;
        } 
        else if (Integer.parseInt(dob[0]) > 28)
        {
            if (Integer.parseInt(dob[1]) == 2) 
            {
                if (Integer.parseInt(dob[2])%4 != 0 && Integer.parseInt(dob[0]) != 29)
                {
                    valid_dob = false;
                }
            }
        }
        if (Integer.parseInt(dob[1]) > 12) 
        {
            valid_dob = false;
        }

        if (valid_dob)
        {
            calc(dob);
        } 
        else 
        {
            System.out.println("*Please enter a valid date of birth.");
        }
    }
    void calc(String[] dob)
    {
        String month = "";

        switch (Integer.parseInt(dob[1]))
        {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                break;
        }

        System.out.println("Date of Birth : " + dob[0] + "-" + month + "-" + dob[2]);
    }
}