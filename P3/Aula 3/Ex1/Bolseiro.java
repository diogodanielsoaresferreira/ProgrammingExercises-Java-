/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Bolseiro extends Estudante{
	
	private double bolsa=0;
	
	Bolseiro(String nome, int cc, Data nasc, Data insc){
		super(nome, cc, nasc, insc);
	}
	
	Bolseiro(String nome, int cc, Data nasc){
		super(nome, cc, nasc);
	}

	
	
	@Override
	public String toString() {
		return super.toString()+"\nBolsa: "+bolsa;
	}

	public double getBolsa() {
		return bolsa;
	}

	public void setBolsa(double bolsa) {
		this.bolsa = bolsa;
	}
	
	
	
}
