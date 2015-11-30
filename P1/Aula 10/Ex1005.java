package p1;

import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex1005 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		File ficheiro;
		File ficheirocheg = new File ("chegada.java");
		String a;
		
		out.print("Escreva o nome do seu Ficheiro: ");
		a = sc.nextLine();
		ficheiro = new File(a);
		
		while(!ficheiro.isFile() || !ficheiro.canRead()){
			out.print("\nEscreva novamente o nome do seu ficheiro: ");
			a = sc.nextLine();
			ficheiro = new File(a);
		}
		
		Scanner filereader = new Scanner (ficheiro);
		PrintWriter filewriter = new PrintWriter (ficheirocheg);
		
		while(filereader.hasNext()){
			String s=filereader.next();
			if(s.length()>2){
				if(s.charAt(0)=='/' && s.charAt(1)=='/'){
					if(filereader.hasNextLine()) filereader.nextLine();
				}
				else filewriter.println(s);
			}
			else filewriter.println(s);
		}
		
		filereader.close();
		filewriter.close();
	}

}
