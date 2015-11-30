/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public abstract class Veículo implements Comparable<Veículo> {

	private String cor;
	private int rodas;
	private int lotacao;
	private String marca;
	private int ano;
	private double velMax;
	
	public Veículo(String cor, int rodas, int lotacao, String marca, int ano, double velMax){
		assert lotacao>0 && rodas>0 && velMax>0;
		this.cor=cor;
		this.lotacao=lotacao;
		this.rodas=rodas;
		this.marca=marca;
		this.ano=ano;
		this.velMax=velMax;
	}
	
	public String getCor(){
		return cor;
	}
	
	public int getRodas(){
		return rodas;
	}
	
	public int getLotacao(){
		return lotacao;
	}
	
	public String getMarca(){
		return marca;
	}
	
	public int getAno(){
		return ano;
	}
	
	public double getVelMax(){
		return velMax;
	}
	
	@Override
	public int compareTo(Veículo v){
		assert v!=null;
		
		if(this.getAno()>v.getAno()){
			return 1;
		}
		else if(this.getAno()<v.getAno()){
			return -1;
		}
		else return 0;
		
	}

	@Override
	public String toString() {
		return "Veículo [cor=" + cor + ", rodas=" + rodas + ", lotacao=" + lotacao + ", marca=" + marca + ", ano=" + ano
				+ ", velMax=" + velMax + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + lotacao;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + rodas;
		long temp;
		temp = Double.doubleToLongBits(velMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Veículo other = (Veículo) obj;
		if (ano != other.ano)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (lotacao != other.lotacao)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (rodas != other.rodas)
			return false;
		if (Double.doubleToLongBits(velMax) != Double.doubleToLongBits(other.velMax))
			return false;
		return true;
	}
	

}
