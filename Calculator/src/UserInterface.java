import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A graphical user interface for the calculator. No calculation is being done
 * here. This class is responsible just for putting up the display on screen. It
 * then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30 edited by Mario Schuetz & Kevin Klaus
 */
public class UserInterface implements ActionListener {
	private CalcEngine calc;
	private boolean showingAuthor;
	private boolean hexOnOff;
	private HexEngine hexEn;
	private JFrame frame;
	private JTextField display;
	private JLabel status;

	/**
	 * Create a user interface.
	 * 
	 * @param engine
	 *            The calculator engine.
	 */
	public UserInterface(CalcEngine engine) {
		calc = engine;
		hexEn = new HexEngine();
		showingAuthor = true;
		hexOnOff = false;
		makeFrame();
		frame.setVisible(true);
	}

	/**
	 * Set the visibility of the interface.
	 * 
	 * @param visible
	 *            true if the interface is to be made visible, false otherwise.
	 */
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	/**
	 * Make the frame for the user interface.
	 */
	private void makeFrame() {
		frame = new JFrame(calc.getTitle());

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		int columns = hexVisibility();

		JPanel buttonPanel = new JPanel(new GridLayout(columns, 4));
		addButton(buttonPanel, "7");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "9");
		addButton(buttonPanel, "CLEAR");

		addButton(buttonPanel, "4");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "6");
		addButton(buttonPanel, "?");

		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");
		addButton(buttonPanel, "0");

		addButton(buttonPanel, "A");
		addButton(buttonPanel, "B");
		addButton(buttonPanel, "C");
		addButton(buttonPanel, "HEX");

		addButton(buttonPanel, "D");
		addButton(buttonPanel, "E");
		addButton(buttonPanel, "F");
		addCheckbox(buttonPanel, "switch result");
		// buttonPanel.add(new JLabel(" "));

		addButton(buttonPanel, "*");
		addButton(buttonPanel, "/");
		addButton(buttonPanel, "+");
		addButton(buttonPanel, "-");

		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "=");

		contentPane.add(buttonPanel, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
	}

	/**
	 * Add a button to the button panel.
	 * 
	 * @param panel
	 *            The panel to receive the button.
	 * @param buttonText
	 *            The text for the button.
	 */
	private void addButton(Container panel, String buttonText) {
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}

	private void addCheckbox(Container panel, String checkboxText) {
		JCheckBox checkbox = new JCheckBox(checkboxText);
		checkbox.addActionListener(this);
		panel.add(checkbox);
	}

	/**
	 * An interface action has been performed. Find out what it was and handle
	 * it.
	 * 
	 * @param event
	 *            The event that has occured.
	 */
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		if (command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3")
				|| command.equals("4") || command.equals("5") || command.equals("6") || command.equals("7")
				|| command.equals("8") || command.equals("9") || command.equals("A") || command.equals("B")
				|| command.equals("C") || command.equals("D") || command.equals("E") || command.equals("F")) {
			int number = Integer.parseInt(command);
			calc.numberPressed(number);
		} else if (command.equals("+")) {
			calc.plus();
		} else if (command.equals("-")) {
			calc.minus();
		} else if (command.equals("=")) {
			calc.equals();
		} else if (command.equals("CLEAR")) {
			calc.clear();
		} else if (command.equals("?")) {
			showInfo();
		} else if (command.equals("*")) {
			calc.multiply();
		} else if (command.equals("/")) {
			calc.divide();
		} else if (command.equals("HEX")) {
			hexEn.activate();
			hexVisibility();
			makeFrame();
		}
		// else unknown command.

		redisplay();
	}

	/**
	 * Update the interface display to show the current value of the calculator.
	 */
	private void redisplay() {
		display.setText("" + calc.getDisplayValue());
	}

	/**
	 * Toggle the info display in the calculator's status area between the
	 * author and version information.
	 */
	private void showInfo() {
		if (showingAuthor)
			status.setText(calc.getVersion());
		else
			status.setText(calc.getAuthor());

		showingAuthor = !showingAuthor;
	}

	/**
	 * make hex-buttons un-/visible
	 * 
	 * @return
	 */
	private int hexVisibility() {
		int columns;
		if (!hexOnOff) {
			hexOnOff = true;
			columns = 7;
		} else {
			hexOnOff = false;
			columns = 4;
		}

		return columns;

	}
}
