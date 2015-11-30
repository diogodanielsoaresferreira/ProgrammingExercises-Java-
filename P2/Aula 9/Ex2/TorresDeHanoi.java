/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class TorresDeHanoi {

	final static Scanner sc = new Scanner (System.in);
	
	@SuppressWarnings(value = "unchecked")
	public static void main(String[] args) {
		
		pilhaHanoi <Integer> a = new pilhaHanoi <Integer>(5);
		pilhaHanoi <Integer> b = new pilhaHanoi <Integer>(5);
		pilhaHanoi <Integer> c = new pilhaHanoi <Integer>(5);
		
		for(int i=1;i<6;i++)
			a.push(i);
		
		writeT(a,b,c);
		hanoiT(5,a,b,c);
	}
	
	public static void writeT(pilhaHanoi a, pilhaHanoi b, pilhaHanoi c){

		
		out.print("\n |");
		out.print("\nA|\t");
		a.writeL();
		out.print("\n |");
		out.print("\nB|\t");
		b.writeL();
		out.print("\n |");
		out.print("\nC|\t");
		c.writeL();
		out.print("\n |");
	}
	
	public static void hanoiT(int n, pilhaHanoi a, pilhaHanoi b, pilhaHanoi c){
		assert n >= 0;
		
		if (n>0){
			hanoiT(n-1, a,c,b);
			b.push(a.top());
			a.pop();
			hanoiT(n-1, c,b,a);
		}
		writeT(a,b,c);
		sc.nextLine();
	}

}
