/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */

import static java.lang.System.*;
import java.io.*;

public class p67 {

	public static void main(String[] args) {
		
		try{
			listDirs(args[0], args[1]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			out.println("Argumento inv�lido.");
		}
		
	}
	
	public static void listDirs(String args, String text){
		File file = null;
		
		try{
			file = new File(args);
			if (!file.exists()) throw new FileNotFoundException();
		}
		catch(FileNotFoundException e){
			out.println("O ficheiro n�o existe.");
			exit(1);
		}
		
		File [] files = file.listFiles();
		
		for(int i=0;i<files.length;i++){
			if(files[i].getName().indexOf(text)!=-1)
				out.println(files[i].getPath());
			if(!files[i].isFile())
				listDirs(files[i].getPath(), text);
		}
	}


}
