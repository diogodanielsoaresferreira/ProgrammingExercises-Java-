package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex304 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int secret = (int)(100.0*Math.random()) + 1;
		int a;
		
		do{
		
		out.print("Adivinhe o n�mero inteiro em que estou a pensar: ");
		a = sc.nextInt();
		out.println();
		
		if(a<secret)out.println("� mais alto.");
		if(a>secret)out.println("� mais baixo.");
		
		
	}while(a!=secret);
		
		out.println("Parab�ns! Acertaste no n�mero!");

	}
}
