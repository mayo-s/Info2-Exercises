package imi.calculator;

/**
 * Working Calculator cloned from https://github.com/EliGould/Exercise07
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */

public class Main {
	private static CalcEngine engine;
	private UserInterface gui;

	public static void main(String[] args) {
		
		Main calc = new Main();
		calc.show();
	}

	/**
	 * Create a new calculator and show it.
	 */
	public Main() {
		engine = new CalcEngine();
		gui = new UserInterface(engine);
	}

	/**
	 * In case the window was closed, show it again.
	 */
	public void show() {
		gui.setVisible(true);
	}
}