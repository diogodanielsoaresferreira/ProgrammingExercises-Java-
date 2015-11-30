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


public class p112 {

	public static void main(String[] args) {
		
		Scanner readfile = null;
		
		try{
			File text = new File(args[0]);
			readfile  = new Scanner(text);
		}
		catch(ArrayIndexOutOfBoundsException | FileNotFoundException e){
			err.println("USAGE: p112 -ea <file>");
			exit(1);
		}
		
		AssociativeArray<String> words = new AssociativeArray<String>(100);
		
		int i=0;
		while(readfile.hasNext()){
			words.set(readfile.next(), Integer.toString(i));
			i++;
		}
		
		String[] keys = words.keysToArray();
        out.print("words:");
        for(int j = 0; j < keys.length; j++)
           out.print(" \""+keys[j]+"\"");
        out.println();
		
	}

}
