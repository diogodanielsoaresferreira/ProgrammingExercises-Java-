/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula9;

public interface BFIterator {
	boolean hasPrevious();
	Object previous();
	boolean hasNext();
	Object next();
}
