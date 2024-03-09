import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculator {

	public static void constructGUI() {
		
		// setup JFrame
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setTitle("Simple Calculator");
		frame.setLayout(new GridLayout(5, 2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// setup text field inputs
		JLabel firstNumber = new JLabel("First Number: ");
		JLabel secondNumber = new JLabel("Second Number: ");
		JTextField firstInput = new JTextField();
		JTextField secondInput = new JTextField();
		
		// setup dropdown menu
		String[] operations = {"Add", "Subtract", "Multiply", "Divide"};
		JComboBox<String> dropdown = new JComboBox<String>(operations);
		
		
		// setup calculate button
		JButton button = new JButton("Calculate");
		
		// setup result label
		JLabel result = new JLabel("Result: ");
		
		// add action listener for button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	try {
            	// get information from both text fields and the dropdown menu
                    double num1 = Double.parseDouble(firstInput.getText());
                    double num2 = Double.parseDouble(secondInput.getText());
                    String operation = (String) dropdown.getSelectedItem();
                    
                    // determine correct operation to use
                    if (operation.equals("Add")) { // add
                        result.setText("Result: " + Double.toString(num1+num2));
                    }
                    else if (operation.equals("Subtract")) { // subtract
                        result.setText("Result: " + Double.toString(num1-num2));
                    }
                    if (operation.equals("Multiply")) { // multiply
                        result.setText("Result: " + Double.toString(num1*num2));
                    }
                    if (operation.equals("Divide")) { // divide
                        result.setText("Result: " + Double.toString(num1/num2));
                    }
            	}
            	catch (Exception e) { // check if invalid input was given
            		result.setText("Invalid input!");
            	}
                
            }
        });
        
        // add components to frame
        frame.add(firstNumber);
		frame.add(firstInput);
		frame.add(secondNumber);
		frame.add(secondInput);
        frame.add(new JLabel(""));
        frame.add(dropdown);
		frame.add(new JLabel(""));
        frame.add(button);
        frame.add(result);
        
		// display GUI 
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}
		});
	}

}