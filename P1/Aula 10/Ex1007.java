package p1;

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;

public class Ex1007 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		String a;
		
		out.print("Insira o nome do ficheiro de texto: ");
		a = sc.nextLine();
		File part = new File (a);
		File cheg = new File ("chegada.java");
		
		while(!part.isFile() || !part.canRead()){
			out.print("\nDiretório inválido. Insira novamente: ");
			a = sc.nextLine();
			part = new File(a);
		}
		
		Scanner read = new Scanner(part);
		PrintWriter write = new PrintWriter(cheg);
		boolean first=true;
		char c = ' ';

		while(read.hasNext()){
			String s=read.next();
			for (int i=0; i<s.length(); i++){
				if(first){
					first = false;
					write.print(Character.toUpperCase(s.charAt(0)));
					c = s.charAt(0);
				}
				
				else{
					if(c=='.'){
						if(Character.isLetter((s.charAt(i)))){
							c = s.charAt(i);
							write.print(Character.toUpperCase(s.charAt(i)));
						}

					}
							
					else{
						if(Character.isLetter((s.charAt(i)))){
							c = s.charAt(i);
							write.print(Character.toLowerCase(s.charAt(i)));
						}
						else{
							c = s.charAt(i);
							write.print(s.charAt(i));
						}
					}
				}
			}
		}
		
		write.close();
		read.close();
	}

}
