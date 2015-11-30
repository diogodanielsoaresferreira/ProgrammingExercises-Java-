/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula4;

public abstract class Figura {
	
	private Point centro;
	
	Figura(Point centro){
		this.centro = centro;
	}
	
	public Point getCentro(){
		return centro;
	}

	public abstract double area();
	public abstract double per();
	
}
