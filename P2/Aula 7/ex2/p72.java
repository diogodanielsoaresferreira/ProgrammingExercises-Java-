/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;
import static java.lang.System.*;
import java.util.Scanner;

public class p72 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		out.print("A: ");
		int a = sc.nextInt();
		out.print("\nB: ");
		int b = sc.nextInt();
		out.println(mdc(a,b));
	}
	
	public static int mdc(int a, int b){
		
		if(b==0) return a;
		else{
			return mdc(b, a%b);
		}
		
	}

}
