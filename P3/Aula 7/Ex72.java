/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula7;

import static java.lang.System.*;
import java.io.IOException;

// Classe não funcional

public class Ex72 {

	public static void main(String[] args) throws IOException {
		
		Bitmap b = new Bitmap("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\Figura.bmp");
		out.println(b.toString());
		b.saveRaw();
		b.resize("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\Figurares.bmp");
	}

}
