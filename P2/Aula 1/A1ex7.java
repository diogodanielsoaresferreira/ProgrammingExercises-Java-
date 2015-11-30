/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;

public class A1ex7 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		
		File orig=new File(args[0]);
		File cheg=new File(args[1]);
		
		while(!orig.isFile() || !cheg.canWrite()){
			out.print("\nOs ficheiros não podem ser usados! Escolha outros: ");
			args[0]=sc.nextLine();
			args[1]=sc.nextLine();
			orig=new File(args[0]);
			cheg=new File(args[1]);
		}
		
		Scanner copy=new Scanner(orig);
		PrintWriter paste=new PrintWriter(cheg);
		
		while(copy.hasNextLine()){
			String a=copy.nextLine();
			paste.println(a);
		}
		
		copy.close();
		paste.close();
		out.println("Ficheiro copiado com sucesso!");
	}

}
