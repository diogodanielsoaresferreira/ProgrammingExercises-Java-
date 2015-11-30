/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula9;

public abstract class DecoratorGelado implements Gelado {
	
	protected Gelado g;
	
	DecoratorGelado(Gelado g){
		this.g=g;
	}
	
	@Override
	public void base(int i){
		g.base(i);
	}
	
}
