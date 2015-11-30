package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex311 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int a=0;
		boolean imp = true;
		
		do{
			out.print("Insira um valor inteiro: ");
			a = sc.nextInt();
			
			if (a==0) break;
			
			if (a%2==0) imp = false;
			
		}while(a!=0);
		
		if(imp==true){
			out.println("A sequência de números é somente constituída por números ímpares.");
		}
		else{
			out.println("A sequência de números não é somente constituída por números ímpares.");
		}
	}

}
