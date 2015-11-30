/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class p61 {

	static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		int a=0;
		out.print("\nDeseja ver a sequência de fibonacci até que número? ");
		try{
			a = sc.nextInt();
			if (a<0) throw new NumberFormatException();
		}catch(NumberFormatException e){
			err.println("\nNúmero inválido!");
			main(args);
		}
		
		for(int i=a;i>0;i--){
			out.print(fibonacci(i)+", ");
		}
		out.print(fibonacci(0)+".");
		
	}
	
	public static int fibonacci(int n){
		
		assert n>=0;
		
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		
		return fibonacci(n-2)+fibonacci(n-1);
	}

}
