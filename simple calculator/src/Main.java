import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    JFrame jFrame = new JFrame("Simple Calculator");
    JTextField jTextField = new JTextField();

    JButton[] jButtonNumber = new JButton[10];
    JButton[] jButtonOperator = new JButton[9];
    JButton jButtonAddition = new JButton("+"),
            jButtonSubtraction = new JButton("-"),
            jButtonMultiplication = new JButton("*"),
            jButtonDivision = new JButton("/"),
            jButtonDecimal = new JButton("."),
            jButtonEqual = new JButton("="),
            jButtonNegative = new JButton("(-) neg"),
            jButtonClear = new JButton("Clear"),
            jButtonDelete = new JButton("Delete");

    JPanel jPanel = new JPanel();

    Font font = new Font("Sherif", Font.PLAIN, 25);

    double number1 = 0, number2 = 0, result = 0;
    char operator;

    Main() {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 500);
        jFrame.setLayout(null);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);

        jTextField.setBounds(25, 25, 335, 40);
        jTextField.setFont(font);
        jTextField.setEditable(false);

        jButtonOperator[0] = jButtonAddition;
        jButtonOperator[1] = jButtonSubtraction;
        jButtonOperator[2] = jButtonMultiplication;
        jButtonOperator[3] = jButtonDivision;
        jButtonOperator[4] = jButtonDecimal;
        jButtonOperator[5] = jButtonEqual;
        jButtonOperator[6] = jButtonClear;
        jButtonOperator[7] = jButtonDelete;
        jButtonOperator[8] = jButtonNegative;

        for (int i = 0; i < 9; i++) {
            jButtonOperator[i].addActionListener(this);
            jButtonOperator[i].setFont(font);
            jButtonOperator[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            jButtonNumber[i] = new JButton(String.valueOf(i));
            jButtonNumber[i].addActionListener(this);
            jButtonNumber[i].setFont(font);
            jButtonNumber[i].setFocusable(false);
        }

        jButtonNegative.setBounds(25, 385, 105, 50);
        jButtonClear.setBounds(140, 385, 105, 50);
        jButtonDelete.setBounds(255, 385, 105, 50);

        jPanel.setBounds(25, 74, 335, 300);
        jPanel.setLayout(new GridLayout(4, 4 ,10, 10));

        jPanel.add(jButtonNumber[7]);
        jPanel.add(jButtonNumber[8]);
        jPanel.add(jButtonNumber[9]);
        jPanel.add(jButtonDivision);

        jPanel.add(jButtonNumber[4]);
        jPanel.add(jButtonNumber[5]);
        jPanel.add(jButtonNumber[6]);
        jPanel.add(jButtonMultiplication);

        jPanel.add(jButtonNumber[1]);
        jPanel.add(jButtonNumber[2]);
        jPanel.add(jButtonNumber[3]);
        jPanel.add(jButtonSubtraction);

        jPanel.add(jButtonDecimal);
        jPanel.add(jButtonNumber[0]);
        jPanel.add(jButtonEqual);
        jPanel.add(jButtonAddition);

        jFrame.add(jTextField);
        jFrame.add(jButtonNegative);
        jFrame.add(jButtonClear);
        jFrame.add(jButtonDelete);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == jButtonNumber[i]) {
                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == jButtonDecimal) {
            jTextField.setText(jTextField.getText().concat("."));
        }

        if (e.getSource() == jButtonAddition) {
            number1 = Double.parseDouble(jTextField.getText());
            operator = '+';
            jTextField.setText("");
        }

        if (e.getSource() == jButtonSubtraction) {
            number1 = Double.parseDouble(jTextField.getText());
            operator = '-';
            jTextField.setText("");
        }

        if (e.getSource() == jButtonMultiplication) {
            number1 = Double.parseDouble(jTextField.getText());
            operator = '*';
            jTextField.setText("");
        }

        if (e.getSource() == jButtonDivision) {
            number1 = Double.parseDouble(jTextField.getText());
            operator = '/';
            jTextField.setText("");
        }

        if (e.getSource() == jButtonEqual) {
            number2 = Double.parseDouble(jTextField.getText());

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
            }
            jTextField.setText(String.valueOf(result));
            number1 = result;
        }
        
        if (e.getSource() == jButtonClear) {
            jTextField.setText("");
        }

        if (e.getSource() == jButtonDelete) {
            String str = jTextField.getText();
            jTextField.setText("");

            for (int i = 0; i < str.length() - 1; i++) {
                jTextField.setText(jTextField.getText() + str.charAt(i));
            }
        }

        if (e.getSource() == jButtonNegative) {
            double tempForNegative = Double.parseDouble(jTextField.getText());
            tempForNegative *= -1;
            jTextField.setText(String.valueOf(tempForNegative));
        }
    }
}
