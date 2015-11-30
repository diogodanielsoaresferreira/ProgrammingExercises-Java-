/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class p101stack<T> {
	
	public void push(T e){
		
		Node <T> n = new Node <T>();
		size++;
		n.e = e;
		n.next = top;
		top = n;
		
		assert !isEmpty();
	}
	
	public void pop(){
		assert !isEmpty();
		
		size--;
		top = top.next;
		
	}
	
	public T top(){
		assert !isEmpty();
		return top.e;
	}
	
	public void clear(){
		top = null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (top==null);
	}
	
	private class Node<T>{
		T e;
		Node <T> next;
	}
	
	public void print(){
		assert !isEmpty();
		Node<T> top2print = top;
	
		System.out.print(top2print.e + " ");
		
		while(top2print.next!=null){
			System.out.print(top2print.next.e + " ");
			top2print = top2print.next;
		}
	}
	

	private Node<T> top = null;
	private int size = 0;
}
