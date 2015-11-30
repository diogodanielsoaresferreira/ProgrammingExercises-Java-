/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;


public class p103queue<T> {

	public void in(T e){
		
		size++;
		Node n = new Node();
		n.e = e;
		
		if(pout == null){
			n.prev = n;
			n.next = n;
			pout = n;
			pin = n;
		}
		else{
			n.next = pin;
			n.prev = pout;
			pout.next = n;
			pin.prev = n;
			pin = n;
		}
		
	}
	
	public void out(){
		assert !isEmpty();
		size--;
		
		pout = pout.prev;
		pout.next = pin;
		pin.prev = pout;
		
	}
	
	public T peek(){
		return pout.e;
	}
	
	public void clear(){
		pout = null;
		pin = null;
		size = 0;
		assert isEmpty();
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void print(){
		Node print = pin;
		
		while(print != pout){
			System.out.print(print.e);
			print = print.next;
		}
		System.out.println(print.e);
	}
	
	private Node pin = null;
	private Node pout = null;
	private int size = 0;
	
	private class Node{
		T e;
		Node next;
		Node prev;
	}
}
