package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex606 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		Temp a1, a2, a3, a4, a5;
		a1 = new Temp();
		a2 = new Temp();
		a3 = new Temp();
		a4 = new Temp();
		a5 = new Temp();
		
		a1=instemp();
		a2=instemp();
		a3=instemp();
		a4=instemp();
		a5=instemp();
		
		System.out.print("\nDia 1: \nM�xima: " + a1.max + "\nM�nima: " + a1.min + "\nAmplitude: " + a1.amp);
		System.out.print("\nDia 2: \nM�xima: " + a2.max + "\nM�nima: " + a2.min + "\nAmplitude: " + a2.amp);
		System.out.print("\nDia 3: \nM�xima: " + a3.max + "\nM�nima: " + a3.min + "\nAmplitude: " + a3.amp);
		System.out.print("\nDia 4: \nM�xima: " + a4.max + "\nM�nima: " + a4.min + "\nAmplitude: " + a4.amp);
		System.out.print("\nDia 1: \nM�xima: " + a5.max + "\nM�nima: " + a5.min + "\nAmplitude: " + a5.amp);

	}
	
	public static Temp instemp(){

		Temp a = new Temp();
		
		out.print("Insira a temperatura m�xima: ");
		a.max=sc.nextDouble();
		out.print("\nInsira a temperatura m�nima: ");
		a.min=sc.nextDouble();
		
		while(a.min>a.max || a.min<=-20 || a.max>=50){
			out.print("\nValores inv�lidos.");
			out.print("\nInsira a temperatura m�xima: ");
			a.max=sc.nextDouble();
			out.print("\nInsira a temperatura m�nima: ");
			a.min=sc.nextDouble();
		}
		
		a.amp = a.max-a.min;
		
		return a;
	}
	
	public static class Temp{
		double max;
		double min;
		double amp;
	}
}
