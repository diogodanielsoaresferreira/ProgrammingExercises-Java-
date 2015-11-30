package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex805 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int a, b;
		String c;
		
		out.print("Insira um número inteiro: ");
		a = sc.nextInt();
		out.print("\nDeseja que seja convertido para que base (entre 2 e 10)? ");
		b = sc.nextInt();
		
		while (b<2 || b>10){
			out.print("\nEntrada inválida. Insira a sua base entre 2 e 10: ");
			b = sc.nextInt();
		}
		
		c = numToBase(a, b);
		out.println("\nO seu número " + a +" em base " + b + " é " + c + ".");
		
	}

	public static String numToBase(int a, int b){
		String d="";
		String e="";
		
		while(a>=b){
			d += a%b;
			a=a/b;
		}
		d+=b-a;
		
		for(int j=d.length()-1;j>=0; j--){
			e += d.charAt(j);
		}
		
		
		return e;
	}
	
}
