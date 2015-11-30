/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula1;

public class Retangulo {
	private double l,h;
	private Point centro;
	
	public Retangulo(double l, double h, Point c){
		assert l>0 && h>0;
		this.l = l;
		this.h = h;
		centro = c;
	}
	
	public Retangulo(double l, double h, double x, double y){
		assert l>0 && h>0;
		this.l = l;
		this.h = h;
		centro = new Point(x,y);
	}
	
	public void setDim(double l, double h){
		assert l>0 && h>0;
		
		this.l = l;
		this.h = h;
	}
	
	public void setCen(double x, double y){
		centro = new Point(x, y);
	}
	
	public double area(){
		return l*h;
	}
	
	public double per(){
		return l*2+h*2;
	}
	
	public Point getCen(){
		return centro;
	}
	
	public double getl(){
		return l;
	}
	
	public double geth(){
		return h;
	}
	
	public String toString(){
		return "Retângulo com centro no "+centro.toString()+", com comprimento "+l+" e largura "+h+", área "+area()+" e perímetro "+per()+".";
	}
	
}
