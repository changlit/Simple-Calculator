import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {
    private JTextField display;
    private double firstNumber = 0;
    private String operation = "";
    private boolean startNewNumber = true;

    public CalculatorFrame() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(350, 500); // Adjust size for better spacing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28)); // Larger font for better readability
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.GREEN);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Update button sequence to replace "^" with "*"
        String[] buttonLabels = {
            "CE", "back", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10)); // Adjust grid layout for proper sequence
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around buttons
        buttonPanel.setBackground(Color.DARK_GRAY); // Set background color for the button panel

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Add border to buttons

            // Correct color assignment logic
            if ("CE".equals(label)) {
                button.setBackground(Color.RED); // Clear button in red
                button.setForeground(Color.WHITE);
            } else if ("back".equals(label)) {
                button.setBackground(Color.YELLOW); // Backspace button in yellow
                button.setForeground(Color.BLACK);
            } else if ("/".equals(label) || "*".equals(label) || "-".equals(label) || "+".equals(label) || "=".equals(label)) {
                button.setBackground(Color.ORANGE); // Operation buttons
                button.setForeground(Color.BLACK);
            } else if ("%".equals(label) || "+/-".equals(label)) {
                button.setBackground(Color.CYAN); // Special operation buttons
                button.setForeground(Color.BLACK);
            } else {
                button.setBackground(Color.LIGHT_GRAY); // Number buttons
                button.setForeground(Color.BLACK);
            }

            // Add hover effect
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(button.getBackground().darker());
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if ("CE".equals(label)) {
                        button.setBackground(Color.RED);
                    } else if ("back".equals(label)) {
                        button.setBackground(Color.YELLOW);
                    } else if ("/".equals(label) || "*".equals(label) || "-".equals(label) || "+".equals(label) || "=".equals(label)) {
                        button.setBackground(Color.ORANGE);
                    } else if ("%".equals(label) || "+/-".equals(label)) {
                        button.setBackground(Color.CYAN);
                    } else {
                        button.setBackground(Color.LIGHT_GRAY);
                    }
                }
            });

            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Add components to frame
        setLayout(new BorderLayout(10, 10)); // Add spacing between components
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("back")) { // Handle Backspace
            String currentText = display.getText();
            if (!currentText.isEmpty()) {
                display.setText(currentText.substring(0, currentText.length() - 1)); // Remove the last character
            }
        } else if (command.equals("CE")) {
            display.setText(""); // Clear the display
            firstNumber = 0;
            operation = "";
            startNewNumber = true;
        } else if (command.equals("+/-")) {
            String currentText = display.getText();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText) * -1; // Toggle sign
                display.setText(String.valueOf(value));
            }
        } else if (command.equals("%")) {
            String currentText = display.getText();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText) / 100; // Percentage calculation
                display.setText(String.valueOf(value));
            }
        } else if (command.equals("=")) {
            if (!operation.isEmpty()) {
                double secondNumber = Double.parseDouble(display.getText());
                double result = calculate(firstNumber, secondNumber, operation);
                display.setText(String.valueOf(result));
                operation = "";
                startNewNumber = true;
            }
        } else if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            if (startNewNumber) {
                display.setText("");
                startNewNumber = false;
            }
            display.setText(display.getText() + command);
        } else {
            // Operation button (+, -, *, /)
            if (!operation.isEmpty()) {
                double secondNumber = Double.parseDouble(display.getText());
                double result = calculate(firstNumber, secondNumber, operation);
                display.setText(String.valueOf(result));
                firstNumber = result;
            } else {
                firstNumber = Double.parseDouble(display.getText());
            }
            operation = command;
            startNewNumber = true;
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if (b == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
                return a / b;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculatorFrame frame = new CalculatorFrame();
            frame.setVisible(true);
        });
    }
}
