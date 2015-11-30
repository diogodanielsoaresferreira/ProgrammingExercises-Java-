package p1;

import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex1006 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) throws IOException {
		File partida = new File (args[0]);
		File chegada = new File (args[1]);
		
		if(!partida.canRead() || !partida.isFile()){
			out.println("O ficheiro não pode ser lido. Escreva outra vez: ");
			args[0] = sc.nextLine();
			partida = new File (args[0]);
		}
		
		Scanner copiar = new Scanner (partida);
		PrintWriter colar = new PrintWriter (chegada);
		
		while(copiar.hasNextLine()){
			colar.println(copiar.next());
		}
		
		copiar.close();
		colar.close();
	}

}
