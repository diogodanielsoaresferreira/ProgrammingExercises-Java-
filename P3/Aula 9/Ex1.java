/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula9;

import java.io.*;

public class Ex1 {
	
	public static void main(String[] args) throws IOException{
		ScannerAbeirense sc = new ScannerAbeirense(System.in);
		
		System.out.println(sc.nextLine());
		System.out.println(sc.next());
		
		sc.close();
		
		File f = new File("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 8\\betterquestions.txt");
		ScannerAbeirense sc2 = new ScannerAbeirense(f);
		
		while(sc2.hasNextLine()){
			System.out.println(sc2.nextLine());
		}
		
		sc2.close();
	}
}
