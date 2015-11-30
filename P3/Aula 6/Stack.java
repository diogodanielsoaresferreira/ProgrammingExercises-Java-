/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula6;

public class Stack<T> {

	public void push(T e){
		Node <T>n = new Node<T>();
		size++;
		n.e = e;
		n.next = top;
		top = n;
		
		assert !isEmpty();
	}
	
	public void pop(){
		top=top.next;
		size--;
	}
	
	public T top(){
		return top.e;
	}
	
	public boolean exists(T e){
		Node <T> c=top;
		while(c!=null){
			if(c.e.equals(e)) return true;
			c=c.next;
		}
		return false;
	}
	
	public void del(T e){
		assert exists(e);
		if (size==0) return;
		if (size==1) top=null;
		Node<T> c=top;
		Node<T> d;
		while(c!=null){
			if(c.e.equals(e))
			d=c;
			c=c.next;
		}
		size--;
	}
	
	public void clear(){
		size = 0;
		top = null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public Object[] nodesToArray(){
		Node<T> c = top;
		Object[] arr = new Object[size];
		int i=0;
		while(c!=null){
			arr[i++]=c.e;
			c=c.next;
		}
		
		return arr;
	}
	
	
	private class Node<T>{
		T e;
		Node <T> next;
	}
	
	private Node<T> top = null;
	private int size = 0;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		result = prime * result + ((top == null) ? 0 : top.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stack other = (Stack) obj;
		if (size != other.size)
			return false;
		if (top == null) {
			if (other.top != null)
				return false;
		} else if (!top.equals(other.top))
			return false;
		return true;
	}
	
	
}
