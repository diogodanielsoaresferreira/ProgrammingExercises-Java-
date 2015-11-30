package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex402 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int n;
		out.print("Introduza um número inteiro de 0 a 100, exclusive: ");
		n = sc.nextInt();
		
		while(n<=0 || n>=100){
			out.println("O seu número não é válido");
			out.print("Introduza um número inteiro de 0 a 100, exclusive: ");
			n = sc.nextInt();
		}
		
		out.println("-------------------");
		out.println("| Tabuada dos " + n + "  |");
		out.println("|  " + n + " x 1 |  " + n*1 +"  |");
		out.println("|  " + n + " x 2 |  " + n*2 +"  |");
		out.println("|  " + n + " x 3 |  " + n*3 +"  |");
		out.println("|  " + n + " x 4 |  " + n*4 +"  |");
		out.println("|  " + n + " x 5 |  " + n*5 +"  |");
		out.println("|  " + n + " x 6 |  " + n*6 +"  |");
		out.println("|  " + n + " x 7 |  " + n*7 +"  |");
		out.println("|  " + n + " x 8 |  " + n*8 +"  |");
		out.println("|  " + n + " x 9 |  " + n*9 +"  |");
		out.println("|  " + n + " x10 |  " + n*10 +"  |");
		out.println("-------------------");
		

	}

}
