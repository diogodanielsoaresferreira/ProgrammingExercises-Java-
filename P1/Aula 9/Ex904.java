package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex904 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int notas [];
		
		notas = lerNotas();
		printNotas(notas);
		
	}
	public static int[] lerNotas(){

		int a;
		int b;
		
		out.print("\nQuantas notas deseja contar?");
		a = sc.nextInt();
		
		while(a<=0){
			out.print("Entrada inválida. Insira um número inteiro positivo.");
			a = sc.nextInt();
		}
		
		int []notas = new int [a];
		
		for (int i = 0; i < notas.length; i++) {
			out.print("\nInsira a nota, de 0 a 20: ");
			b = sc.nextInt();
			
			while (b < 0 || b > 20) {
				out.print("Entrada inválida. Insira a nota de 0 a 20: ");
				b = sc.nextInt();
			}
			
			notas[i]=b;
		}
		return notas;
	}
		
	



	public static void printNotas(int notas[]){
		
		out.print("\nHistograma de Notas");
		out.print("\n-------------------------");
		for(int i=20, j=0; j<=20; j++, i--){
			out.printf("\n%02d  |  ", i);
			for(int k=0; k<contarNotas(i, notas); k++){
				out.print("*");
			}
	
		}
	}
	
	public static int contarNotas(int a, int notas[]){
		int n=0;
		
		for(int i=0; i<notas.length; i++){
			if(notas[i]==a) n++;
		}
		
		return n;
	}
	
}