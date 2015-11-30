/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula7;

public class Voo {

	private String name;
	private String origem;
	private Hora atraso;
	private Hora hora;
	private String companhia;
	
	public Voo(Hora hora, String name, String companhia, String origem, Hora atraso){
		this.hora = hora;
		this.name = name;
		this.origem = origem;
		this.atraso = atraso;
		if(companhia!=null)
			this.companhia = companhia;
		else
			this.companhia = "-Sem Dados-";
	}
	
	public Voo(Hora hora, String name, String companhia, String origem){
		this(hora,name,companhia,origem,null);
	}
	

	public void setAtraso(Hora atraso) {
		this.atraso = atraso;
	}


	public String getName() {
		return name;
	}


	public String getOrigem() {
		return origem;
	}

	public Hora getAtraso() {
		return atraso;
	}

	public Hora getHora() {
		return hora;
	}
	
	public String getCompanhia(){
		return companhia;
	}

	public Hora getObs() {
		return hora.diff(atraso);
	}
	
	@Override
	public String toString(){
		if(atraso!=null)
			return String.format("%5s %7s %20s %20s %5s %5s", hora.toString(), name, companhia, origem, atraso, getObs());
		return String.format("%5s %7s %20s %20s", hora.toString(), name, companhia, origem);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atraso == null) ? 0 : atraso.hashCode());
		result = prime * result + ((companhia == null) ? 0 : companhia.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
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
		Voo other = (Voo) obj;
		if (atraso == null) {
			if (other.atraso != null)
				return false;
		} else if (!atraso.equals(other.atraso))
			return false;
		if (companhia == null) {
			if (other.companhia != null)
				return false;
		} else if (!companhia.equals(other.companhia))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		return true;
	}
	
	
	
}
