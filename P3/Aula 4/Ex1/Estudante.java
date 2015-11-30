/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula4;

public class Estudante extends Pessoa {
	
	private static int n=100;
	private int nmec;
	private Data insc;
	
	Estudante(String nome, int cc, Data nasc, Data insc){
		super(nome, cc, nasc);
		this.insc=insc;
		nmec=n;
		n++;
	}
	
	Estudante(String nome, int cc, Data nasc){
		super(nome, cc, nasc);
		this.insc=Data.now();
		nmec=n;
		n++;
	}

	@Override
	public String toString() {
		return super.toString()+"\nN. mec:"+nmec+"\nData de inscrição: "+insc.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((insc == null) ? 0 : insc.hashCode());
		result = prime * result + nmec;
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
		Estudante other = (Estudante) obj;
		if (insc == null) {
			if (other.insc != null)
				return false;
		} else if (!insc.equals(other.insc))
			return false;
		if (nmec != other.nmec)
			return false;
		return true;
	}

	public int getNmec() {
		return nmec;
	}

	public Data getInsc() {
		return insc;
	}
	
	
	
}
