/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class A1ex4 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		String frase;
		
		out.print("Insira a frase que deseja traduzir: ");
		frase=sc.nextLine();
		frase=translator(frase);
		out.print("\nA frase fica: "+frase);
	}
	
	public static String translator (String frase){
		int n=frase.length();
		String frase2="";
		
		for(int i=0;i<n;i++){
			if(frase.charAt(i)=='R' || frase.charAt(i)=='r');
			else if(frase.charAt(i)=='L') frase2+='U';
			else if(frase.charAt(i)=='l') frase2+='u';
			else frase2+=frase.charAt(i);
		}
		
		return frase2;
	}

}
