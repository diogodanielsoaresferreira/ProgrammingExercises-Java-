/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;


public class Estadov2 extends Região {
	private Localidadev2<Cidade> capital;
	
	public Estadov2(String nome, int pop, Localidadev2<Cidade> capital){
		super(nome, pop);
		this.capital=capital;
	}


	public Localidadev2<Cidade> getCapital() {
		return capital;
	}

	public boolean setCapital(Localidadev2<Cidade> capital) {
		this.capital = capital;
		return true;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
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
		Estadov2 other = (Estadov2) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return super.toString()+"Capital: "+capital.getNome();
	}

	
}
