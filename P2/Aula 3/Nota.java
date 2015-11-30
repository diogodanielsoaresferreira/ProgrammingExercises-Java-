/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class Nota {

	private Data2 inicio;
	private Data2 fim;
	private String texto;
	
	Nota (Data2 inicio, Data2 fim, String texto) {
		this.inicio = inicio;
		this.fim=fim;
		this.texto=texto;
	}
	
	public String escreve(){
		String r=null;
		r=inicio.escreve();
		r+=" <-> ";
		r+=fim.escreve();
		r+=(": " +texto);
		
		return r;
	}
	
	public Data2 getInicio(){
		return this.inicio;
	}
	
	public Data2 getFim(){
		return this.fim;
	}
}
