package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex1102 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int []b;
		
		b = lerChave();
		mostraChave(b);

	}
	
	public static int[] lerChave(){
		int []b = new int[6];
		
		for (int i=0; i<6; i++){
			out.print("\nElemento " + (i+1) + " da chave: ");
			b[i] = sc.nextInt();
			while(b[i]<1|| b[i]>49 || pertenceChave(b, i)){
				out.print("\nEntrada inválida! Elemento " + (i+1) + " da chave: ");
				b[i] = sc.nextInt();
			}
		}
		
		return b;
	}
	
	public static boolean pertenceChave(int []b, int i){
		boolean pertence = false;
		
		for(int j=0; j<i; j++){
			if(b[j] == b[i]) pertence=true;
		}
		return pertence;
	}
	
	public static void mostraChave(int []b){
		
		int temp;
		boolean trocas;
		
		do{
			trocas=false;
			for (int i=0;i<b.length-1;i++){
				if(b[i+1]<b[i]){
					temp=b[i];
					b[i]=b[i+1];
					b[i+1]=temp;
					trocas=true;
				}
			}
			
		}while(trocas);
		
		out.print("\nAposta de Totoloto");
		int j=0;
		for(int i=0; i<49; i++){
			if(i==0 || i==7 || i==14 || i==21 || i==28 || i==35 || i==42) out.print("\n");
			if(j<6){
				if(b[j]==(i+1)){
					out.print("X\t");
					j++;
				}
				else out.print((i+1) + "\t");

			}
			else out.print((i+1) + "\t");
		}
	}

}
