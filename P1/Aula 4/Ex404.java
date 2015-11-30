package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex404 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int n/*, denominator=1*/; 
		double soma=0, par=0, impar=0;
		boolean paridade;
		
		out.print("Insira um número inteiro: ");
		n = sc.nextInt();
		
		
		/*for (int i = 0; i < n; i++) {
			 
	         if (i % 2 == 0) {
	            soma = soma + (1 / denominator);
	         } else {
	            soma = soma - (1 / denominator);
	         }
	         denominator = denominator + 1;
	      }

	      System.out.printf("%.15f", soma);*/
		
		
		if(n%2==0) paridade=true;
		else paridade = false;
		
		if(paridade){
			for (int i=1; i<n; i +=2){
				impar=impar + (1/((2*i)-1));
			}
			for (int i=2; i<=n; i +=2){
				par=par - (1/((2*i)-1));
			}
			out.println(par + ";" + impar);
		}
		else{
			for (int i=1; i<=n; i +=2){
				impar=impar + (1/((2*i)-1));
			}
			for (int i=2; i<n; i +=2){
				par=par - (1/((2*i)-1));
			}
			out.println(par + ";" + impar);
		}

			
			soma=par+impar;
			out.printf("%.15f", soma);
			
		if (soma>((Math.PI)/4)) out.println("\nA soma é maior que pi sobre 4.");
		else if (soma<((Math.PI/4))) out.println("A soma é menor que pi sobre 4.");
		else out.println("A soma é igual a pi sobre 4.");
	}

}
