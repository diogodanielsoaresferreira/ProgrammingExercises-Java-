package p1;

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

public class Ex1001 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		String fichname;
		File fiche;
		
		do{
			out.print("\nInsira o nome de um ficheiro válido com a sua extensão: ");
			fichname = sc.nextLine();
			fiche = new File (fichname);
		}while(!fiche.isFile() || !fiche.canRead());
		
		Scanner lerfich = new Scanner (fiche);
		
		while(lerfich.hasNext()){
			out.println(lerfich.next());
		}
		
		lerfich.close();
	}

}
