package p1;
import java.util.Scanner;
import static java.lang.System.*;

public class Ex801 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		String fras1;
		int i, mai=0, min=0, num=0, vog=0, cons=0;
		
		out.print("Escreva uma frase: ");
		fras1 = sc.nextLine();
		
		i=fras1.length();
		
		for (int j=0; j<i;j++){
			if(Character.isUpperCase(fras1.charAt(j))) mai++;
			if(Character.isLowerCase(fras1.charAt(j))) min++;
			if(Character.isDigit(fras1.charAt(j))) num++;
			if(isVowel(fras1.charAt(j)))vog++;
			
		}
		
		cons = (mai+min)-vog;
		
		out.println("\nAnálise de uma frase");
		out.println("Frase de entrada: " + fras1);
		out.println("\nNúmero de caracteres minúsculos -> " + min);
		out.println("Número de caracteres maiúsculos -> " + mai);
		out.println("Número de dígitos -> " + num);
		out.println("Número de vogais -> " + vog);
		out.println("Número de consoantes -> " + cons);
	}
	
	public static boolean isVowel(char c){
		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') return true;
		else return false;
		
	}

}
