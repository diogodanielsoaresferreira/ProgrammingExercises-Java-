package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex906 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		String a;
		
		out.print("Insira uma frase: ");
		a = sc.nextLine();
		checkLetter(a);
		
	}
	
	public static void checkLetter(String a){
		char []check = new char[a.length()];
		int k=0;
		boolean c = false;
		
		for(int i=0; i<a.length(); i++){
			
			if(Character.isWhitespace(a.charAt(i))) i++;
			
			for(int j=0; j<a.length(); j++){
				if(a.charAt(i)==check[j])c = true;
			}
			
			if(c==false){
				check[k]=a.charAt(i);
				k++;
			}
			c=false;
		}
		for(int z=0; z<check.length; z++){
			out.print(check[z]);
		}
	}
}
