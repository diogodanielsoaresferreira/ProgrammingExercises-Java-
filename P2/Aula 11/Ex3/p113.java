/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class p113 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		Scanner num = null;
		
		p113AssociativeArray<Integer> array = new p113AssociativeArray<Integer>();
		
		try{
			File numbers = new File(args[0]);
			num = new Scanner(numbers);
		}
		catch(IOException | ArrayIndexOutOfBoundsException e){
			err.println("Erro nos parâmetros de entrada.");
			exit(1);
		}
		try{
			while(num.hasNext()){
				int key = Integer.parseInt(num.next());
				num.next();
				String number = num.next();
				array.set(number, key);
			}
		}
		catch(InputMismatchException e){
			err.println("Erro no ficheiro lido.");
			exit(1);
		}
		
		
		out.print("\nLista de nomes de números (insira nomes na linha. Para acabar pressione enter): ");
		String a = sc.nextLine();
		
		String []palavras = a.split(" ");
		
		for(int i=0;i<palavras.length;i++){
			if(array.exists(palavras[i])){
				System.out.print(array.get(palavras[i])+" ");
			}
			else{
				out.print("indefinido");
			}
		}
	}
	
}
