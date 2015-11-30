/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula6;


public class Peixe extends Alimento {
	
	private TipoPeixe tipo;
	
	public Peixe(TipoPeixe tipo, double proteinas, double calorias, double peso){
		super(proteinas, calorias, peso);
		this.tipo=tipo;
	}
	
	public TipoPeixe getTipoPeixe(){
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Peixe other = (Peixe) obj;
		if (tipo != other.tipo)
			return false;
		if(!super.equals(other))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Peixe [tipo=" + tipo.name() + super.toString();
	}
	
	public enum TipoPeixe {
		congelado,fresco;
		public static TipoPeixe getTipo(int i){
			switch(i){
				default:
				case 1: return TipoPeixe.congelado;
				case 2: return TipoPeixe.fresco;
			}
		}
	}
	
}
