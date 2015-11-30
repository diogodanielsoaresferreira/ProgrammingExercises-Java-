package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex308 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int a=0, c=0, i=-1;
		double med=0;
		
		do{
			c+=a;
			i++;
			
			out.print("Insira as suas notas: ");
			a = sc.nextInt();
			
		}while(a!=0);

		if (i!=0){
			med=c/i;
		}
		
		out.println("A soma é " + c + " e a média é " + med + ".");
	}

}
