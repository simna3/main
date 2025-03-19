import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator implements ActionListener {

    private JFrame frame;
    private JTextField firstNumberField, secondNumberField, thirdNumberField, resultField;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use null layout for absolute positioning

        // Labels
        JLabel num1Label = new JLabel("1st Number:");
        num1Label.setBounds(10, 10, 80, 20);
        JLabel num2Label = new JLabel("2nd Number:");
        num2Label.setBounds(10, 40, 80, 20);
        JLabel num3Label = new JLabel("3rd Number:");
        num3Label.setBounds(10, 70, 80, 20);
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 100, 80, 20);

        // Input fields
        firstNumberField = new JTextField();
        firstNumberField.setBounds(100, 10, 80, 20);
        secondNumberField = new JTextField();
        secondNumberField.setBounds(100, 40, 80, 20);
        thirdNumberField = new JTextField();
        thirdNumberField.setBounds(100, 70, 80, 20);

        // Buttons
        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 130, 80, 20);
        addButton.addActionListener(this);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.setBounds(100, 130, 80, 20);
        subtractButton.addActionListener(this);

        JButton multiplyButton = new JButton("Multiply");
        multiplyButton.setBounds(190, 130, 80, 20);
        multiplyButton.addActionListener(this);

        // Result field
        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setBounds(100, 100, 80, 20);

        // Add components to the frame
        frame.add(num1Label);
        frame.add(num2Label);
        frame.add(num3Label);
        frame.add(resultLabel);
        frame.add(firstNumberField);
        frame.add(secondNumberField);
        frame.add(thirdNumberField);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(resultField);

        frame.setVisible(true);
    }

    private int parseInteger(JTextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            return 0; // Return 0 if parsing fails
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num1 = parseInteger(firstNumberField);
        int num2 = parseInteger(secondNumberField);
        int num3 = parseInteger(thirdNumberField);
        int result = 0;

        if (e.getActionCommand().equals("Add")) {
            result = num1 + num2 + num3;
        } else if (e.getActionCommand().equals("Subtract")) {
            result = num1 - num2 - num3;
        } else if (e.getActionCommand().equals("Multiply")) {
            result = num1 * num2 * num3;
        }

        resultField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}
