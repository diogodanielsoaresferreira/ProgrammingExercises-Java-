/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bolsa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bolseiro other = (Bolseiro) obj;
		if (Double.doubleToLongBits(bolsa) != Double.doubleToLongBits(other.bolsa))
			return false;
		if(!super.equals(other))
			return false;
		return true;
	}
	
	
}
