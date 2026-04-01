package calculator.twodshapes;

import javax.swing.*;
import java.awt.*;

public class Circle extends JFrame 
{

    public Circle() 
    {
        // Set up the frame properties (size, title, and layout)
        setTitle("Surface Area Calculator For Circle");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // No default layout to allow absolute positioning of components

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(Circle.class.getResource("/icon.png"))); // 16.1 11.3 13.3 7.4 24.9
        } catch (Exception ignored) {

        }

        /*
        Title label added at the top of the window.
        - Styled with green color and bold font.
        */
        final JLabel titleLabel = new JLabel("Surface Area Calculator For Circle", JLabel.CENTER);
        titleLabel.setBounds(70, 20, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 128, 0)); // Green color
        add(titleLabel);

        /*
        Input field and label for radius added.
        - A JLabel prompts for input.
        - A JTextField allows the user to input the radius.
         */
        final JLabel radiusLabel = new JLabel("Enter Radius:");
        radiusLabel.setBounds(50, 80, 100, 25);
        radiusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(radiusLabel);

        final JTextField radiusField = new JTextField();
        radiusField.setBounds(150, 80, 200, 25);
        add(radiusField);

        /*
        Two buttons: Calculate and Reset.
        - Calculate: Calculates the surface area using the formula: Area = 3.14159 × r × r.
        - Reset: Clears all input and output fields.
         */
        final JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(370, 80, 100, 25);
        add(calculateButton);

        final JButton resetButton = new JButton("Reset");
        resetButton.setBounds(370, 120, 100, 25);
        add(resetButton);

        /*
        Labels and text fields for displaying the formula and the result (area).
        - Formula shows the step-by-step calculation with values.
        - Area shows the final computed result.
         */
        final JLabel formulaLabel = new JLabel("Formula Calculation:");
        formulaLabel.setBounds(50, 160, 150, 25);
        formulaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(formulaLabel);

        final JTextField formulaField = new JTextField();
        formulaField.setBounds(200, 160, 270, 25);
        formulaField.setEditable(false);
        add(formulaField);

        final JLabel areaLabel = new JLabel("Area:");
        areaLabel.setBounds(50, 200, 100, 25);
        areaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(areaLabel);

        final JTextField areaField = new JTextField();
        areaField.setBounds(150, 200, 320, 25);
        areaField.setEditable(false);
        add(areaField);

        /*
        Action Listener for the Calculate button.
        - Reads the radius from the input field.
        - Calculates the area using the formula: 3.14159 × radius × radius.
        - Displays the calculation formula and area in the output fields.
        */
        calculateButton.addActionListener(event -> 
        {
            try 
            {
                double radius = Double.parseDouble(radiusField.getText()); // Read input radius
                double pi = 3.14159; // Using numerical value for π
                double area = pi * radius * radius; // Calculate area (radius * radius explicitly)
                formulaField.setText(String.format("%.5f × %.2f × %.2f", pi, radius, radius)); // Display calculation
                areaField.setText(String.format("%.2f", area)); // Display result
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number for the radius.");
            }
        });

        /*
        Action Listener for the Reset button.
        - Clears the radius input field and both output fields.
         */
        resetButton.addActionListener(event -> 
        {
            radiusField.setText("");
            formulaField.setText("");
            areaField.setText("");
        });
    }
}
