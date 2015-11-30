/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class p101queue<T> {

	public void in(T e){
		
		Node<T> n = new Node();
		n.e = e;
		if(pout==null)
			pout = n;
		else
			pin.next = n;
		pin = n;
		size++;
	}
	
	public void out(){
		assert !isEmpty();
		
		size--;
		pout = pout.next;
		
		if(pout == null)
			pin = null;
		
	}
	
	public T peek(){
		assert !isEmpty();
		
		return pout.e;
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public void clear(){
		pout = null;
		pin = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		assert !isEmpty();
		Node <T> pout2print = pout;
		
		do{
			System.out.print(pout2print.e + " ");
			pout2print = pout2print.next;
		}while(pin!=pout2print);
		
		System.out.print(pout2print.e + " ");
		
	}
	
	private int size = 0;
	private Node<T> pout = null;
	private Node<T> pin = null;
	
	public class Node<T>{
		T e;
		Node <T> next = null;
	}
}
