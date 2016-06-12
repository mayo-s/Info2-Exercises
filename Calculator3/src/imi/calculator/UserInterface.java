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
	protected Set set;
	protected boolean showingAuthor;

	protected JFrame frame;
	protected JTextField display;
	protected JLabel status;
	private Component[] hexComponents;
	private Component[] nonSetComponents;
	protected boolean isHex;
	protected boolean isSet;
	private JToggleButton toggleButton;
	private JToggleButton toggleButton2;
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
		nonSetComponents = new Component[10];
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
		toggleButton2 = new JToggleButton("Set", false);
		toggleButton2.addActionListener(this);
		buttonPanel.add(toggleButton2);
		addButton(buttonPanel, "*");
		addButton(buttonPanel, "CE");

		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");
		addButton(buttonPanel, "?");
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

		nonSetComponents[0] = allComponents[3];
		nonSetComponents[1] = allComponents[4];
		nonSetComponents[2] = allComponents[10];
		nonSetComponents[3] = allComponents[17];
		nonSetComponents[4] = allComponents[24];
		nonSetComponents[5] = allComponents[25];
		nonSetComponents[6] = allComponents[26];
		nonSetComponents[7] = allComponents[27];
		nonSetComponents[8] = allComponents[28];
		nonSetComponents[9] = allComponents[29];

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
			if(isSet){
				set.output();				
			}
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
			// System.out.println("HexHex");
			switchHex();
			if (!displayValue.equals("")) {
				displayValue = calc.getHexDisplayValue(displayValue);
			}
			break;
		case "Dec":
			switchHex();
			if (!displayValue.equals("")) {
				displayValue = calc.getDecDisplayValue(displayValue);
			}
			break;

		case "Set":
			switchSet();
			break;
		case "!Set":
			switchSet();
			break;
		case "+":

			if (isSet) {
				int value = Integer.parseInt(displayValue);
				set.add(value);

			} else {
				displayValue += " " + command + " ";
			}
			break;

		case "-":
			if (isSet) {
				int value = Integer.parseInt(displayValue);
				set.remove(value);
				
			} else {
				displayValue += " " + command + " ";
			}
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
			switchSet();
			toggleButton.setText("Dec");
			for (Component tempComp : hexComponents) {
				tempComp.setEnabled(true);
			}
			displayValue = "";
			isHex = true;
		}
	}

	protected void switchSet() {

		if (!isSet) {
			set = new Set();
			toggleButton2.setText("!Set");
			for (Component tempComp : nonSetComponents) {
				tempComp.setEnabled(false);
			}

			displayValue = "";
			isSet = true;
			isHex = false;
		}

		else {
			toggleButton2.setText("Set");
			nonSetComponents[0].setEnabled(true);
			nonSetComponents[1].setEnabled(true);
			nonSetComponents[2].setEnabled(true);
			nonSetComponents[3].setEnabled(true);
			displayValue = "";
			isSet = false;
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
