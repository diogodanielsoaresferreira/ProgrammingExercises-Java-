/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class UtilCompare {
	
	public static <T> void sortArray(Comparable<T>[] a){
		
		int f=a.length-1;
		boolean troca=true;
		while (troca){
			troca = false;
			for(int i=0;i<f;i++){
				if(a[i].compareTo((T)a[i+1])>0){
					Comparable<T> temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					troca = true;
				}
				
			}
			f--;
		}
		
	}
	
	public static <T> Comparable<T> findMax(Comparable<T>[] a){
		int maxIndex = 0;
		
		for( int i = 1; i < a.length; i++ )
			if( a[i].compareTo((T)a[maxIndex]) > 0 )
				maxIndex = i;
		return a[maxIndex];
	}
	
}
