/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class Exame8 {
	
	public static void main(String []args){
		System.out.println(args[0] + " is prefixed by "+args[1]+" -> "+isPrefix(args[0], args[1]));

		if(args.length%2==1 || args.length==0){
			exit(1);
		}
		for(int i=0;i<args.length;i+=2)
		System.out.println(args[i] + " is prefixed by "+args[i+1]+" -> "+isPrefix(args[i], args[i+1]));
		
	}
	
	static boolean isPrefix(String a, String b){
		
		if(a.length()==0) return false;
		else if(b.length()>0){
			if(a.charAt(0)!=b.charAt(0)) return false;
			return isPrefix(a.substring(1), b.substring(1));
		}
		
		return true;
	}
	
}
