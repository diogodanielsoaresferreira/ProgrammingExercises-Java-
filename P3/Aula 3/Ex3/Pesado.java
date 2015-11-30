/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Pesado extends Veículo{
	
	private final char carta;
	
	Pesado(String marca, String modelo, Data matricula, char carta){
		super(marca, modelo, matricula,4);
		this.carta=carta;
	}
	
	public char getCarta(){
		return carta;
	}
}
