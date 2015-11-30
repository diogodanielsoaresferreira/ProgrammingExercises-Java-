package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex305 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int a;
		
		out.print("Escreva um número positivo: ");
		a = sc.nextInt();
		
		
		while(a<=0){

			out.print("O número não é positivo. Escreva outro número: ");
			a = sc.nextInt();
			
		}
		
		if((a==1||a==2||a==3||a==5||a==7||a==11||a==13||a==17)){
			
			out.println("O número é primo");
			
		}
		
		else if((a%2==0)||(a%3==0)||(a%5==0)||(a%7==0)||(a%11==0)||(a%13==0)||(a%17==0)){
			
			out.println("O número não é primo");
			
		}
		else{
			out.println("O número é primo");
		}

	}

}
