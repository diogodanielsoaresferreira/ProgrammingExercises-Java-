/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;

import aula13.Localidade.TipoLocalidade;

public class Estado extends Região{
	
	private Localidade capital;
	
	public Estado(String nome, int pop, Localidade capital){
		super(nome, pop);
		if (capital.getT()!=TipoLocalidade.Cidade){
			try{
				throw new Exception();
			}
			catch(Exception e){
				System.err.println("Capital de país tem de ser cidade!");
				System.exit(1);
			}
		}
		this.capital=capital;
	}


	public Localidade getCapital() {
		return capital;
	}

	public boolean setCapital(Localidade capital) {
		if (capital.getT()!=TipoLocalidade.Cidade){
			return false;
		}
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
		Estado other = (Estado) obj;
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
