/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;

public class Provincia extends Região {
	
	private String gov;
	
	public Provincia(String nome, int pop, String gov){
		super(nome, pop);
		this.gov=gov;
	}


	public String getGov() {
		return gov;
	}

	public void setGov(String gov) {
		this.gov=gov;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gov == null) ? 0 : gov.hashCode());
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
		Provincia other = (Provincia) obj;
		if (gov == null) {
			if (other.gov != null)
				return false;
		} else if (!gov.equals(other.gov))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return super.toString()+"Governador: "+gov;
	}

	
	
	
}
