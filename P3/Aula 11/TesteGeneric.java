/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula11;

import java.util.*;
import aula5.*;

public abstract class TesteGeneric {
	public static void main(String[] args) {
		
		List<Pessoa> vp = new LinkedList<>();
		for (int i=0; i<10; i++)
			vp.add((new Pessoa("Bebé no Vector "+i,1000+i,Data.now())));
		Iterator<Pessoa> vec = vp.iterator();
		
		printSet(vp.iterator());
		
		List<Pessoa> lp = new LinkedList<Pessoa>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		List<Figura> figList = new LinkedList<>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Retangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		List< Retangulo > quadList = new LinkedList<>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Retangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
	}
				
	
	private static double sumArea(List<? extends Figura> f){
		double area=0;
		Iterator<? extends Figura> i = f.iterator();
		
		while(i.hasNext()){
			area+=(i.next()).area();
		}
		
		return area;
	}
	
	private static <T> void printSet(Iterator<T> i){
		while (i.hasNext()){
			System.out.println(i.next());
		}
	}
	
}
