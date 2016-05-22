public class HexEngine extends CalcEngine {
	// HEX button pressed?
	private boolean hex;

	public HexEngine() {
		hex = false;
	}
	// intBack = toInt(hex);
	// hexBack = toHex(in);

	// returns int in as a string representing a the appropriate hex number or
	// "number too large" if not applicable
	private String toHex(int integerHex) {
		String hex = "number too large";
		hex = Integer.toHexString(integerHex);
		return hex;
	}

	// returns string hex as an integer or -1 if not applicable
	private int toInt(String hexString) {
		int integerHex = -1;
		// in = Integer.decode(hexString);
		return integerHex;
	}

	public void activate() {
		if (!this.hex)
			this.hex = true;
		else
			this.hex = false;
	}
}