/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class A1ex2 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		double p1,p2,p3,p4;
		
		out.print("Nota do primeiro teste pr�tico: ");
		p1=sc.nextDouble();
		out.print("\nNota do segundo teste pr�tico: ");
		p2=sc.nextDouble();
		out.print("\nNota do teste te�rico-pr�tico: ");
		p3=sc.nextDouble();
		out.print("\nNota do exame final: ");
		p4=sc.nextDouble();
		
		double notaf=(p1+p2+p3)*0.2+0.4*p4;
		out.println("A nota final do aluno � de " + notaf);
	}

}
