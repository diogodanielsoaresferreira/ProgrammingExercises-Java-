/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class CarroPolicia extends Automóvel implements Policia {
	
	private String tipo;
	private String ID;
	
	public CarroPolicia(String cor, int lotacao, String marca,int ano,int velMax, double pot, double cons, double comb, int vidros, String tipo, String ID){
		super(cor, 4, marca, ano, velMax, pot,cons,comb,vidros);
	}
	
	@Override
	public String getTipo(){
		return tipo;
	}
	
	@Override
	public String getID(){
		return ID;
	}
	
	

	@Override
	public String toString() {
		return "CarroPolicia [tipo=" + tipo + ", ID=" + ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		CarroPolicia other = (CarroPolicia) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if ( (Automóvel) this != (Automóvel) other) 
			return false;
		return true;
	}
	
	
}
