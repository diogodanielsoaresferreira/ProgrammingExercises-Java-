package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex401 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int i, a;
		
		out.print("Quantas vezes imprimos a mensagem?");
		a = sc.nextInt();
		
		for (i=1; i<=a; i++){
			
			out.println("P1 é fixe!");
			
		}
	}

}
