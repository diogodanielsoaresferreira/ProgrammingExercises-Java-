package p1;

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Ex1004 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		String notas [] = new String[20];
		String a;
		
		for(int z=0; z<20; z++){									//Cria Matriz de 20 espaços com 0
			notas[z]="";
		}
		
		out.print("Insira o nome do ficheiro: ");					//Inicializa o ficheiro externo de texto
		a = sc.nextLine();
		File ficheiro = new File(a);
		
		while(!ficheiro.isFile() || !ficheiro.canRead()){
			out.print("Ficheiro inválido! Insira um nome válido: ");
			a = sc.nextLine();
			ficheiro = new File(a);
		}
		
		Scanner lerfich = new Scanner (ficheiro);
																	//Inicializa Scanner de leitura do ficheiro
		for (int i=0; i<20; i++){
			lerfich = new Scanner (ficheiro);
			
			while(lerfich.hasNextInt()){
				if(lerfich.nextInt()==(i+1)){
					notas[i] += "*";
				}
			}
		}
		lerfich.close();
		
		printNotas(notas);

		
	}

	public static void printNotas(String notas[]){
		
		out.print("\nHistograma de Notas");
		out.print("\n-------------------------");
		for(int j=1; j<=20; j++){
			out.print("\n" + (j) + "|\t" + notas[j-1]);
		}
	}
}