package p1;

import java.util.Scanner;

import static java.lang.System.*;

public class Ex907 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int []numeros;
		
		numeros=lerNumero();
		contarNumeros(numeros);
		
		
	}
	public static int[] lerNumero(){

		int []numeros = new int [100];
		int a;
		
		for(int i=0; i<=99; i++){
			out.print("Insira o número: ");
			a = sc.nextInt();
			if (a<0) break;
			else numeros[i] = a;
		}
		 return numeros;
	}
		

	public static void contarNumeros(int numeros[]){
		int max=numeros[0], min=numeros[0];
		int z=0;
		
		for(int i=0; i<numeros.length; i++){
			if(numeros[i]>max) max = numeros[i];
			if(numeros[i]<min) min = numeros[i];
		}
		for (int j=min; j<=max; j++){
			for(int k=0; k<numeros.length; k++){
				if (numeros[k]==0) break;
				if (numeros[k]==j) z++;
			}
			if (z!=0 && z!=1) out.print("\n" + j + " ocorre " + z + " vezes");
			if (z==1) out.print("\n" + j + " ocorre 1 vez");
			z=0;
		}
		
	}
	
}