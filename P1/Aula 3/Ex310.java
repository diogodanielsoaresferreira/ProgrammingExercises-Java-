package p1;

import java.util.Scanner;
import static java.lang.System.*;


public class Ex310 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int a, b, c=0;
		
		out.print("Insira o primeiro número: ");
		a = sc.nextInt();
		
		double max=a, min=a;
		
		do{
			
		out.print("\nInsira agora o outro número: ");
		b = sc.nextInt();
		
		
		if(b==2*c) break;
		
		if(b<min) min=b;
		if(b>max) max=b;
		
		c=b;
		
		}while(b!=0);
	

		out.println("O maior número lido foi " + max + ", o menor foi " + min + ", os valores que deram forçaram a paragem foram " + c + " e " + b + ".");
}
}

