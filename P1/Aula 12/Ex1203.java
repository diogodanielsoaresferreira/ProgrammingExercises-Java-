/**
 * Diogo Daniel Soares Ferreira, 2014
 */
package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex1203 {
	
	static final Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		int i=0;
		int l=0;
		String m;
		String frases[] = new String [10];
		
		do{
			out.print("Insira a frase desejada: ");
			m=sc.nextLine();
			if (m.equals("fim")) break;
			frases[i]=m;
			i++;
		}while(i!=9 || m!="fim");
		
		for(int z=0; z<frases.length; z++){
			if(frases[z]!=null) l++;
		}
		
		for(int j=0; j<l; j++){
			String a=frases[j];
			for(int k=a.length()-1; k>=0; k--){
				out.print(a.charAt(k));
			}
			out.print("\n");
		}
		
	}

}
