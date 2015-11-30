/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class p103stack<T> {

	public void push(T e){
		
		size++;
		Node n = new Node();
		
		n.e = e;
		
		if(top!=null){
			n.prev = top;
			n.next = top.next;
			top.next = n;
		}
		else{
			n.prev = n;
			n.next = n;
		}
		top = n;
		
	}
	
	public void pop(){
		assert !isEmpty();
		size--;
		
		top.prev.next = top.next;
		top.next.prev = top.prev;
		top = top.prev;
	}
	
	public T top(){
		assert !isEmpty();
		
		return top.e;
	}
	
	public void clear(){
		size=0;
		top=null;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		Node print = top.next;
		
		while(print != top){
			System.out.print(print.e);
			print = print.next;
		}
		System.out.print(print.e);

	}
	
	private Node top = null;
	private int size = 0;
	
	private class Node{
		T e;
		Node next;
		Node prev;
	}
}
