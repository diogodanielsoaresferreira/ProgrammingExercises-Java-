/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public abstract class Motorizado extends Veículo {

	private double potencia, comb, cons;
	
	public Motorizado(String cor, int lotacao, String marca,int ano,int velMax, double pot, double cons, double comb){
		super(cor, 4, lotacao, marca, ano, velMax);
		assert pot>0 && comb>=0 && cons>0;
		this.potencia=pot;
		this.comb=comb;
		this.cons=cons;
	}
	
	public double getPotencia(){
		return potencia;
	}
	
	public double getCombustivel(){
		return comb;
	}
	
	public double getConsumo(){
		return cons;
	}
	

	@Override
	public String toString() {
		return "Motorizado [potencia=" + potencia + ", comb=" + comb + ", cons=" + cons + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(comb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cons);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(potencia);
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
		Motorizado other = (Motorizado) obj;
		if (Double.doubleToLongBits(comb) != Double.doubleToLongBits(other.comb))
			return false;
		if (Double.doubleToLongBits(cons) != Double.doubleToLongBits(other.cons))
			return false;
		if (Double.doubleToLongBits(potencia) != Double.doubleToLongBits(other.potencia))
			return false;
		if ( (Veículo) this != (Veículo) other) 
			return false;
		return true;
	}
	
	
}
