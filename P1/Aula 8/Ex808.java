package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex808 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int b, c;
		String a; 
		boolean check = false;
		
		out.print("Insira um número que não esteja em base decimal: ");
		a = sc.next();
		
		out.print("\nAgora insira a base em que o número se encontra (entre 2 e 10): ");
		b = sc.nextInt();
		
		for (int i=0;i<a.length();i++){
			if(Character.getNumericValue(a.charAt(i))>=b) check = true;
		}
		
		while(b<2 || b>10 || check){
			out.print("\nEntrada inválida.");
			out.print("\nInsira um número que não esteja em base decimal: ");
			a = sc.next();
			
			out.print("\nAgora insira a base em que o número se encontra (entre 2 e 10): ");
			b = sc.nextInt();
			
			for (int i=0;i<a.length();i++){
				if(Character.getNumericValue(a.charAt(i))>=b) check = true;
				else check = false;
			}
			
		}
		c = basetoNum(a,b);
		out.print("\nO seu número em base decimal é " + c + ".");
		
	}

	public static int basetoNum (String a, int b){
		int c=0;
		int i=0;
		
		for(int j=a.length()-1; j>=0; j--){
			c += ((Character.getNumericValue(a.charAt(j)))*(Math.pow(b, i)));
			i++;
		}
		
		return c;
	}
	
}
