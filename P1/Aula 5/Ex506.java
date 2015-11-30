package p1;

import p1.Funcoes;
import java.util.Scanner;
import static java.lang.System.*;

public class Ex506 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		int a;
		a = Funcoes.getIntRange(0, 100);

		out.println("-------------------");
		out.println("| Tabuada dos  " + a + "  |");
		out.println("-------------------");
		
		for(int i=1; i<=10; i++){
			out.println("|  " + a + "  X  " + i + " | " + a*i + " |");
			
		}
	}

}
