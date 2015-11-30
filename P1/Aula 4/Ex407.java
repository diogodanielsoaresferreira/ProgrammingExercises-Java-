package p1;

import java.util.Scanner;

import static java.lang.System.*;

public class Ex407 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int lar, alt;

		out.print("Introduza a largura: ");		//Variáveis trocadas: alt = largura e lar = altura
		alt = sc.nextInt();
		out.print("Introduza a altura: ");
		lar = sc.nextInt();
		
		for (int j=0; j<lar; j++){
				
			if(j==0 || j==lar-1){
				
                for(int i=0;i<alt;i++)
                {
                    out.print("*");
                }
				
			}
			else{
				
				out.print("*");
				
				for(int i=1;i<alt-1;i++)
                {
                    out.print(" ");
                }
                out.print("*");
				
			}
			out.print("\n");
		}

		
	}

}
