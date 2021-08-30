import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ass82 extends JFrame {
    private Container content;
    private JLabel inLabel, outLabel, result;
    private JTextField inp;
    private JFileChooser inpfile;
    private JButton vow_count, cons_count, punct_count, capitalise;

    public Ass82() {
        super("My GUI");
        content = getContentPane();
        content.setLayout(new FlowLayout());
        inLabel = new JLabel("The string found on the file u opened is: \n\n");
        inp= new JTextField(135);
        inpfile= new JFileChooser();
        inpfile.setCurrentDirectory(new File(System.getProperty("user.home")));
        int res= inpfile.showOpenDialog(this);
        if(res== JFileChooser.APPROVE_OPTION)
        {
            File selected= inpfile.getSelectedFile();
            String inside= readFile(selected.getAbsolutePath());
            inp.setText(inside);
        }

        vow_count = new JButton("count vowels");
        cons_count = new JButton("count consonants");
        punct_count = new JButton("count punctuation");
        capitalise = new JButton("capitalise");

        outLabel = new JLabel("Result of button clicked: ");
        result = new JLabel("");
        content.add(inLabel);
        content.add(inp);
        content.add(inpfile);
        content.add(vow_count);
        content.add(cons_count);
        content.add(punct_count);
        content.add(capitalise);
        content.add(outLabel);
        content.add(result);

        ButtonHandler82 bh = new ButtonHandler82();

        vow_count.addActionListener(bh);
        cons_count.addActionListener(bh);
        punct_count.addActionListener(bh);
        capitalise.addActionListener(bh);

        setSize(1400, 800);
        setVisible(true);
    }

    private class ButtonHandler82 implements ActionListener {
        public void actionPerformed(ActionEvent act) {

            if (act.getSource() == capitalise) {
                result.setText(inp.getText().toUpperCase());
            } else if (act.getSource() == vow_count) {
                int count = count_vowels(inp.getText().toLowerCase(), true, false);
                result.setText("The no. of vowels present in string entered is: " + count);
            } else if (act.getSource() == cons_count) {
                int count = count_vowels(inp.getText().toLowerCase(), false, false);
                result.setText("The no. of consonants present in string entered is: " + count);
            } else if (act.getSource() == punct_count) {
                int count = count_vowels(inp.getText().toLowerCase(), false, true);
                result.setText("The no. of punctuation marks present in string entered is: " + count);
            }
        }

        public int count_vowels(String str, boolean flag, boolean punct) {
            int v_ct = 0, c_ct = 0, p_ct = 0;

            for (char ch : str.toCharArray()) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    v_ct++;
                } else if (ch >= 'a' && ch <= 'z') {
                    c_ct++;
                } else if (ch == '!' || ch == '.' || ch == ',' || ch == ';' || ch == ':' || ch == '?' || ch == '\''
                        || ch == '\"') {
                    p_ct++;
                }
            }
            if (flag == true) {
                return v_ct;
            } else {
                if (punct == true) {
                    return p_ct;
                } else {
                    return c_ct;
                }
            }
        }

    }

    public String readFile(String file)
    {
        BufferedReader fin;
        String str = "", line = "";
        try{
            fin= new BufferedReader(new FileReader(file));
            while((line= fin.readLine())!= null)
            {
                str+= line;
            }
            fin.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        Ass82 out = new Ass82();
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}