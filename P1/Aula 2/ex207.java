package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class ex207 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int a, b, c, i;
		
		out.print("Escreva o primeiro número: ");
		a = sc.nextInt();
		out.print("\nEscreva agora o segundo número: ");
		b = sc.nextInt();
		out.print("\nEscreva o último número: ");
		c = sc.nextInt();
		
		if (c>b){
				
			i=c;
			c=b;
			b=i;
			}

		if (b>a){
			
			i=a;
			a=b;
			b=i;
		}
		if (c>a){
			
			i=a;
			a=c;
			c=i;
			
		}
		if (c>b){
			
			i=c;
			c=b;
			b=i;
			}
		

			
			
		out.println("Os números ordenados por ordem decrescente são " + a + ", " + b + ", " + c + ".");
			
	}

}
