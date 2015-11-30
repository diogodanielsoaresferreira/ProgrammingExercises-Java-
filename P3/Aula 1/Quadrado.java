/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula1;

public class Quadrado {
	private double l;
	private Point centro;
	
	public Quadrado(double l, Point c){
		assert l>0;
		this.l = l;
		centro = c;
	}
	
	public Quadrado(double l, double x, double y){
		assert l>0;
		this.l = l;
		centro = new Point (x, y);
	}
	
	public void setDim(double l){
		assert l>0;
		this.l = l;
	}
	
	public void setCen(double x, double y){
		centro = new Point(x, y);
	}
	
	public double area(){
		return l*l;
	}
	
	public double per(){
		return l*4;
	}
	
	public Point getCen(){
		return centro;
	}
	
	public double getDim(){
		return l;
	}
	
	public String toString(){
		return "Quadrado com centro no "+centro.toString()+", com comprimento "+l+", área "+area()+" e perímetro "+per()+".";
	}
	
}
