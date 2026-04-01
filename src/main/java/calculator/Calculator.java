package calculator;

import calculator.conversions.Currency;
import calculator.conversions.Temperature;
import calculator.conversions.Time;
import calculator.conversions.Volume;
import calculator.threedshapes.Cube;
import calculator.threedshapes.Cylinder;
import calculator.threedshapes.RectangularPrism;
import calculator.twodshapes.Circle;
import calculator.twodshapes.Square;
import calculator.twodshapes.Triangle;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    private static JPanel mainPanel; // Using static reference instead of passing as a parameter to each function.

    public Calculator() {
        // Layout Size
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(Calculator.class.getResource("/icon.png"))); // 16.1 11.3 13.3 7.4 24.9
        } catch (Exception ignored) {

        }

        // Main Panel Layout
        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        getContentPane().add(mainPanel);

        /*
        Instead of added everything in the constructor, we instead use 5 void functions categorized by section and GUI component type.
         */
        setTitles();
        set2DButtons();
        set3DButtons();
        setCCMenuButtons();
        setSeparators();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
        {
            final Calculator frame = new Calculator();
            frame.setVisible(true);
        });
    }

    public void setTitles() {
        /*
        Titles are added. Use JLabels and basic editing of properties, each is then added to mainPanel individually.
         */
        final JLabel titleLabel = new JLabel("2D and 3D Shapes Surface Area Calculator Menu", JLabel.CENTER);
        titleLabel.setBounds(181, 28, 422, 22);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel);

        final JLabel twoDLabel = new JLabel("2D Shapes", JLabel.CENTER);
        twoDLabel.setBounds(153, 106, 82, 19);
        mainPanel.add(twoDLabel);
        twoDLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

        final JLabel threeDLabel = new JLabel("3D Shapes", JLabel.CENTER);
        threeDLabel.setBounds(551, 106, 82, 19);
        mainPanel.add(threeDLabel);
        threeDLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));

        final JLabel conversionLabel = new JLabel("Conversions Calculator Menu", JLabel.CENTER);
        conversionLabel.setBounds(181, 478, 422, 19);
        conversionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(conversionLabel);
    }

    public void set2DButtons() {
        /*
        Buttons added for 2D Shape's section.
        - Listener is added to check for mouse action. If clicked, we use the event passed to invoke a lambda expression with
          no arguments that then calls on the class and creates the new JFrame.
         */
        final JButton circleButton = new JButton("Circle");
        circleButton.setBounds(128, 189, 141, 23);
        mainPanel.add(circleButton);
        circleButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Circle().setVisible(true)));
        circleButton.setPreferredSize(new Dimension(130, 50));

        final JButton triangleButton = new JButton("Triangle");
        triangleButton.setBounds(128, 248, 141, 23);
        mainPanel.add(triangleButton);
        triangleButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Triangle().setVisible(true)));
        triangleButton.setPreferredSize(new Dimension(130, 50));

        final JButton squareButton = new JButton("Square");
        squareButton.setBounds(128, 306, 141, 23);
        mainPanel.add(squareButton);
        squareButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Square().setVisible(true)));
        squareButton.setPreferredSize(new Dimension(130, 50));
    }

    public void set3DButtons() {
        /*
        Buttons added for 3D Shape's section.
        - Listener is added to check for mouse action. If clicked, we use the event passed to invoke a lambda expression with
          no arguments that then calls on the class and creates the new JFrame.
         */
        final JButton cylinderButton = new JButton("Cylinder");
        cylinderButton.setBounds(516, 306, 141, 23);
        mainPanel.add(cylinderButton);
        cylinderButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Cylinder().setVisible(true)));
        cylinderButton.setPreferredSize(new Dimension(130, 50));

        final JButton prismButton = new JButton("Rectangular Prism");
        prismButton.setBounds(516, 248, 141, 23);
        mainPanel.add(prismButton);
        prismButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new RectangularPrism().setVisible(true)));
        prismButton.setPreferredSize(new Dimension(130, 50));

        final JButton cubeButton = new JButton("Cube");
        cubeButton.setBounds(516, 189, 141, 22);
        mainPanel.add(cubeButton);
        cubeButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Cube().setVisible(true)));
        cubeButton.setPreferredSize(new Dimension(130, 50));
    }

    public void setCCMenuButtons() {
        /*
        Buttons added for Conversion Calculator Menu's section.
        - Listener is added to check for mouse action. If clicked, we use the event passed to invoke a lambda expression with
          no arguments that then calls on the class and creates the new JFrame.
         */
        final JButton volumeButton = new JButton("Volume");
        volumeButton.setBounds(52, 547, 206, 23);
        mainPanel.add(volumeButton);
        volumeButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Volume().setVisible(true)));

        final JButton currencyButton = new JButton("Currency");
        currencyButton.setBounds(527, 547, 206, 23);
        mainPanel.add(currencyButton);
        currencyButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Currency().setVisible(true)));

        final JButton timeButton = new JButton("Time");
        timeButton.setBounds(527, 610, 206, 23);
        mainPanel.add(timeButton);
        timeButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Time().setVisible(true)));

        final JButton temperatureButton = new JButton("Temperature");
        temperatureButton.setBounds(52, 610, 206, 23);
        mainPanel.add(temperatureButton);
        temperatureButton.addActionListener(event -> SwingUtilities.invokeLater(() -> new Temperature().setVisible(true)));
    }

    public void setSeparators() {
        /*
        Separators added. 
         */
        final JSeparator ccMenuTopSeparator = new JSeparator();
        ccMenuTopSeparator.setForeground(Color.BLACK);
        ccMenuTopSeparator.setBounds(0, 467, 784, 30);
        mainPanel.add(ccMenuTopSeparator);

        final JSeparator ccMenuBotSeparator = new JSeparator();
        ccMenuBotSeparator.setForeground(Color.BLACK);
        ccMenuBotSeparator.setBounds(0, 508, 784, 2);
        mainPanel.add(ccMenuBotSeparator);

        final JSeparator headerSeparator = new JSeparator();
        headerSeparator.setForeground(Color.BLACK);
        headerSeparator.setBounds(0, 61, 784, 2);
        mainPanel.add(headerSeparator);

        final JSeparator verticalSeparator = new JSeparator();
        verticalSeparator.setForeground(Color.BLACK);
        verticalSeparator.setOrientation(SwingConstants.VERTICAL);
        verticalSeparator.setBounds(367, 61, 2, 406);
        mainPanel.add(verticalSeparator);
    }
}
