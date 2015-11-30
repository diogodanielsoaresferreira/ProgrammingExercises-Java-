package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex411 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		
	for (int b=8; b>0; b--){	
		for(int i=0; i<8;i++){
			char letra = (char)('a' + i);
			out.print(letra);
			out.print(b + " ");
		}out.println();
	}
}
	
}
