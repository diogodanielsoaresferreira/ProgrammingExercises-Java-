package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex309 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		double a=0;
		int pos=0, neg=0, cem=0, mcem=0;
		
		do{
			out.print("Escreva um número: ");
			a = sc.nextDouble();
			
			if(a==0) break;
			if(a>0) pos++;
			if(a<0) neg++;
			if(a>=100 && a<=1000) cem++;
			if(a>=-1000 && a<=-100)mcem++;
			
		}while(a!=0);

		out.println("Inseriu " + pos + " números positivos, " + neg + "números negativos, "
				+ cem + " números entre 100 e 1000 e " + mcem + " números entre -1000 e -100");
	}

}
