/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import pt.ua.prog.Data;

public class Nota {

	private Data inicio;
	private Data fim;
	private String texto;
	
	public Nota(){}
	
	public Nota (Data inicio, Data fim, String texto) {
		assert inicio.menorQue(fim) : "Data inválida!";
		assert !texto.isEmpty(): "Texto vazio";
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
	
	public Data getInicio(){
		return this.inicio;
	}
	
	public Data getFim(){
		return this.fim;
	}
}
