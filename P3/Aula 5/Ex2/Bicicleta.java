/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class Bicicleta extends Veículo {
	
	private String quadro;
	private String travoes;
	private int mudancas;
	
	public Bicicleta(String cor, int lotacao, String marca,int ano,int velMax, String quadro, String travoes, int mudancas){
		super(cor, 2, lotacao, marca, ano, velMax);
		this.quadro=quadro;
		this.travoes=travoes;
		this.mudancas=mudancas;
	}

	public String getQuadro() {
		return quadro;
	}

	public String getTravoes() {
		return travoes;
	}

	public int getMudancas() {
		return mudancas;
	}
	

	@Override
	public String toString() {
		return "Bicicleta [quadro=" + quadro + ", travoes=" + travoes + ", mudancas=" + mudancas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + mudancas;
		result = prime * result + ((quadro == null) ? 0 : quadro.hashCode());
		result = prime * result + ((travoes == null) ? 0 : travoes.hashCode());
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
		Bicicleta other = (Bicicleta) obj;
		if (mudancas != other.mudancas)
			return false;
		if (quadro == null) {
			if (other.quadro != null)
				return false;
		} else if (!quadro.equals(other.quadro))
			return false;
		if (travoes == null) {
			if (other.travoes != null)
				return false;
		} else if (!travoes.equals(other.travoes))
			return false;
		if ( (Veículo) this != (Veículo) other) 
			return false;
		return true;
	}
	
	
	
}
