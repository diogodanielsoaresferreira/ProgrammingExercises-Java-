package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex405 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int a, b, e = 0;
		double c;
		
		for(a=1;a<100;a++){
			for(b=1; b<100; b++){
				if(a<b){

					c = Math.sqrt(Math.pow(a, 2) + Math.pow(b,2));
					if (c>=100)break;
					if(c%1==0){
						e = (int)c;
						out.println(a + " " + b + " " + e);
						
					}
					
				}
				
			}
		}
	}

}
