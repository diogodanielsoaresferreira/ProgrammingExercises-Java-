/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

import java.util.Scanner;

public class p71 {
	
	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		String a = null,b = null;
		
		out.print("Insira a primeira frase: ");
		a = sc.next();
		out.print("\nInsira a segunda frase: ");
		b = sc.next();
		out.println("A distância é " + dist(a,b));
	}

	public static int dist(String a, String b){
		
		assert a.length()>=0 && b.length()>=0;
		
		if(a.length()==0)
		      return b.length();
		else if(b.length()==0)
		      return a.length();
		
		
		if(a.charAt(0)==b.charAt(0)){

			return dist(a.substring(1),b.substring(1));
		}
		else{
			int n1 = dist(a, b.substring(1)), n2 = dist(b,a.substring(1)), n3 = dist(a.substring(1),b.substring(1));
			
			return 1 + Math.min(Math.min(n1,n2), Math.min(n2,n3));
		}

	}
	
}
