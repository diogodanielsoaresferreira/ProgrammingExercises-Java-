/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class PPassageiros extends Pesado{

	private final int lotacao;
	
	PPassageiros(String marca, String modelo, Data matricula, int lotacao){
		super(marca, modelo, matricula,'D');
		this.lotacao=lotacao;
	}
	
	public int getLotacao(){
		return lotacao;
	}
	
}
