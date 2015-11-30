package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex211 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		
		double a, b, c, delta, res1, res2=0;
		
		out.print("Insira os valores de a, b e c.\n\ta:");
		a = sc.nextDouble();
		
		if (a!=0){
			out.println("O valor de a é impossível. Insira outro a: ");
			a = sc.nextDouble();
		}
		
		out.print("\n\tb:");
		b = sc.nextDouble();
		out.print("\n\tc:");
		c = sc.nextDouble();
		
		delta = (Math.pow(b, 2))-(4*a*c);
		
		if (delta==0){
			
			res1=((-b)/(2*a));
			out.println("A única solução é " + res1 + ".");
		}
		else if (delta<0){
			out.println("É impossível calcular a equação em IR.");
			
		}
		else{
			res1=(((-b)+delta)/(2*a));
			res2=(((-b)-delta)/(2*a));
			out.println("As soluções são " + res1 + " e " + res2 + ".");
		}
	}

}
