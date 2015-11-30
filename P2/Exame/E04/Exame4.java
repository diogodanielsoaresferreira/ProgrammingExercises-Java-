/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class Exame4 {
	
	public static void main(String[] args)
	   {
	      for(int i = 0; i < args.length; i++){
	    	 factor = "1";
	         out.println(args[i]+" = "+factors(Integer.parseInt(args[i])));
	      }
	   }
	static String factor;
	public static String factors(int n){
		int i=2;
		if(n==0) return "0";
		if(n==1) return factor;
		
		for(;;i++){
			if(n%i==0) break;
		}
		factor += " * "+i;
		n = n/i;
		if(n!=1) factors(n);
		
		return factor;
	}
}
