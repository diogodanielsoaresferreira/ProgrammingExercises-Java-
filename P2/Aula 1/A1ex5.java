/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
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
			out.print("\nInsira o n�mero: ");
			n=sc.nextInt();
			soma+=n;
			i++;
		}while(n!=0);
		i--;
		if(i==0) out.println("A lista n�o tem elementos!");
		else{
			out.println("A soma dos n�meros � "+soma+" e a m�dia � de "+soma/i);
		}
	}

}
