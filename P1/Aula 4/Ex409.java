package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex409 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		int a, soma=0, b=0;
		
		do{
		out.print("Insira um número positivo: ");
		a = sc.nextInt();
		
		}while(a<=0 || a>=1000);
		
		for(int i=1; i<=a; i++){
			
			b=2*i;
			soma += b;
			out.print(b + "; ");
		};
		out.print("\nA soma é de " + soma +".");
		
	}

}
