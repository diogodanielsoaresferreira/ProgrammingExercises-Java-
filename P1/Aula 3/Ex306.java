package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex306 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int a, b, c, i;
		
		out.print("Insira um número inteiro: ");
		a = sc.nextInt();
		out.print("\nInsira agora o outro: ");
		b = sc.nextInt();
		
		if(a<b){
			i=a;
			a=b;
			b=i;
		}
		
		do{
			c=a%b;
			if(c==0){
				out.println("O maior divisor comum é " + b + ".");
			}
			else{
				b=c;
			}
			
		}while(c!=0);
	}

}
