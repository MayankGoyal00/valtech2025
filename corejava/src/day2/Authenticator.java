package day2;

import java.util.Random;

public class Authenticator {
	public long authenticate(String name, String pass)throws Exception {
		//if(name.equals("scott") && pass.equals("tiger")) 
		if("scott".equals(name) && "tiger".equals(pass)){
			return new Random().nextLong(); 
		}
		throw new Exception("only scott allowed");
		
			
	}
}
