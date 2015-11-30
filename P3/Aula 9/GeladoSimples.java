/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula9;

public class GeladoSimples implements Gelado{
	String sabor;
	
	public GeladoSimples(String sabor){
		this.sabor = sabor;
	}
	
	@Override
	public void base(int i){
		System.out.print("\n"+i+" bolas de gelado de "+sabor);
	}
	
}
