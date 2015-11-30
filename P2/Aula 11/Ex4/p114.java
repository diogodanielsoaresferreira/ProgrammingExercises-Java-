/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class p114 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		p113AssociativeArray<String> array = new p113AssociativeArray<String>();
		
		Scanner num = null;
		
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
				String key = num.next();
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
		int res = 0, num1=0, num2=0;
		try{
			for(int i=1;i<palavras.length;i++){
				if(i==1){
					num1 = Integer.parseInt(array.get(palavras[i-1]));
					num2 = Integer.parseInt(array.get(palavras[i]));
					
				}
				else{
					num1 = res;
					num2 = Integer.parseInt(array.get(palavras[i]));
					
				}
				
				if(num1<num2){
					res = num1 * num2;
				}else{
					res = num1 + num2;
				}
				
			}
			System.out.println(res);
		}
		catch(Throwable e){
			err.print("Erro nos parâmetros de entrada.");
			exit(1);
		}
		
		
		
	}
}
