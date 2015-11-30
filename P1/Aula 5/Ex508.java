package p1;
import p1.Funcoes;
import java.util.Scanner;
import static java.lang.System.*;

public class Ex508 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		double a, b, c, e;
		
		do{
			out.print("Insira o valor inicial de X: ");
			a = sc.nextDouble();
			out.print("Insira o valor final de X: ");
			b = sc.nextDouble();
			if (a>b) out.println("O valor final deve ser superior ao inicial");
		}while(a>b);
		out.print("A sequência irá ter quantos elementos? ");
		c = sc.nextDouble();
		
		e = (b-a)/c;
		
		out.println("---------------------------------------");
		out.println("|   x    |  5x2+10x+3 |  7x3+3x2+5x+2 |");
		out.println("---------------------------------------");
		
		for(double x=a;x<b;x+=e){
			out.printf("|%8f|%12f|%15f|", x, ((Math.pow(x, 2)*5) + (10*x) + 3), Funcoes.poly4(x, x, x, 2));
			out.println("\n---------------------------------------");
		}
	}

}
