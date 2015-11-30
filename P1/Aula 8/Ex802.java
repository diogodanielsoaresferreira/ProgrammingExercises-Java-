package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex802 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		String a;
		
		out.print("Insira uma frase que contenha um acrónimo: ");
		a=sc.nextLine();
		out.println("\n" + acronimo(a));
		

	}

	public static String acronimo(String a){
		int i=0;
		i=a.length();
		String b="";
		
		for (int j=0; j<i; j++){
			if(Character.isUpperCase(a.charAt(j))){
				b+=a.charAt(j);
			}
		}
		
		return b;
	}
}
