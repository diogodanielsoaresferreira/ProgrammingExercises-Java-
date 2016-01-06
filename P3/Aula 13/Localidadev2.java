/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;


public class Localidadev2<T> implements Comparable<Localidadev2<T>> {

	private String nome;
	private int pop;

	public Localidadev2(String nome, int pop){
		if (pop<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				System.err.println("Valor de população inválido!");
				System.exit(1);
			}
		}
		this.nome=nome;
		this.pop=pop;
	}



	public String getNome() {
		return nome;
	}


	public int getPop() {
		return pop;
	}


	public boolean setPop(int pop) {
		if(pop<0) return false;
		this.pop = pop;
		return true;
	}


	@Override
	public String toString() {
		return nome+", população: "+pop;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + pop;
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
		Localidadev2<T> other = (Localidadev2<T>) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pop != other.pop)
			return false;
		return true;
	}



	@Override
	public int compareTo(Localidadev2<T> l) {
		try{
			if(l==null)
				throw new Exception();
		}
		catch(Exception e){
			System.err.println("Referência não pode ser nula.");
			System.exit(1);
		}


		if(this.pop>l.getPop()) return 1;
		else if(this.pop<l.getPop()) return -1;
		return 0;
	}


}
