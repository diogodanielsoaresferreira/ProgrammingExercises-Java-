/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Estudantes extends Clientes {
	
	private long mec;
	private String cur;
	
	public Estudantes(Data insc, String nome, long CC, Data nasc, long mec, String cur, int n){
		super(insc, nome, CC, nasc, n);
		assert Data.validarData(insc.getYear(), insc.getMonth(), insc.getDay());
		assert Data.validarData(nasc.getYear(), nasc.getMonth(), nasc.getDay());
		assert CC>0;
		assert mec>0;
		this.mec = mec;
		this.cur = cur;
	}
	
	public long getMec(){
		return mec;
	}
	
	public String cur(){
		return cur;
	}
	
}
