package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex809 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		String car;
		
		out.print("Introduza um car�cter: ");
		car = sc.nextLine();
		readChar(car);

	}
	
	public static char readChar(String car){

		char car2;
		
		while(car.isEmpty() || car.length()>1){
			out.print("\nValor inv�lido. Insira outra vez o car�cter: ");
			car = sc.nextLine();
		}
		car2=car.charAt(0);
		
	return car2;
	}

}
