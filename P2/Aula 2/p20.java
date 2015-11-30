package p2;

/*************************************************************************
 * Compilation: javac j21.java 
 * Execution: java j21
 *************************************************************************/

import java.util.Scanner;


public class p20 {
	final static Scanner sc = new Scanner (System.in);
	
	// Exemplo simples de utilização da class Complex
	public static void main(String[] args) {
		//Complexo2 a = new Complexo2(5.0, 6.0);

		int real, im;
		
		if (args.length<2){
			System.out.print("Re: ");
			real = sc.nextInt();
			System.out.print("\nIm: ");
			im = sc.nextInt();
		}
		else{
			real = Integer.parseInt(args[0]);
			im = Integer.parseInt(args[1]);
		}
		
		// Vamos usar métodos de 'a'
		System.out.println("(" + real + " + " + im + "i)");
		System.out.println("  parte real = " + real);
		System.out.println("  parte imaginaria = " + im);
		System.out.println("  modulo = " + Math.sqrt(real * real + im * im));
		System.out.printf("  fase   =  %2.2f\n", Math.atan2(im, real));
	}

}
