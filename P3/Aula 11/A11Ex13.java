/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula11;

import java.io.*;
import java.util.*;

public class A11Ex13 {

	public static void main(String[] args) throws IOException {
		String fname="pg21209.txt";
		File f = new File(fname);
		Scanner sc = new Scanner (f);
		Map<String, Integer> str= new HashMap<>();

		while(sc.hasNext()){
			String line = sc.next();
			if(str.containsKey(line))
				str.put(line, str.get(line)+1);
			else
				str.put(line, 1);
		}
		
		Set<String> a = str.keySet();
		Iterator<String> keyIt=a.iterator();
		
		while(keyIt.hasNext()){
			String k=keyIt.next();
			System.out.println(k+": "+str.get(k));
		}
		
		sc.close();
	}

}
