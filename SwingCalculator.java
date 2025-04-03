public class SwingCalculator {
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure thread safety
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculatorFrame frame = new CalculatorFrame(); // Create the calculator GUI
            frame.setVisible(true); // Display the calculator window
        });
    }
}