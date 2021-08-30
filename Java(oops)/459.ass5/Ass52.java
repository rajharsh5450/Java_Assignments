import java.util.*;

public class Ass52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main sentence: ");
        String mainStr = sc.nextLine();
        
        Editor ed = new Editor(mainStr);
        System.out.println("Forwarding to Editor ---->");
        while (true) {
            System.out.println("**********************************************************************");

            System.out.println("Enter         1.Append     2.Insert    3.Replace      4.Delete       5.Exit");
            int ch = sc.nextInt();
            System.out.println("**********************************************************************");

            switch (ch) {
                case 1:
                    System.out.println("Enter the string to be appended: ");
                    String str = sc.next();
                    mainStr = ed.editAppend(str);
                    System.out.println("New Sentence: " + mainStr);
                    break;
                case 2:
                    System.out.println("Enter the index where string is to be inserted: ");
                    int ind = sc.nextInt();
                    System.out.println("Enter the string to be inserted: ");
                    String str1 = sc.next();

                    mainStr = ed.editInsert(ind, str1);
                    System.out.println("New sentence: " + mainStr);
                    break;
                case 3:
                    System.out.println("Enter start index from where to replace: ");
                    int start = sc.nextInt();
                    System.out.println("Enter end index to be replaced: ");
                    int end = sc.nextInt();
                    System.out.println("Enter the new string to be replaced: ");
                    String str2 = sc.next();

                    mainStr = ed.editReplace(start, end+1, str2);
                    System.out.println("New sentence: " + mainStr);
                    break;
                case 4:
                    System.out.println("Enter start index : ");
                    int start1 = sc.nextInt();
                    System.out.println("Enter end index : ");
                    int end1 = sc.nextInt();

                    mainStr = ed.editDelete(start1, end1);
                    System.out.println("New sentence : " + mainStr);
                    break;
                case 5:
                    System.out.println("Exiting out of the program...............");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}

class Editor {
    StringBuffer s;

    public Editor(String s) {
        this.s = new StringBuffer(s);
    }

    public String editAppend(String string) {
        s.append(" ");
        s.append(string);
        return s.toString();
    }

    public String editInsert(int index, String string) {
        string = " "+string+" ";
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
