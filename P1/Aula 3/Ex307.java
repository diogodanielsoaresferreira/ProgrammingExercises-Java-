package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex307 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		double a=0;
		int b, c=0, i=0;
		
		out.print("Insira o valor inteiro A: ");
		a = sc.nextDouble();
		out.print("Insira o valor inteiro B: ");
		b = sc.nextInt();
		
		if(a>b){
			
			i=(int)a;
			a=b;
			b=i;
			
		}
		
		do{
			if (a%2 != 0){
				
				c=c+b;
				
			}
			a = Math.floor(a);
			a=a/2; 
			b=2*b;
			
		}while (a!=1);
		c=c+b;

		out.println("A soma dos seus valores é igual a " + c + ".");
	}

}
