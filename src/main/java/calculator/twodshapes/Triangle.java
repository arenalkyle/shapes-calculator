package calculator.twodshapes;

import javax.swing.*;
import java.awt.*;

public class Triangle extends JFrame 
{

    public Triangle() 
    {
        //Window setup
        setTitle("Surface Area Calculator For Triangle");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(Triangle.class.getResource("/icon.png"))); // 16.1 11.3 13.3 7.4 24.9
        } catch (Exception ignored) {

        }

        //Title
        JLabel titleLabel = new JLabel("Surface Area Calculator For Triangle", JLabel.CENTER);
        titleLabel.setBounds(70, 20, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 128, 0));
        add(titleLabel);

        //Base input
        JLabel baseLabel = new JLabel("Enter Base:");
        baseLabel.setBounds(50, 80, 100, 25);
        baseLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(baseLabel);

        JTextField baseField = new JTextField();
        baseField.setBounds(150, 80, 200, 25);
        add(baseField);

        //Height input
        JLabel heightLabel = new JLabel("Enter Height:");
        heightLabel.setBounds(50, 120, 100, 25);
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(150, 120, 200, 25);
        add(heightField);

        // Buttons
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(370, 80, 100, 25);
        add(calculateButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(370, 120, 100, 25);
        add(resetButton);

        //Results
        JLabel formulaLabel = new JLabel("Formula Calculation:");
        formulaLabel.setBounds(50, 160, 150, 25);
        formulaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(formulaLabel);

        JTextField formulaField = new JTextField();
        formulaField.setBounds(200, 160, 270, 25);
        formulaField.setEditable(false);
        add(formulaField);

        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setBounds(50, 200, 100, 25);
        areaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(areaLabel);

        JTextField areaField = new JTextField();
        areaField.setBounds(150, 200, 320, 25);
        areaField.setEditable(false);
        add(areaField);

        //Actions
        calculateButton.addActionListener(event -> 
        {
            try 
            {
                double base = Double.parseDouble(baseField.getText());
                double height = Double.parseDouble(heightField.getText());
                double area = 0.5 * base * height; // Triangle area formula
                formulaField.setText("0.5 × " + base + " × " + height);
                areaField.setText(String.valueOf(area));
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(this, "Enter valid numbers.");
            }
        });

        resetButton.addActionListener(event -> 
        {
            baseField.setText("");
            heightField.setText("");
            formulaField.setText("");
            areaField.setText("");
        });
    }
}
