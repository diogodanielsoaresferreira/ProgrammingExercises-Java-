/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class PMercadorias extends Pesado{
	
	private final double tara;
	private boolean hasExt;
	
	PMercadorias(String marca, String modelo, Data matricula, double tara, boolean hasExt){
		super(marca, modelo, matricula,'C');
		this.tara = tara;
		this.hasExt = hasExt;
	}
	
	PMercadorias(String marca, String modelo, Data matricula, double tara){
		super(marca, modelo, matricula,'C');
		this.tara = tara;
	}
	
	public void setExt(boolean n){
		hasExt=n;
	}
	
	public double getTara(){
		return tara;
	}
	
	public boolean getHasExt(){
		return hasExt;
	}
}
