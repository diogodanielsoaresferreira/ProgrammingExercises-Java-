package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex302 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		double a=0, b=0;
		
		out.print("Insira os valores que deseja multiplicar: ");
		a = sc.nextDouble();

		do{
			out.print("Insira os valores que deseja multiplicar: ");
			b = sc.nextDouble();
			
			if (b==0) break;
			
			a = a * b;
			
			
		}while (b!=0);
		
		out.println("O produto dos números apresentados é " + a + ".");
	}

}
