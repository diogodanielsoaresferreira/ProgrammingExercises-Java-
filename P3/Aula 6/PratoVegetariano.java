/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula6;

public class PratoVegetariano extends Prato {

	private Stack<Vegetariano> v=new Stack<Vegetariano>();
	
	public PratoVegetariano(String nome){
		super(nome);
	}
	
	public Alimento[] getAlimentos(){
		Object[] e = v.nodesToArray();
		Alimento[] a = new Alimento[e.length];
		for (int i=0;i<e.length;i++){
			a[i] = (Alimento)e[i];
		}
		return a;
	}
	
	@Override
	public boolean addAl(Alimento veg){
		if(!(veg instanceof Vegetariano)) return false;
		v.push((Vegetariano)veg);
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((v == null) ? 0 : v.hashCode());
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
		PratoVegetariano other = (PratoVegetariano) obj;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		if(!super.equals(other))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prato Vegetariano "+super.getNome()+" composto por "+v.size()+" ingredientes";
	}
	
	
	
}
