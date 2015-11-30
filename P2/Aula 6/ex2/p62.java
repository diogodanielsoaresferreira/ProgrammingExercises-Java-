/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class p62 {

	static int i=0;
	public static void main(String[] args) {

		while(i<args.length){
			out.println(args[i++]);
			main(args);
		}
		
	}

}
