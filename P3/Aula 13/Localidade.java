/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;

public class Localidade implements Comparable<Localidade> {
	
	private String nome;
	private int pop;
	private TipoLocalidade t;
	
	public Localidade(String nome, int pop, TipoLocalidade t){
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
		this.t=t;
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


	public void setT(TipoLocalidade t) {
		this.t = t;
	}


	public TipoLocalidade getT() {
		return t;
	}


	public enum TipoLocalidade{
		Cidade(1),Vila(2),Aldeia(3);
		
		private int t;
		
		TipoLocalidade(int tipo){
			tipo=t;
		}
		
	}


	@Override
	public String toString() {
		return t.name()+" "+nome+", população: "+pop;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + pop;
		result = prime * result + ((t == null) ? 0 : t.hashCode());
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
		Localidade other = (Localidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pop != other.pop)
			return false;
		if (t != other.t)
			return false;
		return true;
	}



	@Override
	public int compareTo(Localidade l) {
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
