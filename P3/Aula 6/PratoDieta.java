/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula6;

public class PratoDieta extends Prato {

	private Stack<Alimento> al=new Stack<Alimento>();
	private double limCal;
	
	public PratoDieta(String nome, double limCal){
		super(nome);
		this.limCal=limCal;
	}
	
	public double getLimCal() {
		return limCal;
	}



	public void setLimCal(double limCal) {
		this.limCal = limCal;
	}

	public Alimento[] getAlimentos(){
		Object[] e = al.nodesToArray();
		Alimento[] a = new Alimento[e.length];
		for (int i=0;i<e.length;i++){
			a[i] = (Alimento)e[i];
		}
		return a;
	}

	@Override
	public boolean addAl(Alimento alim){
		double cal=0;
		for(Object e: al.nodesToArray()){
			Alimento a = (Alimento)e;
			cal += a.getCalorias();
		}
		
		if(cal+alim.getCalorias()>limCal)
			return false;
		
		al.push(alim);
		return true;
	}

	


	@Override
	public String toString() {
		return "Prato Dieta ("+limCal+" calorias máximas) "+super.getNome()+" composto por "+al.size()+" ingredientes";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((al == null) ? 0 : al.hashCode());
		long temp;
		temp = Double.doubleToLongBits(limCal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PratoDieta other = (PratoDieta) obj;
		if (al == null) {
			if (other.al != null)
				return false;
		} else if (!al.equals(other.al))
			return false;
		if (Double.doubleToLongBits(limCal) != Double.doubleToLongBits(other.limCal))
			return false;
		if(!super.equals(other))
			return false;
		return true;
	}
	
	
}
