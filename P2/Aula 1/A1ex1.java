/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class A1ex1 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args){
		double a, b;
		String c;
		
		out.print("Insira uma conta a efetuar com os operadores +,-,*,/ separados por espaços: ");
		a=sc.nextInt();
		c=sc.next();
		b=sc.nextInt();
		
		if(c=="+" && c=="-" && c=="*" && c=="/") err.println("Operador inválido!");
		else{
			switch (c){
			
			case "+":
				out.println(a+b);
				break;
			case "-":
				out.println(a-b);
				break;
			case "*":
				out.println(a*b);
				break;
			case "/":
				out.println(a/b);
				break;
			}
		}
	}
}
