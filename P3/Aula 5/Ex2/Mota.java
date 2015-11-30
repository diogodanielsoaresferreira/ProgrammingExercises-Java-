/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class Mota extends Motorizado {
	
	private String capacete;
	
	public Mota(String cor, int lotacao, String marca,int ano,int velMax, double pot, double cons, double comb, String capacete){
		super(cor, 4, marca, ano, velMax, pot,cons,comb);
		assert pot>0 && comb>=0 && cons>0;
		this.capacete=capacete;
	}
	
	
	public String getCapacete(){
		return capacete;
	}


	@Override
	public String toString() {
		return "Mota [capacete=" + capacete + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((capacete == null) ? 0 : capacete.hashCode());
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
		Mota other = (Mota) obj;
		if (capacete == null) {
			if (other.capacete != null)
				return false;
		} else if (!capacete.equals(other.capacete))
			return false;
		if ( (Motorizado) this != (Motorizado) other) 
			return false;
		return true;
	}
	
	

}
