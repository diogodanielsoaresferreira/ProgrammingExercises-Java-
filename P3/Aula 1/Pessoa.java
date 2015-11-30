/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº Mec. 76504
 * 
 */

package aula1;


public class Pessoa {
	
	private String nome;
	private String CC;
	private Data dataNasc;
	
	Pessoa(String nome, String cc, Data nasc){
		this.nome = nome;
		this.CC = cc;
		this.dataNasc = nasc;
	}
	
	public String getName(){
		return nome;
	}
	
	public String getCC(){
		return CC;
	}
	
	public Data getDate(){
		return dataNasc;
	}

	
}
