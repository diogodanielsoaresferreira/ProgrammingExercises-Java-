/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class Quadrado extends Retangulo {
	
	public Quadrado(double x, double y,double l){
		super(x,y,l,l);
	}
	
	public Quadrado(Point x,double l){
		super(x,l,l);
	}
	
	public Quadrado(double l){
		super(0,0,l,l);
	}
	
	
	
	public String toString(){
		return "Quadrado com centro no "+super.getCentro().toString()+", com comprimento "+super.getL()+", área "+super.area()+" e perímetro "+super.per()+".";
	}
	
}
