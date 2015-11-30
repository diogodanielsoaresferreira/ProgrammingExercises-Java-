package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class ex209 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int i;
		double a;
		
		out.print("Se vai escrever em Celsius escreva 0, em Fahrenheit escreva 1: ");
		i = sc.nextInt();
		out.print("\nEscreva agora a temperatura que deseja converter: ");
		a = sc.nextDouble();
		
		if (i==0){
			
			a = 1.8*a + 32;
			out.println("São " + a + " Fahrenheit.");
			
		}
		else if (i==1){
			
		
			a = (a-32)/1.8;
			out.println("São " + a + " Celsius.");
			
		}
		else{
			out.print("Erro!");
			
		}

	}

}
