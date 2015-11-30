/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula1;

import static java.lang.System.*;

public class Ex103 {


	public static void main(String[] args) {

		//Testes às figuras geométricas
		
		Circulo a = new Circulo(0,0,2);
		Point p = new Point(0,0);
		Circulo b = new Circulo(p,2);
		Circulo c = new Circulo(1,1,4);
		Circulo d = new Circulo(10,10,1);
		
		out.println("Circulos sobrepostos: "+a.sameCirc(b));
		out.println("Circulos que se intercetam: "+a.intCirc(c));
		out.println("Circulos não sobrepostos: "+a.sameCirc(d));
		out.println("Circulos que não se intercetam: "+a.intCirc(d));
		out.println("Descrição Círculo (0,0,2): "+a.toString());
		out.println("Área do Círculo: "+a.area());
		out.println("Perímetro do Círculo: "+a.per());
		
		Retangulo e = new Retangulo(1,1,0,0);
		out.println("\nDescrição do retângulo: "+e.toString());
		out.println("Área do retângulo: "+e.area());
		out.println("Perímetro do retângulo: "+e.per());
		
		Quadrado f = new Quadrado(3,2,1);
		out.println("\nDescrição do quadrado: "+f.toString());
		out.println("Área do quadrado: "+f.area());
		out.println("Perímetro do quadrado: "+f.per());
		
		Point p2 = new Point(1,1);
		out.println("\nDescrição do ponto 2: "+p2.toString());
		out.println("Distância entre pontos: "+p2.distTo(p));
		
	}
	
}
