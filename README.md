# Java Calculator Application

A simple yet functional calculator application built with Java Swing. This application provides a clean interface for basic arithmetic operations with a modern, colorful design.

![Simple Calculator](https://github.com/user-attachments/assets/a9f2953c-e31b-4eac-938a-4c5eb15ce967)

## Features

- Basic arithmetic operations: addition, subtraction, multiplication, and division
- Additional functionality:
  - Percentage calculations
  - Sign toggling (+/-)
  - Decimal point support
  - Clear entry (CE)
  - Backspace function
- Modern UI with:
  - Color-coded buttons
  - Hover effects
  - Responsive layout
  - High-contrast display

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, etc.) or command line tools

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/java-calculator.git
   cd java-calculator
   ```

2. Compile the program:
   ```bash
   javac CalculatorFrame.java SwingCalculator.java
   ```

3. Run the application:
   ```bash
   java SwingCalculator
   ```

## Usage

- **Number Keys (0-9)**: Input numbers
- **Operation Keys (+, -, *, /)**: Perform basic arithmetic
- **Equal (=)**: Calculate result
- **CE**: Clear everything (resets calculator)
- **back**: Delete last digit (backspace)
- **+/-**: Toggle between positive and negative
- **%**: Convert number to percentage (divide by 100)
- **.**: Add decimal point

## Project Structure

- `CalculatorFrame.java`: Contains the main calculator UI and logic
- `SwingCalculator.java`: Entry point for the application

## How It Works

The calculator uses Java Swing for the graphical user interface. The main components include:

- `JFrame`: Main window container
- `JTextField`: Display for input and results
- `JButton`: Interactive buttons for user input
- `ActionListener`: Handles button click events

The calculator follows standard calculator logic:
1. Input first number
2. Select operation
3. Input second number
4. Press equal to get result

## Customization

You can easily customize the calculator by modifying the following in `CalculatorFrame.java`:

- Button colors and styles
- Font sizes and types
- Window dimensions
- Layout and spacing

## Acknowledgments

- Inspired by classic calculator designs
- Built using Java Swing for educational purposes
