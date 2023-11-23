package domain;

import java.util.ArrayList;
import view.Calculator;

public class Calculate {
    public static String num = "";
    private ArrayList<String> equation = new ArrayList<String>(); // 숫자를 보관할 역할


    private void fullTextParsing(String inputText) {
        equation.clear();

        for (int i = 0; i < inputText.length(); ++i) {
            char ch = inputText.charAt(i);

            if (ch == '-' || ch == '+' || ch == '×' || ch == '÷') {
                equation.add(num);
                num = "";
                equation.add(ch + "");
            } else {
                num = num + ch;
            }
        }
        equation.add(num);
    }

    /* 계산 비즈니스 로직 */
    public double calculate(String inputText) {
        fullTextParsing(inputText);

        double prev = 0;
        double current = 0;
        String mode = "";

        for (String s : equation) {
            if (s.equals("+")) {
                mode = "add";
            } else if (s.equals("-")) {
                mode = "sub";
            } else if (s.equals("×")) {
                mode = "mul";
            }
            else if (s.equals("÷")) {
                mode = "div";
            } else {
                current = Double.parseDouble(s);
                if (mode == "add") {
                    prev += current;
                } else if (mode == "sub") {
                    prev -= current;
                } else if (mode == "mul") {
                    prev *= current;
                } else if (mode == "div") {
                    prev /= current;
                } else {
                    prev = current;
                }
            }
        }
        return prev;
    }
}
