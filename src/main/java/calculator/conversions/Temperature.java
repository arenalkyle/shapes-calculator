package calculator.conversions;

import javax.swing.*;
import java.awt.*;

public class Temperature extends JFrame {

    public Temperature() {
        //Window setup
        setTitle("Conversions Calculator for Temperature");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(Temperature.class.getResource("/icon.png"))); // 16.1 11.3 13.3 7.4 24.9
        } catch (Exception ignored) {

        }

        //Title
        JLabel titleLabel = new JLabel("Currency Calculator for Temperature", JLabel.CENTER);
        titleLabel.setBounds(46, 20, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 128, 0));
        getContentPane().add(titleLabel);

        //Side input
        JLabel leftLabel = new JLabel("Select an option");
        leftLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftLabel.setBounds(26, 80, 190, 25);
        leftLabel.setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().add(leftLabel);

        JTextField leftField = new JTextField();
        leftField.setBounds(33, 135, 167, 27);
        getContentPane().add(leftField);

        JLabel rightLabel = new JLabel("Select an option");
        rightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightLabel.setBounds(256, 80, 190, 25);
        rightLabel.setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().add(rightLabel);

        JTextField rightField = new JTextField();
        rightField.setBounds(269, 136, 150, 25);
        getContentPane().add(rightField);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 61, 484, 2);
        getContentPane().add(separator);

        Choice choice = new Choice();
        choice.setBounds(33, 183, 167, 20);
        choice.addItem("Select here");
        choice.addItem("Fahrenheit (°F)");
        choice.addItem("Celsius (°C)");
        choice.addItem("Kelvin (K)");
        getContentPane().add(choice);

        choice.addItemListener(e -> {
            switch (choice.getSelectedIndex()) {
                case 0 -> leftLabel.setText("Select an option");
                case 1 -> leftLabel.setText("Fahrenheit (°F)");
                case 2 -> leftLabel.setText("Celsius (°C)");
                case 3 -> leftLabel.setText("Kelvin (K)");
            }
        });

        Choice choice_1 = new Choice();
        choice_1.setBounds(269, 183, 150, 20);
        choice_1.addItem("Select here");
        choice_1.addItem("Fahrenheit (°F)");
        choice_1.addItem("Celsius (°C)");
        choice_1.addItem("Kelvin (K)");
        getContentPane().add(choice_1);

        choice_1.addItemListener(e -> {
            switch (choice_1.getSelectedIndex()) {
                case 0 -> rightLabel.setText("Select an option");
                case 1 -> rightLabel.setText("Fahrenheit (°F)");
                case 2 -> rightLabel.setText("Celsius (°C)");
                case 3 -> rightLabel.setText("Kelvin (K)");
            }
        });

        //Buttons
        JButton calculateButton = new JButton("Convert");
        calculateButton.addActionListener(e -> {
            try {

                int left = choice.getSelectedIndex();
                int right = choice_1.getSelectedIndex();

                double leftValue = Double.parseDouble(leftField.getText());

                rightField.setText(String.valueOf(output(left, right, leftValue)));

            } catch (Exception ignored) {

            }
        });
        calculateButton.setBounds(187, 233, 100, 25);
        getContentPane().add(calculateButton);
    }

    public double output(int left, int right, double leftValue) {
        if (left == 0 || right == 0) {
            return 0;
        }

        if (left == 1) { // Fahrenheit (°F)
            return switch (right) {
                case 2 -> (5.0D / 9.0D) * (leftValue - 32);
                case 3 -> leftValue * 0.91;
                default -> leftValue;
            };
        }

        if (left == 2) { // Celsius (°C)
            return switch (right) {
                case 1 -> (9.0D / 5.0D) * leftValue + 32;
                case 3 -> leftValue + 273.15;
                default -> leftValue;
            };
        }

        if (left == 3) { // Kelvin (K)
            return switch (right) {
                case 1 -> (9.0D / 5.0D) * (leftValue - 273.15) + 32;
                case 2 -> leftValue - 273.15;
                default -> leftValue;
            };
        }

        return 0;
    }
}
