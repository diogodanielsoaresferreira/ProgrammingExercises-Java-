/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class Automóvel extends Motorizado {

	private int vidros;
	
	public Automóvel(String cor, int lotacao, String marca,int ano,int velMax, double pot, double cons, double comb, int vidros){
		super(cor, 4, marca, ano, velMax, pot,cons,comb);
		assert pot>0 && comb>=0 && cons>0;
		this.vidros=vidros;
	}
	
	
	public int getVidros(){
		return vidros;
	}


	@Override
	public String toString() {
		return "Automóvel [vidros=" + vidros + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + vidros;
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
		Automóvel other = (Automóvel) obj;
		if (vidros != other.vidros)
			return false;
		if ( (Veículo) this != (Veículo) other) 
			return false;
		return true;
	}
	
}
