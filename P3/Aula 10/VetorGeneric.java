/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula10;

import java.util.*;

public class VetorGeneric<T> {
	
	Object[] el = new Object[0];
	
	private Object[] addObject(T elem){
		Object []copy = new Object[el.length+1];
		int i=0;
		for(i=0;i<el.length;i++)
			copy[i]=el[i];
		copy[i]=elem;
		
		return copy;
		
	}
	
	public boolean addElem(T elem){
		el=addObject(elem);
		return true;
	}
	
	public boolean removeElem(T elem){
		boolean exists=false;
		
		for(int i=0;i<el.length;i++){
			if(el.equals(elem)){
				exists = true;
			}
			if(exists=true && i+1<el.length)
				el[i]=el[i+1];
		}
		
		if(exists){
			Object []c = new Object[el.length-1];
			
			for(int i=0;i<el.length-1;i++){
				c[i]=el[i];
			}
			
			el=c;
			return true;
		}
		return false;
		
		
	}
	
	public int totalElem(){
		return el.length;
	}
	
	public Iterator<T> iterator(){
		return new VectorIterator();
	}
	
	private class VectorIterator implements Iterator<T>{
		int i=0;
		@Override
		public boolean hasNext() {
			return i<el.length;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T)el[i++];
		}
		
	}
	
}
