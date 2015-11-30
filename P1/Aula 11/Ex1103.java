package p1;

import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;

public class Ex1103 {
	
	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		
		int a;
		double b[] = null;
		
		do{
			out.print("\nAnalisador de pH");
			out.print("\n1 - Ler valores de pH de um ficheiro");
			out.print("\n2 - Escrever valores de pH no terminal");
			out.print("\n3 - Calcular o pH médio das amostras");
			out.print("\n4 - Calcular o número de amostras ácidas e básicas");
			out.print("\n5 - Calcular o número de amostras de pH superior à média");
			out.print("\n6 - Escrever valores de pH no terminal ordenados de modo crescente");
			out.print("\n7 - Terminar programa");
			out.print("\nOpção -> ");
			sc.nextLine();
			a=sc.nextInt();
			
			while(a<1 || a>7){
				out.print("\nEntrada inválida! Insira outra vez -> ");
				a=sc.nextInt();
			}
		
		switch(a){
			
			case 1:
				b=lerFich(b);
				break;
			case 2:
				print(b);
				break;
			case 3:
				phmed(b);
				break;
			case 4:
				acorbas(b);
				break;
			case 5:
				supmed(b);
				break;
			case 6:
				cresc(b);
				break;
			default:
				out.print("\nOpção Inválida!");
				break;
		}
		
		}while(a!=7);
	}
	
	public static double[] lerFich(double []b) throws IOException{
		String filename;
		int i=0;
		
		out.print("Insira o nome do ficheiro de texto que deseja ler: ");
		while(!sc.hasNext());
		filename=sc.next();
		
		File ph = new File (filename);
		Scanner lerfich = new Scanner (ph);
		
		while(lerfich.hasNext()){
			double z=lerfich.nextDouble();
			if(z>=0 && z<=14) i++;
		}
		lerfich.close();

		b = new double[i];
		
		int x=0;
		
		Scanner lerfich2 = new Scanner (ph);
		while(lerfich2.hasNext()){
			double z=lerfich2.nextDouble();
			if(z>=0 && z<=14){  
				b[x]=z;
				x++;
			}

		}
		
		for (int j=0;j<b.length; j++){
			out.println(b[j]);
		}
		
		lerfich2.close();
		
		return b;
	}

	public static void print(double []b){
		out.print("\nOs valores do pH são: ");
		for (int i=0;i<b.length; i++){
			out.println(b[i]);
		}
	}

	public static void phmed(double []b){
		int soma=0;
		
		for(int i=0; i<b.length; i++){
			soma+=b[i];
		}
		
		 out.print("\nO valor médio é " + (soma/b.length) + ".");
	}

	public static double phmed(double []b, int n){
		int soma=0;
		
		for(int i=0; i<b.length; i++){
			soma+=b[i];
		}
		 out.print("\nO valor médio é " + (soma/b.length) + ".");
		 
		 return (soma/b.length);
	}
	
	public static void acorbas(double []b){
		int bas=0, ac=0;
		
		for(int i=0;i<b.length;i++){
			if(b[i]<7)ac++;
			else if(b[i]>7)bas++;
		}
		
		out.print("Os dados introduzidos têm " + ac + " valores com pH ácido e " + bas + " valores com pH básico.");
	}

	public static void supmed(double []b){
		int sup=0;
		
		for(int i=0; i<b.length; i++){
			if(b[i]>phmed(b,1))sup++;
		}
		
		out.print("\nExistem " + sup + " amostras com pH superior à média.");
	}

	public static void cresc(double []b){
		boolean troca=true;
		
		do{
			troca=false;
			for(int i=0; i<b.length-1;i++){
				if(b[i+1]<b[i]){
					double temp=b[i];
					b[i]=b[i+1];
					b[i+1]=temp;
					troca=true;
				}
				
			}
		}while(troca);
	}
}