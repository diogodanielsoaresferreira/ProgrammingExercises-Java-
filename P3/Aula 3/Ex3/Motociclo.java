/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Motociclo extends Veículo{

	private final char carta='A';
	private boolean sidecar;
	
	Motociclo(String marca, String modelo, Data matricula, boolean sidecar){
		super(marca, modelo, matricula,4);
		this.sidecar=sidecar;
	}
	
	public char getCarta(){
		return carta;
	}
	
	public boolean getSidecar(){
		return sidecar;
	}
	
}
