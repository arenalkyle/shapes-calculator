package calculator.threedshapes;

import javax.swing.*;
import java.awt.*;


public class RectangularPrism extends JFrame 
{

    public RectangularPrism() 
    {
        //Window setup
        setTitle("Surface Area Calculator For Rectangular Prism");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(RectangularPrism.class.getResource("/icon.png"))); // 16.1 11.3 13.3 7.4 24.9
        } catch (Exception ignored) {

        }

        //Title
        JLabel titleLabel = new JLabel("Surface Area Calculator For Rectangular Prism", JLabel.CENTER);
        titleLabel.setBounds(50, 20, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 128, 0));
        add(titleLabel);

        //Length input
        JLabel lengthLabel = new JLabel("Enter Length:");
        lengthLabel.setBounds(50, 80, 150, 25);
        lengthLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(lengthLabel);

        JTextField lengthField = new JTextField();
        lengthField.setBounds(200, 80, 150, 25);
        add(lengthField);

        //Width input
        JLabel widthLabel = new JLabel("Enter Width:");
        widthLabel.setBounds(50, 120, 150, 25);
        widthLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(widthLabel);

        JTextField widthField = new JTextField();
        widthField.setBounds(200, 120, 150, 25);
        add(widthField);

        //Height input
        JLabel heightLabel = new JLabel("Enter Height:");
        heightLabel.setBounds(50, 160, 150, 25);
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(200, 160, 150, 25);
        add(heightField);

        //Buttons
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(370, 160, 100, 25);
        add(calculateButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(370, 200, 100, 25);
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
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());
                double area = 2 * (length * width + length * height + width * height); // Rectangular Prism surface area formula
                formulaField.setText("2 × (" + length + " × " + width + " + " + length + " × " + height + " + " + width + " × " + height + ")");
                areaField.setText(String.valueOf(area));
            } 
            
            catch (NumberFormatException ex) 
            
            {
                JOptionPane.showMessageDialog(this, "Enter valid numbers.");
            }
        });

        resetButton.addActionListener(event -> 
        {
            lengthField.setText("");
            widthField.setText("");
            heightField.setText("");
            formulaField.setText("");
            areaField.setText("");
        });
    }
}
