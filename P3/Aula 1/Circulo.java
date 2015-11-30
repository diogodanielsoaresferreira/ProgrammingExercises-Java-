/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula1;

public class Circulo {
	private double raio;
	private Point centro;
	
	public Circulo(double x, double y, double r){
		centro = new Point(x,y);
		raio = r;
	}
	
	public Circulo(Point centro, double r){
		this.centro = centro;
		raio = r;
	}
	
	public String toString(){
		return "Círculo com centro no "+centro.toString()+" e de raio "+raio+".";
	}
	
	public double getR(){
		return raio;
	}
	
	public Point getC(){
		return centro;
	}
	
	public double area(){
		return Math.PI*Math.pow(raio, 2);
	}
	
	public double per(){
		return 2*Math.PI*raio;
	}
	
	public boolean sameCirc(Circulo c2){
		if(c2.raio==raio && centro.getX()==c2.centro.getX() && centro.getY()==c2.centro.getY())
			return true;
		return false;
	}
	
	public boolean intCirc(Circulo c2){
		if(centro.distTo(c2.getC())-raio-c2.getR()<=0) return true;
		
		return false;
	}
	
}
