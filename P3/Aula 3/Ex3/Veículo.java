/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Veículo {
	
	private String marca;
	private String modelo;
	private Data matricula;
	private int rodas;
	private Condutor c;
	
	Veículo(String marca, String modelo, Data matricula, int rodas){
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.rodas = rodas;
	}

	public Condutor getC() {
		return c;
	}

	public void setC(Condutor c) {
		this.c = c;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Data getMatricula() {
		return matricula;
	}
	
	public int getRodas(){
		return rodas;
	}
}
