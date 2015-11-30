/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Retangulo extends Figura {
	private double l,h;
	
	public Retangulo(double l, double h, double x, double y){
		super(new Point(x,y));
		assert l>0 && h>0;
		this.l = l;
		this.h = h;
	}
	
	public Retangulo(double l, double h){
		super(new Point(0,0));
		assert l>0 && h>0;
		this.l = l;
		this.h = h;
	}
	
	
	public Retangulo(Retangulo r){
		super(r.getCentro());
		this.l=r.getL();
		this.h=r.getH();
	}
	
	public double area(){
		return l*h;
	}
	
	public double per(){
		return l*2+h*2;
	}

	public double getL(){
		return l;
	}
	
	public double getH(){
		return h;
	}
	
	@Override
	public String toString(){
		return "Retângulo com centro no "+super.getCentro().toString()+", com comprimento "+l+" e largura "+h+", área "+area()+" e perímetro "+per()+".";
	}
	
	public boolean equals(Retangulo r){
		if(r.h==this.h && r.l==this.l && r.getCentro().equals(this.getCentro())) return true;
		else return false;
	}
	
}
