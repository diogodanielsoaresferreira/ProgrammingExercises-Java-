package p1;

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

public class Ex1104 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException{

		
		int n=lerNum();
		String a[]=new String[n];
		int b[]=new int[n];
		int d, k=-1;
		String g=null;
		
		lerNom(a,b, n);
		do{
			out.print("Insira o número que deseja pesquisar: ");
			d=sc.nextInt();
			
			for(int j=0; j<b.length; j++){
				if(b[j]==d){
					k=j;
					g=a[j];
					break;
				}
			}
			
			
			out.println((k>0?"O seu número corresponde ao aluno: " + g + ".":"Número não encontrado."));
		}while(d!=0);
	}

	public static void lerNom(String a[], int b[], int n) throws IOException{
		File alunos = new File ("alunos.txt");
		n=0;

		Scanner lerAl2 = new Scanner (alunos);
		while(lerAl2.hasNextLine()){
			b[n]=lerAl2.nextInt();
			a[n]=lerAl2.nextLine();
			n++;
		}
		
		
		lerAl2.close();
	}
	
	public static int lerNum() throws IOException{
		int n=0;
		File alunos = new File ("alunos.txt");
		
		Scanner lerAl = new Scanner (alunos);
		
		while(lerAl.hasNext()){
			lerAl.next();
			n++;
		}
		lerAl.close();

		return n;
	}
	
}
