/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula9;

public class Topping extends DecoratorGelado {

	String s;
	Topping(Gelado g, String s) {
		super(g);
		this.s=s;
	}
	
	@Override
	public void base(int i){
		g.base(i);
		System.out.print(" com "+s);
	}
	
	
}
