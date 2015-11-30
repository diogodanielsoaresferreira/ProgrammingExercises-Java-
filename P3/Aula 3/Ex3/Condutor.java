/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Condutor {
	
	private String name;
	private Data nasc;
	private int CC;
	private char carta;
	
	Condutor(String name, Data nasc, int cc, char carta){
		this.name=name;
		this.nasc=nasc;
		this.CC=cc;
		this.carta = carta;
	}

	public String getName() {
		return name;
	}

	public Data getNasc() {
		return nasc;
	}

	public int getCC() {
		return CC;
	}
	
	public int getCarta() {
		return carta;
	}
	
}
