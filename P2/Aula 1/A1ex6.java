/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.util.Scanner;
import static java.lang.System.*;

public class A1ex6 {
	
	static final Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		int al=(int)(Math.random()*(100+1)), i=0,num;
		
		do{
			out.print("\nEscreva o número que acha o correto: ");
			num=sc.nextInt();
			i++;
			if(num==al) break;
			else if (num<al) out.println("Um pouco mais alto...");
			else out.println("Um pouco mais baixo...");
		}while(num!=al);
		
		out.println("Parabéns, acertou! Teve a pontuação "+i+".");
	}
}
