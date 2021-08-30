import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ass91 extends JFrame {
    private Container content;
    private JLabel inLabel, outLabel, result;
    private JTextField inp;
    private JFileChooser inpfile;
    private JButton chooseFile, respons, exit;

    public Ass91() {
        super("My GUI");
        content = getContentPane();
        content.setLayout(null);
        inLabel = new JLabel("The string found on the file u opened is: ");
        inLabel.setBounds(500, 50, 500, 40);

        inp = new JTextField(200);
        inp.setBounds(100, 100, 1200, 30);

        chooseFile = new JButton("chooseFile");
        chooseFile.setBounds(450, 140, 100, 30);

        respons = new JButton("Result");
        respons.setBounds(600, 140, 100, 30);

        exit = new JButton("Exit");
        exit.setBounds(750, 140, 100, 30);

        outLabel = new JLabel("");
        outLabel.setBounds(500, 185, 500, 40);

        result = new JLabel("");
        result.setBounds(400, 240, 900, 80);

        content.add(inLabel);
        content.add(inp);
        content.add(chooseFile);
        content.add(respons);
        content.add(exit);
        content.add(outLabel);
        content.add(result);

        chooseFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    inpfile = new JFileChooser();
                    inpfile.setCurrentDirectory(new File(System.getProperty("user.home")));
                    int res = inpfile.showOpenDialog(chooseFile);
                    if (res == JFileChooser.APPROVE_OPTION) {
                        File selected = inpfile.getSelectedFile();
                        String inside = readFile(selected.getAbsolutePath());
                        inp.setText(inside);
                    }
                } catch (Exception e) {
                }
            }
        });
        respons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String res = "";
                List<String> links = grabHTMLLinks(inp.getText());
                for (String i : links) {
                    res += (i + "  ,  ");
                }
                outLabel.setText("The list of links that the chosen html file links to is: ");
                result.setText(res);
                System.out.println(res);
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        setSize(1400, 380);
        setVisible(true);
    }

    public List<String> grabHTMLLinks(String html) {
        List<String> result = new ArrayList<String>();
        Pattern patternTag, patternLink;
        Matcher matcherTag, matcherLink;

        String HTML_A_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
        String HTML_A_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

        patternTag = Pattern.compile(HTML_A_TAG_PATTERN);
        patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
        matcherTag = patternTag.matcher(html);

        while (matcherTag.find()) {
            String href = matcherTag.group(1);
            matcherLink = patternLink.matcher(href);

            while (matcherLink.find()) {
                String link = matcherLink.group(1);
                result.add(link);
            }
        }
        return result;
    }

    public String readFile(String file) {
        BufferedReader fin;
        String str = "", line = "";
        try {
            fin = new BufferedReader(new FileReader(file));
            while ((line = fin.readLine()) != null) {
                str += line;
            }
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        Ass91 out = new Ass91();
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}