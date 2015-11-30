package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex903 {
	
	static final Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int a;
		int []b = null;
		
		b=lerSeq();
		do{
			out.print("\nAnálise de uma sequência de números inteiros:");
			out.print("\n1 - Ler a sequência");
			out.print("\n2 - Escrever a sequência");
			out.print("\n3 - Calcular o máximo da sequência");
			out.print("\n4 - Calcular o mínimo da sequência");
			out.print("\n5 - Calcular a média da sequência");
			out.print("\n6 - Detetar se é uma sequência só constituída por números pares");
			out.print("\n10 - Terminar o programa");
			out.print("\nOpção -> ");
			
			a = sc.nextInt();
			
			switch (a){
				case 1:
					b=lerSeq();
					break;
				
				case 2:
					printSeq(b);
					break;
				case 3:
					maxSeq(b);
					break;
				case 4:
					minSeq(b);
					break;

				case 5:
					mediaSeq(b);
					break;
				
				case 6:
					pares(b);
					break;
					
				case 10:
					break;
				default:
					out.println("\nEntrada inválida!");
					break;
			}
		}while(a!=10);
		
	}
		
	public static int[] lerSeq(){
		int[] seq = new int[50];
		int a;
			
		for(int n=0; n<49; n++){
			out.print("\nInsira o número inteiro: "); 
			a = sc.nextInt();
			if(a==0) break;
			seq[n] = a;	
		}
		
		return seq;
	}
	
	public static void printSeq(int[] a){
		
		out.println();
		
		for(int i=0; i<a.length; i++){
			if(a[i]==0) break;
			out.println(a[i]);
		}
		
	}
	
	public static void maxSeq(int[] a){
		
		int max=0;
		
		for(int i=0; i<a.length; i++){
			if(max<a[i]) max = a[i];
			
		}
		
		out.println("\nO valor máximo da sequência é " + max + ".");
		
	}
	
	public static void minSeq(int [] a){
		int min=a[0];
		
		for(int i=0; i<a.length; i++){
			if(a[i]==0) break;
			if(min>a[i]) min = a[i];
			
		}
		
		out.println("\nO valor mínimo da sequência é " + min + ".");
		
	}
	
	public static void mediaSeq(int [] a){
		int soma=0;
		double media=0;
		int j=0;
		
		for(int i=0; i<a.length; i++){
			if(a[i]==0) break;
			j++;
			soma+=a[i];
		}
		
		media = soma/(j-1);
		out.println("\nA média da sequência é " + media + ".");
	}
	
	public static void pares(int [] a){
		boolean par=true;
		
		for(int i=0; i<a.length; i++){
			if(a[i]%2!=0) par=false;
		}
		if(par) out.print("\nTodos os números introduzidos são pares");
		else out.print("\nNem todos os números introduzidos são pares.");
		
	}
		

}
