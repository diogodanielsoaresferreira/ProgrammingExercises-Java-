package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex808 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int b, c;
		String a; 
		boolean check = false;
		
		out.print("Insira um n�mero que n�o esteja em base decimal: ");
		a = sc.next();
		
		out.print("\nAgora insira a base em que o n�mero se encontra (entre 2 e 10): ");
		b = sc.nextInt();
		
		for (int i=0;i<a.length();i++){
			if(Character.getNumericValue(a.charAt(i))>=b) check = true;
		}
		
		while(b<2 || b>10 || check){
			out.print("\nEntrada inv�lida.");
			out.print("\nInsira um n�mero que n�o esteja em base decimal: ");
			a = sc.next();
			
			out.print("\nAgora insira a base em que o n�mero se encontra (entre 2 e 10): ");
			b = sc.nextInt();
			
			for (int i=0;i<a.length();i++){
				if(Character.getNumericValue(a.charAt(i))>=b) check = true;
				else check = false;
			}
			
		}
		c = basetoNum(a,b);
		out.print("\nO seu n�mero em base decimal � " + c + ".");
		
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
