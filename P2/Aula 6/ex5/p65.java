/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

import java.io.*;

public class p65 {

	public static void main(String[] args) {

		try{
			listDirs(args[0]);
		}
		catch(IndexOutOfBoundsException e){
			err.println("Erro fatal.");
		}
	}
	
	
	public static void listDirs(String args){
		File file = null;
		
		try{
			file = new File(args);
			if (!file.exists()) throw new FileNotFoundException();
		}
		catch(FileNotFoundException e){
			out.println("O ficheiro não existe.");
			exit(1);
		}
		
		File [] files = file.listFiles();
		
		for(int i=0;i<files.length;i++){
			out.println(files[i].getPath());
			if(!files[i].isFile())
				listDirs(files[i].getPath());
		}
	}

}
