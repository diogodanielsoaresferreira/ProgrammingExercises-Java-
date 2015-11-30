package p1;

import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex1008 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		String a, b;
		File part, cheg;
		
		out.print("Escreva o nome do seu ficheiro de partida: ");
		a = sc.nextLine();
		part = new File(a);
		
		while(!part.isFile() || !part.canRead()){
			out.print("\nFicheiro inválido! Escreva outra vez: ");
			a = sc.nextLine();
			part = new File(a);
		}
		
		out.print("Escreva agora o nome do seu ficheiro de chegada: ");
		b = sc.nextLine();
		cheg = new File(b);
		
		Scanner ler = new Scanner (part);
		PrintWriter escrever = new PrintWriter (cheg);
		
		while(ler.hasNext()){
			String s=ler.next();
			for(int i=0; i<s.length();i++){
				if(s.charAt(i)=='l'){
					escrever.print("u");
				}
				else if(s.charAt(i)=='L'){
					escrever.print("U");
				}
				else if(s.charAt(i)=='r'){
				}
				else if(s.charAt(i)=='R'){
				}
				else{
					escrever.print(s.charAt(i));
				}
			}

		}
		
		ler.close();
		escrever.close();
	}

}
