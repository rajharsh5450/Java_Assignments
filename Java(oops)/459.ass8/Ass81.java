import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ass81 extends JFrame {
    private Container content;
    private JLabel inLabel, outLabel, result;
    private JTextField inp;
    private JButton vow_count, cons_count, punct_count, capitalise;

    public Ass81() {
        super("My GUI");
        content = getContentPane();
        content.setLayout(new FlowLayout());
        inLabel = new JLabel("Enter a string on which u want to operate: \n\n");
        inp = new JTextField(135);
        vow_count = new JButton("count vowels");
        cons_count = new JButton("count consonants");
        punct_count = new JButton("count punctuation");
        capitalise = new JButton("capitalise");

        outLabel = new JLabel("Result of button clicked: ");
        result = new JLabel("");
        content.add(inLabel);
        content.add(inp);
        content.add(vow_count);
        content.add(cons_count);
        content.add(punct_count);
        content.add(capitalise);
        content.add(outLabel);
        content.add(result);

        ButtonHandler81 bh = new ButtonHandler81();

        vow_count.addActionListener(bh);
        cons_count.addActionListener(bh);
        punct_count.addActionListener(bh);
        capitalise.addActionListener(bh);

        setSize(500, 850);
        setVisible(true);
    }

    private class ButtonHandler81 implements ActionListener {
        public void actionPerformed(ActionEvent act) {
            if (act.getSource() == capitalise) {
                result.setText(inp.getText().toUpperCase());
            }
            else if(act.getSource()== vow_count)
            {
                int count= count_vowels(inp.getText().toLowerCase(), true, false);
                result.setText("The no. of vowels present in string entered is: "+ count);
            }
            else if(act.getSource()== cons_count){
                int count = count_vowels(inp.getText().toLowerCase(), false, false);
                result.setText("The no. of consonants present in string entered is: " + count);
            }
            else if(act.getSource()== punct_count){
                int count = count_vowels(inp.getText().toLowerCase(), false, true);
                result.setText("The no. of punctuation marks present in string entered is: " + count);
            }
        }

        public int count_vowels(String str, boolean flag, boolean punct)
        {
            int v_ct=0, c_ct=0, p_ct=0;
        
            for(char ch: str.toCharArray())
            {
                if(ch== 'a' || ch== 'e' || ch== 'i' || ch== 'o' || ch== 'u')
                {
                    v_ct++;
                }
                else if(ch >= 'a' && ch<= 'z')
                {
                    c_ct++;
                }
                else if(ch== '!'||ch=='.'||ch==','||ch== ';'||ch==':'||ch=='?'||ch=='\''||ch=='\"')
                {
                    p_ct++;
                }
            }
            if(flag== true)
            {
                return v_ct;
            }
            else
            {
                if(punct== true)
                {
                    return p_ct;
                }
                else
                {
                    return c_ct;
                }
            }
        }

    }

    public static void main(String[] args) {
        Ass81 out = new Ass81();
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


