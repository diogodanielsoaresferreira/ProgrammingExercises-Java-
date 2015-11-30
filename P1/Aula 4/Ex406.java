package p1;

import java.util.Scanner;
import  static java.lang.System.*;

public class Ex406 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		int lar, alt;

		out.print("Introduza a altura: ");
		alt = sc.nextInt();
		out.print("Introduza a largura: ");
		lar = sc.nextInt();
		
		for(int i=0; i<alt; i++){
			for (int j=0; j<lar; j++){
				out.print("*");
			}
			out.print("\n");
		}
	}

}
