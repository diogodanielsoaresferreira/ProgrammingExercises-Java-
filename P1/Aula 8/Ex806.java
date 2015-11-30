package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex806 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		String a, b;
		
		out.print("Insira uma frase em Português: ");
		a = sc.nextLine();
		b = conv(a);
		out.print("\nNo dialeto do Alberto, a frase dita foi: " + b + ".");

	}
	
	public static String conv(String b){

				b=b.replace('l', 'u');
				b=b.replace('L', 'U');
				b=b.replace('R', ' ');
				b=b.replace('r', ' ');
		
		return b;
	}

}
