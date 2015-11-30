/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula11;

import java.util.*;
import java.io.*;

public class A11Ex12 {

	public static void main(String[] args) throws IOException {
		String fname="pg21209.txt";
		File f = new File(fname);
		Scanner sc = new Scanner (f);
		Set<String> str= new HashSet<>();
		int i=0;
		while(sc.hasNext()){
			if(!str.add(sc.next()))
				i++;
		}
		System.out.println("Número total de palavras: "+(i+str.size()));
		System.out.println("Número de palavras diferentes: "+str.size());
		
		sc.close();

	}

}
