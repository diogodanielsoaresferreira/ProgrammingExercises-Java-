package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex803 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		String a;
		int b=0;
		
		out.print("Insira uma frase: ");
		a = sc.nextLine();
		b=countWords(a);
		out.print("A frase tem " + b + " palavras.");
		
		
	}

	public static int countWords(String a){
		
		int j=0;

		for(int i=1; i<a.length(); i++){
			if(Character.isWhitespace(a.charAt(i)) && Character.isWhitespace(a.charAt(i-1))==false){
				j++;
			}
		}
		if(Character.isWhitespace(a.charAt(a.length()-1))==false){
			j++;
		}
		
		return j;
	}
	
}