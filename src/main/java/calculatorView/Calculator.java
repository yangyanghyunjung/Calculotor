package calculatorView;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

    private JTextField filed;
    public Calculator() {
        setLayout(null);

        filed = new JTextField();
        filed.setEditable(false);
        filed.setBackground(Color.BLACK);
        filed.setHorizontalAlignment(JTextField.RIGHT);
        filed.setFont(new Font("Arial", Font.BOLD, 50));
        filed.setBounds(8, 10, 270, 70);

        add(filed);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(4, 4, 10, 10));
        btnPanel.setBounds(8, 90,270, 235);

        String btn_names[] = {"C", "/", "x", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0"};
        JButton btns[] = new JButton[btn_names.length];

        for (int i = 0; i <btn_names.length; ++i) {
            btns[i] = new JButton(btn_names[i]);
            btns[i].setFont(new Font("Arial", Font.BOLD, 20));
            if (btn_names[i] == "C") {
                btns[i].setBackground(Color.RED);
            } else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14)) {
                btns[i].setBackground(Color.DARK_GRAY);
            } else {
                btns[i].setBackground(Color.GRAY);
            }
            btns[i].setForeground(Color.WHITE);
            btns[i].setBorderPainted(false);
            btnPanel.add(btns[i]);
        }

        add(filed);
        add(btnPanel);

        setTitle("계산기");
        setVisible(true);
        setSize(300, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
