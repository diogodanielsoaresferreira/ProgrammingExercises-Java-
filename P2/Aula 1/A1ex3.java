/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.util.Scanner;
import static java.lang.System.*;

public class A1ex3 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int num;
		boolean prime=true;
		
		out.print("Insira um número para saber se ele é primo: ");
		num=sc.nextInt();
		
		if (num==1) prime=false;
		for(int i=2;i<num;i++){
			if(num%i==0) prime=false;
		}
		if(prime) out.println("O número "+num+" é primo!");
		else out.println("O número "+num+" não é primo!");
		
	}

}
