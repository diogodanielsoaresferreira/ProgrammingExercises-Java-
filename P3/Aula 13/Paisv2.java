/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;

import java.util.*;

public class Paisv2 implements Comparable<Paisv2> {
	private String nome;
	private Localidadev2<Cidade> capital;
	private List<Região> Regioes = new ArrayList<>();
	
	public Paisv2(String nome, Localidadev2<Cidade> capital){
		this.nome=nome;
		this.capital=capital;
	}
	
	public Paisv2(String nome){
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

	public Localidadev2<Cidade> getCapital() {
		return capital;
	}

	public List<Região> getRegioes() {
		return Regioes;
	}

	public boolean setCapital(Localidadev2<Cidade> capital) {
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
		Paisv2 other = (Paisv2) obj;
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
	public int compareTo(Paisv2 p) {

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
