/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;

import java.util.*;

import aula13.Localidade.TipoLocalidade;

public class Pais implements Comparable<Pais> {
	
	private String nome;
	private Localidade capital;
	private List<Região> Regioes = new ArrayList<>();
	
	public Pais(String nome, Localidade capital){
		if (capital.getT()!=TipoLocalidade.Cidade || capital==null){
			try{
				throw new Exception();
			}
			catch(Exception e){
				System.err.println("Capital de país tem de ser cidade!");
				System.exit(1);
			}
		}
		this.nome=nome;
		this.capital=capital;
	}
	
	public Pais(String nome){
		
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

	public Localidade getCapital() {
		return capital;
	}

	public List<Região> getRegioes() {
		return Regioes;
	}

	public boolean setCapital(Localidade capital) {
		if (capital.getT()!=TipoLocalidade.Cidade || capital==null){
			return false;
		}
		this.capital = capital;
		return true;
	}

	public void addRegiao(Região r) {
		Regioes.add(r);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Regioes == null) ? 0 : Regioes.hashCode());
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (Regioes == null) {
			if (other.Regioes != null)
				return false;
		} else if (!Regioes.equals(other.Regioes))
			return false;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(capital!=null)
			return "País: "+nome+", População: "+getPopulação()+"(Capital: "+capital+" )";
		else
			return "País: "+nome+", População: "+getPopulação()+"(Capital: *Indefinida*)";
	}

	public int getPopulação(){
		if(Regioes!=null)
			return this.Regioes.stream().mapToInt(Região::getPop).sum();
		return 0;
	}
	
	@Override
	public int compareTo(Pais p) {

		if(this.getPopulação()>p.getPopulação()) return 1;
		else if (this.getPopulação()<p.getPopulação()) return -1;
		else return 0;
		
	}
	
	public boolean removeR(Região r){
		return Regioes.remove(r);
	}
	
	public void removeC(){
		capital=null;
	}
	
	public void sort(){
		Regioes.sort((x,y)-> x.getPop()>y.getPop()? 1: -1);
	}
	
}
