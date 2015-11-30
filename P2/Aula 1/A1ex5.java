/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class A1ex5 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int soma=0,i=0,n=0;
		
		do{
			out.print("\nInsira o número: ");
			n=sc.nextInt();
			soma+=n;
			i++;
		}while(n!=0);
		i--;
		if(i==0) out.println("A lista não tem elementos!");
		else{
			out.println("A soma dos números é "+soma+" e a média é de "+soma/i);
		}
	}

}
