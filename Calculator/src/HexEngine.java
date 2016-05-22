
public class HexEngine extends CalcEngine{
	
	private int hex2int(String hexValue){
		
		int hex2int = Integer.parseInt(hexValue, 16);		
		
		return hex2int;
	}
	
	private String int2hex(int intValue){
		String int2hex = Integer.toHexString(intValue);
		return int2hex;
	}

}
