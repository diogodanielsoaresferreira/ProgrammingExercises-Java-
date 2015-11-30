/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class Exame3 {

	public static void main(String[] args) {
		
		for(String a : args){
			System.out.println(a+" -> "+invertDigits(a, ""));
		}
		
	}
	
	// Função mesmo linda!!!
	public static String invertDigits(String a, String carry){
		String ret = ""; 
		
		if(0==a.length()) return ret;
		
		if(Character.isDigit(a.charAt(0))){
			if(a.length()>1 && Character.isDigit(a.charAt(1))){
				ret += invertDigits(a.substring(1), ""+a.charAt(0)+carry);
			}
			else{
				ret += a.charAt(0)+carry;
				ret += invertDigits(a.substring(1), "");
			}
		}
		else{
			ret += a.charAt(0);
			ret += invertDigits(a.substring(1), "");
		}
		
		
		return ret;
	}
}
