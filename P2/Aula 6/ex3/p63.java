/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class p63 {
	
	public static void main(String[] args) {
		
		if(args.length>0){
			int i=args.length;
			i--;
			out.print(args[i]);
			String args2[] = new String [i];
			for(int j=0;j<i;j++){
				args2[j]=args[j];
			}
			
			main(args2);
		}

		
	}

}
