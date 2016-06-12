package imi.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * Working Calculator cloned from https://github.com/EliGould/Exercise07
 * @author Jack Lai & Mario Schuetz
 *
 */

/**
 * A graphical user interface for the calculator. No calculation is being done
 * here. This class is responsible just for putting up the display on screen. It
 * then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class UserInterface implements ActionListener {

	protected CalcEngine calc;
	protected boolean showingAuthor;

	protected JFrame frame;
	protected JTextField display;
	protected JLabel status;
	private Component[] hexComponents;
	protected boolean isHex;
	private JToggleButton toggleButton;
	private String displayValue;

	/**
	 * Create a user interface.
	 * 
	 * @param engine
	 *            The calculator engine.
	 */
	public UserInterface(CalcEngine engine) {
		displayValue = "";
		calc = engine;
		showingAuthor = true;
		makeFrame();
		frame.setVisible(true);

	}

	protected void makeFrame() {

		hexComponents = new Component[6];
		frame = new JFrame(calc.getTitle());

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(5, 5));

		addButton(buttonPanel, "7");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "9");
		toggleButton = new JToggleButton("Hex", false);
		toggleButton.addActionListener(this);
		buttonPanel.add(toggleButton);
		addButton(buttonPanel, "/");
		addButton(buttonPanel, "CL");

		addButton(buttonPanel, "4");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "6");
		addButton(buttonPanel, "?");
		addButton(buttonPanel, "*");
		addButton(buttonPanel, "CE");

		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "+");
		addButton(buttonPanel, "^");

		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "0");
		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "-");
		addButton(buttonPanel, "=");

		addButton(buttonPanel, "A");
		addButton(buttonPanel, "B");
		addButton(buttonPanel, "C");
		addButton(buttonPanel, "D");
		addButton(buttonPanel, "E");
		addButton(buttonPanel, "F");

		Component[] allComponents = buttonPanel.getComponents();
		hexComponents[0] = allComponents[24];
		hexComponents[1] = allComponents[25];
		hexComponents[2] = allComponents[26];
		hexComponents[3] = allComponents[27];
		hexComponents[4] = allComponents[28];
		hexComponents[5] = allComponents[29];

		for (Component tempComp : hexComponents) {
			tempComp.setEnabled(false);
		}

		contentPane.add(buttonPanel, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
	}

	// @override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		switch (command) {
		case "=":
			if (!isHex)
				try {
					displayValue = calc.getDecSolution(displayValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (isHex)
				try {

					System.out.println(displayValue);
					displayValue = calc.getHexDisplayValue(displayValue);
					System.out.println(displayValue);
					displayValue = calc.getDecSolution(displayValue);
					System.out.println(displayValue);
					displayValue = calc.getHexDisplayValue(displayValue);
					System.out.println(displayValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;

		case "?":
			showInfo();
			break;

		case "CL":
			displayValue = "";
			break;

		case "CE":
			displayValue = displayValue.substring(0, displayValue.length() - 1);
			break;

		case "Hex":
			System.out.println("HexHex");
			switchHex();
			if (!displayValue.equals("")) {
				displayValue = calc.getHexDisplayValue(displayValue);
			}
			break;

		case "Dec":
			switchHex();
			if (displayValue.equals("")) {
				displayValue = calc.getDecDisplayValue(displayValue);
			}
			break;

		case "+":
			displayValue += " " + command + " ";
			break;

		case "-":
			displayValue += " " + command + " ";
			break;

		case "*":
			displayValue += " " + command + " ";
			break;

		case "/":
			displayValue += " " + command + " ";
			break;

		default:

			displayValue += command;

			break;
		}

		redisplay();

	}

	// @override
	protected void redisplay() {

		display.setText("" + displayValue);

	}

	protected void switchHex() {
		
		if (isHex) {
			toggleButton.setText("Hex");
			for (Component tempComp : hexComponents) {
				tempComp.setEnabled(false);

			}
			displayValue = "";
			isHex = false;
		}

		else {
			toggleButton.setText("Dec");
			for (Component tempComp : hexComponents) {
				tempComp.setEnabled(true);
			}
			displayValue = "";
			isHex = true;
		}
	}
	
	
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
	
	private void addButton(Container panel, String buttonText) {
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}

	private void showInfo() {
		if (showingAuthor)
			status.setText(calc.getVersion());
		else
			status.setText(calc.getAuthor());

		showingAuthor = !showingAuthor;
	}
}
