import java.util.*;

public class Ass31
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        Sentences sen= new Sentences();
        System.out.println("Enter a paragrah: ");
        String val= sc.nextLine();
        String[] lines= val.split("\\.");
        System.out.println("The sentences of the para u entered are:");
        for(String i:lines)
        {
            System.out.println(i.trim());
        }
        System.out.println();
        sen.check_vow(val);
        sc.close();
    }
}

class Sentences
{
    int count= 0;
    
    String va= "A: ";
    String ve= "E: ";
    String vi= "I: ";
    String vo= "O: ";
    String vu= "U: ";
    
    void check_vow(String para)
    {
        String[] arr= para.split("\\.");
        for(String i: arr)
        {
            String[] sub= i.trim().split("\\s");
            for(String j: sub)
            {
                if((j.charAt(0)== 'A')|| (j.charAt(0)== 'a'))
                {
                    count++;
                    va+= (j+", ");
                }
                if((j.charAt(0)== 'E')|| (j.charAt(0)== 'e'))
                {
                    count++;
                    ve+= (j+", ");
                }
                if((j.charAt(0)== 'I')|| (j.charAt(0)== 'i'))
                {
                    count++;
                    vi+= (j+", ");
                }
                if((j.charAt(0)== 'O')|| (j.charAt(0)== 'o'))
                {
                    count++;
                    vo+= (j+", ");
                }
                if((j.charAt(0)== 'U')|| (j.charAt(0)== 'u'))
                {
                    count++;
                    vu+= (j+", ");
                }
            }
        }
        display();
    }
    void display()
    {
        if(va.equals("A: "))
        {
            va+= "NA";
        }
        if(ve.equals("E: "))
        {
            ve+= "NA";
        }
        if(vi.equals("I: "))
        {
            vi+= "NA";
        }
        if(vo.equals("O: "))
        {
            vo+= "NA";
        }
        if(vu.equals("U: "))
        {
            vu+= "NA";
        }
        System.out.println("total words starting with vowel: "+count);
        System.out.println(va+"\n"+ve+"\n"+vi+"\n"+vo+"\n"+vu);
    }
}