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
		
		System.out.print("\nDia 1: \nMáxima: " + a1.max + "\nMínima: " + a1.min + "\nAmplitude: " + a1.amp);
		System.out.print("\nDia 2: \nMáxima: " + a2.max + "\nMínima: " + a2.min + "\nAmplitude: " + a2.amp);
		System.out.print("\nDia 3: \nMáxima: " + a3.max + "\nMínima: " + a3.min + "\nAmplitude: " + a3.amp);
		System.out.print("\nDia 4: \nMáxima: " + a4.max + "\nMínima: " + a4.min + "\nAmplitude: " + a4.amp);
		System.out.print("\nDia 1: \nMáxima: " + a5.max + "\nMínima: " + a5.min + "\nAmplitude: " + a5.amp);

	}
	
	public static Temp instemp(){

		Temp a = new Temp();
		
		out.print("Insira a temperatura máxima: ");
		a.max=sc.nextDouble();
		out.print("\nInsira a temperatura mínima: ");
		a.min=sc.nextDouble();
		
		while(a.min>a.max || a.min<=-20 || a.max>=50){
			out.print("\nValores inválidos.");
			out.print("\nInsira a temperatura máxima: ");
			a.max=sc.nextDouble();
			out.print("\nInsira a temperatura mínima: ");
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
