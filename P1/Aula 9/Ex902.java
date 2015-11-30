package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex902 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int []a = new int [100];
		int b;
		int i=0;
		int c=0;
		int k=0;
		
		out.print("Insira o número que deseja contar: ");
		c = sc.nextInt();
		
		while(c<0){
			out.print("\nNúmero inválido. Insira número inteiro nulo ou positivo: ");
			c = sc.nextInt();
		}
		
		out.print("\nVamos agora passar para a contagem dos números!");
		out.print("\nInsira um número: ");
		b = sc.nextInt();
		
		while(b>=0 && i!=99){
			a[i] = b;
			out.print("\nInsira outro número: ");
			b = sc.nextInt();
			i++;
		}
		
		for(int j=0; j<=99; j++){
			if(a[j]==c) k++;
		}
		
		out.print("O número pedido foi inserido " + k + " vezes.");
		
	}

}
