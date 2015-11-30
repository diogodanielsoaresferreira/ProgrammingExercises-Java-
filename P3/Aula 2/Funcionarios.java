/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula2;

public class Funcionarios extends Clientes {
	
	private long nfunc;
	private long nfisc;
	
	public Funcionarios(Data insc, String nome, long CC, Data nasc, long nfunc, long nfisc, int n){
		super(insc, nome, CC, nasc, n);
		assert Data.validarData(insc.getYear(), insc.getMonth(), insc.getDay());
		assert Data.validarData(nasc.getYear(), nasc.getMonth(), nasc.getDay());
		assert CC>0;
		assert nfunc>0;
		assert nfisc>0;
		this.nfunc = nfunc;
		this.nfisc = nfisc;
	}
	
	
	public long getNfunc(){
		return nfunc;
	}
	
	public long getNfisc(){
		return nfisc;
	}
	
	
}
