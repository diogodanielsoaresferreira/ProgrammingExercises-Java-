/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.io.*;
import static java.lang.System.*;
import java.util.*;

public class p52 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args){
		
		String a;
		
		try{
			File or = new File(args[0]);
			File cop = new File(args[1]);
			
			if(!or.isFile() || !or.canRead()) throw new FileNotFoundException();
			
			if(cop.isFile()){
				do{
					
					out.print("\nEsse ficheiro já existe. Deseja destrui-lo? (s/n): ");
					a=sc.next();
					if(a.equals("n")){
						out.print("\nDê um novo nome ao ficheiro: ");
						String b=sc.next();
						cop = new File(b);
					}
					
				}while(!a.equals("s") && !a.equals("n"));
			}
			
			Scanner fromFile = new Scanner(or);
			PrintWriter toFile = new PrintWriter(cop);
			
			while(fromFile.hasNextLine()){
				toFile.println(fromFile.nextLine());
			}
		}
		catch(FileNotFoundException e){
			err.println("Ficheiros não encontrado ou não pode ser lido.");
			err.println(e.getMessage());
		}
		catch(IndexOutOfBoundsException e){
			err.println("Argumentos passados não correspondem ao pedido.");
			err.println(e.getMessage());
		}
		catch(IOException e){
			err.println("Ficheiros não podem ser lidos ou escritos.");
			err.println(e.getMessage());
		}
		catch(Throwable e){
			err.println("Ficheiros não podem ser lidos ou escritos.");
			err.println(e.getMessage());
		}
		
	}

}
