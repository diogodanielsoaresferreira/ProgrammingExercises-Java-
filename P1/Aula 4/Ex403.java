package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex403 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int m, i=1, j=1;
		
		out.print("Escreva um valor entre 1 e 10: ");
		m = sc.nextInt();
		
		while (m<1 || m>10){
			
			out.print("O número não está entre a gama pedida. Escolha outra vez: ");
			m = sc.nextInt();
			
		}
		
		for(i=1; i<=m; i++){
			out.println(i + "! = " + i*j);
			j=j*i;
			
		}
			
	}

}
