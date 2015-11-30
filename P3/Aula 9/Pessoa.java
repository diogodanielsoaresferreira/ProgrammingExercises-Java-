/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº Mec. 76504
 * 
 */

package aula9;

public class Pessoa {
	
	private String nome;
	private int CC;
	private Data dataNasc;
	
	Pessoa(String nome, int cc, Data nasc){
		this.nome = nome;
		this.CC = cc;
		this.dataNasc = nasc;
	}
	
	public String getName(){
		return nome;
	}
	
	public int getCC(){
		return CC;
	}
	
	public Data getDate(){
		return dataNasc;
	}

	@Override
	public String toString(){
		return "Nome: "+this.nome+"\nCC:"+this.CC+"\nData de nascimento: "+this.dataNasc.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CC;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (CC != other.CC)
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
