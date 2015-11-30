/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula4;

public class Professor extends Pessoa {

	private static int n=1;
	private int nmec;
	private int nfunc;
	private Data dataAdm;
	
	Professor(String nome, int cc, Data nasc, int nfunc, Data dataAdm){
		super(nome, cc, nasc);
		assert Data.validarData(dataAdm.getYear(), dataAdm.getMonth(), dataAdm.getDay());
		this.nfunc = nfunc;
		this.dataAdm = dataAdm;
		nmec = n;
		n++;
	}
	
	Professor(String nome, int cc, Data nasc){
		super(nome, cc, nasc);
		nmec = n;
		n++;
		
	}
	
	public void setDataadm(Data dataAdm){
		this.dataAdm=dataAdm;
	}
	
	public void setNfunc(int nfunc){
		this.nfunc=nfunc;
	}

	public int getNFunc(){
		return nfunc;
	}
	
	public Data getDataAdm(){
		return dataAdm;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataAdm == null) ? 0 : dataAdm.hashCode());
		result = prime * result + nfunc;
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
		Professor other = (Professor) obj;
		if (dataAdm == null) {
			if (other.dataAdm != null)
				return false;
		} else if (!dataAdm.equals(other.dataAdm))
			return false;
		if (nfunc != other.nfunc)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor: "+super.getName()+", CC: "+super.getCC()+", data de nascimento: "+super.getDate().toString()+", NMEC: "+nmec;
	}
	
	
	
}
