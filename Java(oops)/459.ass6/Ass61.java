import java.util.*;


import java.io.*;

public class Ass61
{
    public static void appendToFile(String fileName, String str)
    {
        try
        {
            BufferedWriter wr= new BufferedWriter(new FileWriter(fileName, true));
            wr.write(str);
            wr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }        
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc= new Scanner(System.in);
        Ass61 inclass= new Ass61();
        BufferedReader fin, prepos;
        BufferedWriter fout;
        String line= "";
        String finalPara= "";
        int ct=0;
         
        try
        {
            prepos= new BufferedReader(new FileReader("prepositions.txt"));
            String preposition= prepos.readLine();

            fin= new BufferedReader(new FileReader("para.txt"));
            if(fin != null)
            {
                System.out.println("File reading is ready!");
            }
            
            fout= new BufferedWriter(new FileWriter("paraOut.txt"));
            if (fout != null) {
                System.out.println("File paraout.txt is ready to have something  to write!");
            }
            System.out.println("*****************************************************************************");

            while((line= fin.readLine())!= null)
            {
                System.out.println("The line from para is: \n"+line);
                System.out.println();
                int[] vowCount= inclass.vowelAndPreposition(line, preposition);

                Editor61 ed = new Editor61(line);
                boolean flag= true;
                System.out.println("Forwarding to Editor ---->");
                while (flag) {
                    System.out.println("**********************************************************************");

                    System.out.println("Enter         1.Append     2.Insert    3.Replace      4.Delete       5.skip changing");
                    int ch = sc.nextInt();
                    System.out.println("**********************************************************************");

                    switch (ch) {
                        case 1:
                            System.out.println("Enter the string to be appended: ");
                            sc.nextLine();
                            String str = sc.nextLine();
                            line = ed.editAppend(str);
                            break;
                        case 2:
                            System.out.println("Enter the index where string is to be inserted: ");
                            int ind = sc.nextInt();
                            System.out.println("Enter the string to be inserted: ");
                            sc.nextLine();
                            String str1 = sc.nextLine();

                            line= ed.editInsert(ind, str1);
                            break;
                        case 3:
                            System.out.println("Enter start index from where to replace: ");
                            int start = sc.nextInt();
                            System.out.println("Enter end index to be replaced: ");
                            int end = sc.nextInt();
                            System.out.println("Enter the new string to be replaced: ");
                            sc.nextLine();
                            String str2 = sc.nextLine();

                            line= ed.editReplace(start, end + 1, str2);
                            break;
                        case 4:
                            System.out.println("Enter start index : ");
                            int start1 = sc.nextInt();
                            System.out.println("Enter end index : ");
                            int end1 = sc.nextInt();

                            line= ed.editDelete(start1, end1);
                            break;
                        case 5:
                            finalPara+= line;
                            flag= false;
                            break;
                    }
                }
                finalPara+= "\n";
                ct++;
                fout.write("The no. of words starting with A in line " + ct + " is: " + vowCount[0] + "\n");
                fout.write("The no. of words starting with E in line " + ct + " is: " + vowCount[1] + "\n");
                fout.write("The no. of words starting with I in line " + ct + " is: " + vowCount[2] + "\n");
                fout.write("The no. of words starting with O in line " + ct + " is: " + vowCount[3] + "\n");
                fout.write("The no. of words starting with u in line " + ct + " is: " + vowCount[4] + "\n");
                fout.write("Prepositions in line "+ ct + " is: " +vowCount[5]+"\n");
            }
            
            fin.close();
            fout.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        appendToFile("para.txt", finalPara);
        sc.close();
    }

    int[] vowelAndPreposition(String str, String pre)
    {
        int[] count= new int[6];
        String[] letters= str.split("\\s");
        String[] prep= pre.split("\\,");

        for (String j : letters)
        {
            for(String i : prep)
            {
                if(j.equalsIgnoreCase(i))
                {
                    count[5]++;
                }
            }
            if ((j.charAt(0) == 'A') || (j.charAt(0) == 'a')) {
                count[0]++;
            }
            if ((j.charAt(0) == 'E') || (j.charAt(0) == 'e')) {
                count[1]++;
            }
            if ((j.charAt(0) == 'I') || (j.charAt(0) == 'i')) {
                count[2]++;
            }
            if ((j.charAt(0) == 'O') || (j.charAt(0) == 'o')) {
                count[3]++;
            }
            if ((j.charAt(0) == 'U') || (j.charAt(0) == 'u')) {
                count[4]++;
            }
        }
        return count;
    }
}

class Editor61 {
    StringBuffer s;

    public Editor61(String s) {
        this.s = new StringBuffer(s);
    }

    public String editAppend(String string) {
        s.append(" ");
        s.append(string);
        return s.toString();
    }

    public String editInsert(int index, String string) {
        string = " " + string + " ";
        s.insert(index, string);
        return s.toString();
    }

    public String editReplace(int start, int end, String string) {
        s.replace(start, end, string);
        return s.toString();
    }

    public String editDelete(int start, int end) {
        s.delete(start, end);
        return s.toString();
    }
}

