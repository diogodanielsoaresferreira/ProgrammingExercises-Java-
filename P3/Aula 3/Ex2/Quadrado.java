/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Quadrado extends Retangulo {
	
	public Quadrado(double l, double x, double y){
		super(l,l,x,y);
	}
	
	public Quadrado(double l){
		super(l,l,0,0);
	}
	
	public Quadrado(Quadrado q){
		super(q.getL(),q.getL(),q.getCentro().getX(),q.getCentro().getY());
	}
	
	
	public String toString(){
		return "Quadrado com centro no "+super.getCentro().toString()+", com comprimento "+super.getL()+", área "+super.area()+" e perímetro "+super.per()+".";
	}
	
}
