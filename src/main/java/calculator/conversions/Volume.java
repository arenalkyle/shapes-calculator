package calculator.conversions;

import javax.swing.*;
import java.awt.*;

public class Volume extends JFrame {

    public Volume() {
        //Window setup
        setTitle("Conversions Calculator for Volume");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(Volume.class.getResource("/icon.png"))); // 16.1 11.3 13.3 7.4 24.9
        } catch (Exception ignored) {

        }

        //Title
        JLabel titleLabel = new JLabel("Currency Calculator for Volume", JLabel.CENTER);
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
        choice.addItem("Gallons");
        choice.addItem("Liters");
        choice.addItem("Pints");
        getContentPane().add(choice);

        choice.addItemListener(e -> {
            switch (choice.getSelectedIndex()) {
                case 0 -> leftLabel.setText("Select an option");
                case 1 -> leftLabel.setText("Gallons");
                case 2 -> leftLabel.setText("Liters");
                case 3 -> leftLabel.setText("Pints");
            }
        });

        Choice choice_1 = new Choice();
        choice_1.setBounds(269, 183, 150, 20);
        choice_1.addItem("Select here");
        choice_1.addItem("Gallons");
        choice_1.addItem("Liters");
        choice_1.addItem("Pints");
        getContentPane().add(choice_1);

        choice_1.addItemListener(e -> {
            switch (choice_1.getSelectedIndex()) {
                case 0 -> rightLabel.setText("Select an option");
                case 1 -> rightLabel.setText("Gallons");
                case 2 -> rightLabel.setText("Liters");
                case 3 -> rightLabel.setText("Pints");
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
        if (left == 0 || right == 0 || leftValue == 0) {
            return 0;
        }

        if (left == 1) { // Gallons
            return switch (right) {
                case 2 -> leftValue * 3.785;
                case 3 -> leftValue * 8;
                default -> leftValue;
            };
        }

        if (left == 2) { // Liters
            return switch (right) {
                case 1 -> leftValue * 0.264;
                case 3 -> leftValue * 2.113;
                default -> leftValue;
            };
        }

        if (left == 3) { // Pints
            return switch (right) {
                case 1 -> leftValue * 0.125;
                case 2 -> leftValue * 0.473;
                default -> leftValue;
            };
        }

        return 0;
    }
}
