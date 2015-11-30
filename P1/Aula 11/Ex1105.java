package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex1105 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		boolean []b = new boolean[50];
		
		lerChave(b);
		mostraChave(b);

	}

	public static void lerChave(boolean []b){
		int k=1;
		int a;
		
		for (int j=0; j<50;j++) b[j]=false;
		
		do{
			out.print("\nInsira a sua aposta " + k + ": ");
			a=sc.nextInt();
			
			while(a<=0 || a>50 || pertenceChave(b,a)){
				out.print("\nA sua aposta é inválida! Insira outra vez a aposta " + k + ": ");
				a=sc.nextInt();
			}
			b[a-1]=true;
			k++;
		}while(k<7);

		
	}
	
	public static boolean pertenceChave(boolean []b, int a){
		boolean pertence=false;
		
		if((a-1)<0||(a>b.length)) return true;
		else if(b[a-1]) return true;
		else return pertence;
	}
	
	public static void mostraChave(boolean []b){
		out.println();
		for(int i=0; i<50; i++){
			out.printf("|%2d", i);
		}
		out.print("|");

		out.println();
		for(int i=0; i<50; i++){
			out.print("---");
		}
		
		out.println();
		for(int i=0; i<50; i++){
			if(b[i])out.print("|T ");
			else out.print("|  ");
		}
		out.print("|");
		
	}
	
}
