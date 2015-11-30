package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex301 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int a, i=0;
		
		do{
		
		out.print("Insira o seu numero inteiro: ");
		a = sc.nextInt();
		i++;

		}while(a>=0);
		
		out.print("Inseriu " +i+" numeros não negativos.");
	}

}
