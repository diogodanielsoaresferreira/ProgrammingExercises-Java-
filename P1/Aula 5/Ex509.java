package p1;

import java.util.Scanner;
import static java.lang.System.*;
import p1.Funcoes;

public class Ex509 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int a;
		
		a=Funcoes.getintpos();
		
		out.println("Os números primos são: ");
		
		for (int i=a; i>=1; i--){
			if(isprime(i)==true) out.print(i + " ");
		}
	}

	public static boolean isprime(int n){
		int a = 0;
		
		for(int i=n; i>0; i--){
			if(a%i==0) a += i;
		}
		return ((a==n+1 || a==1) ? true : false);
	}
}
