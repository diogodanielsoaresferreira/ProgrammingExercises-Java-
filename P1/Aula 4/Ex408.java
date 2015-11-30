package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex408 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int a, b, i=0;
		
		out.print("Introduza A: ");
		a = sc.nextInt();
		out.print("\nIntroduza B: ");
		b = sc.nextInt();
		
		if (b>a) i=a; a=b; b=i;
		
		for(i=b; (a>=i && i>=b ); i++){
			if(i%2==1){
				
				out.println(i);
				
			}
			
		}

	}

}
