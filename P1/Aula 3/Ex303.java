package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex303 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		double a=0, b=0,med=0;
		int i=1;
		
		out.print("Insira um número: ");
		a = sc.nextDouble();
		
		double max=a, min=a, c=a;
		
		for (i=1;;){
			
			out.print("Insira outro numero: ");
			b = sc.nextDouble();
			c=c+b;
			
			if (b==a) break;
			
			i++;
			if (a>b){
				if(max<a){
					max = a;
				}
				if(min>b){
					min = b;
				}
			else{
				if(max<b){
					max = b;
				}
				if(min>a){
					min = a;
				}
				
			}
			}
			
			med = c/i;
			
		}
		
		out.println("O valor máximo foi " + max + ", o valor mínimo foi " + min + ", a média foi " + med + " e a lista tem " + i + " elementos.");
	}

}
