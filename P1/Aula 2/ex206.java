package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class ex206 {

	static Scanner sc = new Scanner (System.in);
	
	
	public static void main(String[] args) {

		int a;
		
		out.print("Insira um numero: ");
		a = sc.nextInt();
		
		if((a%2)==0){
			
			out.print("O número é par.");
			
		}
		else out.print("O número é ímpar.");

	}

}
