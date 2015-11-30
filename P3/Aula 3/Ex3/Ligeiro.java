/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Ligeiro extends Veículo {
	
	final char carta='B';
	
	Ligeiro(String marca, String modelo, Data matricula){
		super(marca, modelo, matricula,4);
	}
	
	public char getCarta(){
		return carta;
	}
	
}
