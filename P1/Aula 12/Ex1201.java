/**
 * Diogo Daniel Soares Ferreira, 2014
 */
package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex1201 {

	static final Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		int lin1, col1, lin2, col2;
		int [][]a, b, m;
		
		do{
			out.println("Primeira matriz: ");
			out.println("Nº de Linhas: ");
			lin1=lerInt();
			out.println("Nº de Colunas: ");
			col1=lerInt();
			out.println("Segunda matriz: ");
			out.println("Nº de Linhas: ");
			lin2=lerInt();
			out.println("Nº de Colunas: ");
			col2=lerInt();
			
			if(col1!=lin2){
				out.println("Matrizes não podem ser multiplicáveis! Insira outra vez:");
			}
		}while(col1!=lin2);
		
		a=new int[lin1][col1];
		b=new int[lin2][col2];
		
		out.println("Matriz 1:");
		valMat(a,lin1,col1);
		valMat(b,lin2,col2);
		
		m=multMat(a,b,lin1,col1,lin2,col2);
		
		out.println("A matriz multiplicada é: ");
		printMat(m,lin1,col2);
		
	}
	
	public static int lerInt(){
		int n;
		
		n=sc.nextInt();
		
		while(n<0){
			out.println("Número inválido. Insira outra vez: ");
			n=sc.nextInt();
		}
		
		return n;
	}

	public static void valMat(int [][]a,int l, int c){
		
		for(int i=0; i<l;i++){
			for(int j=0; j<c; j++){
				out.println("Insira o valor que deseja na linha " + (i+1) + " e coluna " + (j+1) + ": ");
				a[i][j]=sc.nextInt();
			}
		}

	}

	public static int[][] multMat(int [][]a, int [][]b, int l1, int c1, int l2, int c2){
		int [][]m = new int [l1][c2];
		int z=0;
		
		for(int i=0; i<l1;i++){
			for(int j=0; j<c2; j++) {
				for(int k=0;k<l2;k++) {
					z+=a[i][k]*b[k][j];
				}
				m[i][j]=z;
				z=0;
			}
		}
		
		
		return m;
	}
	
	public static void printMat(int [][]m, int l, int c){
		
		for(int i=0; i<l; i++){
			for(int j=0; j<c; j++){
				out.printf("%2d | ",m[i][j]);
			}
			out.print("\n");
		}
	}
}
