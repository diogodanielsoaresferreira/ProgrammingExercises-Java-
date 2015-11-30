/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula6;

public class Carne extends Alimento {
	
	private VariedadeCarne variedade;

	
	public Carne(VariedadeCarne variedade, double proteinas, double calorias, double peso){
		super(proteinas, calorias, peso);
		this.variedade = variedade;
	}

	public VariedadeCarne getVariedade() {
		return variedade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((variedade == null) ? 0 : variedade.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Carne [variedade=" + variedade.name() + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carne other = (Carne) obj;
		if (variedade != other.variedade)
			return false;
		if (!super.equals(other))
			return false;
		return true;
	}

	public enum VariedadeCarne {
		vaca,porco,peru,frango,outra;
		public static VariedadeCarne getVar(int i){
			switch(i){
				default:
				case 1: return VariedadeCarne.vaca;
				case 2: return VariedadeCarne.porco;
				case 3: return VariedadeCarne.peru;
				case 4: return VariedadeCarne.frango;
				case 5: return VariedadeCarne.outra;
			}
		}
		
	}
	
}
