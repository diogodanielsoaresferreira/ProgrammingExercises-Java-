/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula1;

public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void setDim(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double distTo(Point p2){
		return Math.sqrt(Math.pow(x-p2.getX(), 2)+Math.pow(y-p2.getY(), 2));
	}
	
	public String toString(){
		return "Ponto de coordenadas ("+x+","+y+")";
	}
	
}
