package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex507 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int a, b;
		
		out.println("Insira um número: ");
		a=sc.nextInt();
		
		out.println("Insira outro número: ");
		b=sc.nextInt();
		
		if (b>a) {int i=a; a=b; b=i;}
		
		mdc(a,b);

	}

	public static void mdc(int a, int b){
		int c;
		
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
