/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula9;

import java.util.*;

public abstract class TesteIterador {
	public static void main(String[] args) {
		
		VetorPessoa vp = new VetorPessoa();
		
		for (int i=0; i<10; i++)
		vp.addPessoa(new Pessoa("Bebé no Vector "+i,
				1000+i, Data.now()));
		
		Iterator<Pessoa> vec = vp.iterator();
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		ListaPessoas lp = new ListaPessoas();
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Bebé na Lista "+i,
					2000+i, Data.now()));
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		BFIterator lpes=vp.iteratorbf();
		
		for (int i=0;i<5;i++)
			System.out.println(lpes.next());
		
		for (int i=5;i>0;i--){
			System.out.println(lpes.hasPrevious());
			System.out.println(lpes.previous());
		}
		System.out.println(lpes.hasPrevious());
		
		lpes=lp.iteratorbf();
		
		for (int i=0;i<5;i++)
			System.out.println(lpes.next());
		
		for (int i=5;i>0;i--){
			System.out.println(lpes.hasPrevious());
			System.out.println(lpes.previous());
		}
		System.out.println(lpes.hasPrevious());
	}
}
