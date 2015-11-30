/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class p53 {

	public static void main(String[] args){

		String dir=null;
		File file;
		
		try{
			dir=args[0];
			file = new File(dir);
			if(!file.canRead()) throw new IOException();
		}catch(ArrayIndexOutOfBoundsException | IOException e){
			dir=".\\";
			file = new File(dir);
		}
		finally{
			out.println("O diretório é "+dir);
		}
		
		
		File afile[] = file.listFiles(); 
		int i = 0; 
		for (int j = afile.length; i < j; i++) { 
			File arquivos = afile[i]; 
			System.out.print(arquivos.getName()+"\t\t\t( ");
			if(!arquivos.isFile()) out.print("Dir ");
			if(arquivos.canWrite()) out.print("Write ");
			if(arquivos.canRead()) out.print("Read ");
			System.out.print(" )\n");
		} 
		
	}

}
