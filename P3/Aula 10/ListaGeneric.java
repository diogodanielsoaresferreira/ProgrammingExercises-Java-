/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula10;

import java.util.*;

public class ListaGeneric<T> {
	
	int size = 0;
	Node<T> top = new Node<T>();
	
	public boolean addElem(T elem){
		
		size++;
		Node<T> n = new Node<T>();
		n.elem = elem;
		
		if(top!=null){
			n.next=top;
		}
		top=n;
		
		return true;
	}
	
	public boolean removeElem(T elem){
		VectorIterator v = new VectorIterator();
		
		while(v.hasNext())
			if(v.equals(elem)){
				if(v.c.next!=null)
					v.c=v.c.next;
				else
					v.c=null;
				size--;
				return true;
			}
		
		return false;
	}
	
	public int totalElem(){
		return size;
	}
	
	public Iterator<T> iterator(){
		return new VectorIterator();
	}

	private class VectorIterator implements Iterator<T>{
		
		public Node<T> c = top;
		
		@Override
		public boolean hasNext() {
			return c.next!=null;
		}

		@Override
		public T next() {
			T elem = c.elem;
			c=c.next;
			return elem;
		}
		
	}
	
	private class Node<E>{
		E elem;
		Node<E> next;
	}
	
}
