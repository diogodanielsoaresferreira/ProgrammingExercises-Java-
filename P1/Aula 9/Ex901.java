package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex901 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int n;
		int b = 1;
		
		out.print("Quantos n�meros vai inserir?");
		n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=n; i>0; i--){
			out.print("\nInsira  o n�mero " + b + ": ");
			a[i-1] = sc.nextInt();
			b++;
		}
		
		out.print("\nVoc� escreveu: ");
		for(int c=0; c<n ; c++){
			out.print(a[c]);
		}

	}

}