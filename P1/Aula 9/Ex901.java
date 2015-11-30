package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex901 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int n;
		int b = 1;
		
		out.print("Quantos números vai inserir?");
		n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=n; i>0; i--){
			out.print("\nInsira  o número " + b + ": ");
			a[i-1] = sc.nextInt();
			b++;
		}
		
		out.print("\nVocê escreveu: ");
		for(int c=0; c<n ; c++){
			out.print(a[c]);
		}

	}

}