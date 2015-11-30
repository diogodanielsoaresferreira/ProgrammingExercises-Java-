/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula9;

import java.util.*;

public class VetorPessoa {
	
	List<Pessoa> p = new ArrayList<>();
	
	public boolean addPessoa(Pessoa p){
		if(this.p.add(p)) return true;
		return false;
	}
	
	public boolean removePessoa(Pessoa p){
		if(this.p.remove(p)) return true;
		return false;
	}
	
	public int totalPessoa(){
		return p.size();
	}
	
	public Iterator<Pessoa> iterator(){
		return new VectorIterator();
	}
	
	public BFIterator iteratorbf(){
		return new VecPessoaBFIterator();
	}
	
	private class VectorIterator implements Iterator<Pessoa>{
		int i=0;
		@Override
		public boolean hasNext() {
			return i<p.size();
		}

		@Override
		public Pessoa next() {
			return p.get(i++);
		}
		
	}
	
	private class VecPessoaBFIterator implements BFIterator{
		int i=0;
		@Override
		public boolean hasPrevious() {
			return i>0;
		}

		@Override
		public Object previous() {
			return p.get(--i);
		}

		@Override
		public boolean hasNext() {
			return i<p.size();
		}

		@Override
		public Object next() {
			return p.get(i++);
		}
		
	}
}
