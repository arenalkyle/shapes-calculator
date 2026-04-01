package calculator.threedshapes;

import javax.swing.*;
import java.awt.*;

public class Cube extends JFrame 
{

    public Cube() 
    {
        //Window setup
        setTitle("Surface Area Calculator For Cube");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(Cube.class.getResource("/icon.png"))); // 16.1 11.3 13.3 7.4 24.9
        } catch (Exception ignored) {

        }

        //Title
        JLabel titleLabel = new JLabel("Surface Area Calculator For Cube", JLabel.CENTER);
        titleLabel.setBounds(70, 20, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 128, 0));
        add(titleLabel);

        //Side input
        JLabel sideLabel = new JLabel("Enter Side Length:");
        sideLabel.setBounds(50, 80, 150, 25);
        sideLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(sideLabel);

        JTextField sideField = new JTextField();
        sideField.setBounds(200, 80, 150, 25);
        add(sideField);

        //Buttons
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(370, 80, 100, 25);
        add(calculateButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(370, 120, 100, 25);
        add(resetButton);
        
        //Results
        JLabel formulaLabel = new JLabel("Formula Calculation:");
        formulaLabel.setBounds(50, 200, 150, 25);
        formulaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(formulaLabel);

        JTextField formulaField = new JTextField();
        formulaField.setBounds(200, 200, 270, 25);
        formulaField.setEditable(false);
        add(formulaField);

        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setBounds(50, 240, 100, 25);
        areaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(areaLabel);

        JTextField areaField = new JTextField();
        areaField.setBounds(150, 240, 320, 25);
        areaField.setEditable(false);
        add(areaField);

        //Actions
        calculateButton.addActionListener(event -> 
        {
            try 
            {
                double side = Double.parseDouble(sideField.getText());
                double area = 6 * side * side; // Cube surface area formula
                formulaField.setText("6 × " + side + "²");
                areaField.setText(String.valueOf(area));
            } 
            
            catch (NumberFormatException ex) 
            
            {
                JOptionPane.showMessageDialog(this, "Enter valid numbers.");
            }
        });

        resetButton.addActionListener(event -> 
        {
            sideField.setText("");
            formulaField.setText("");
            areaField.setText("");
        });
    }
}
