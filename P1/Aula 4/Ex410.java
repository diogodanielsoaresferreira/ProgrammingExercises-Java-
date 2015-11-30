package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex410 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		int a=0, b=0, soma=1;
		
		do{
			out.print("Insira um número inteiro positivo: ");
			a = sc.nextInt();
			
		}while(a<=0);

		b=a;
		do{
			if(b%2==0 ){
				b = b/2;
				soma += 2;
			}
			else if(b%3==0 ){
				b = b/3;
				soma += 3;
			}
			else if(b%5==0 ){
				b = b/5;
				soma += 5;
			}
			else if(b%7==0 ){
				b = b/7;
				soma += 7;
			}
			else if(b%11==0 ){
				b = b/11;
				soma += 11;
			}
			else if(b%13==0 ){
				b = b/13;
				soma += 13;
			}
			else if(b%17==0 ){
				b = b/17;
				soma += 17;
			}
			else if(b%19==0 ){
				b = b/19;
				soma += 19;
			}
			
		}while (b!=1);
		
		if (soma==a) out.print("O número é perfeito!");
		else out.print("O número não é perfeito.");
	}

}
