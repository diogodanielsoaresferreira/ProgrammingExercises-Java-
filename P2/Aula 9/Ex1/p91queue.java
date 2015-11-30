/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class p91queue<T> {
	
	public p91queue(int maxsize){
		assert maxsize>=0;
		
		array = (T[]) new Object[maxsize];
		size=0;
	}

	public void in(T e){
		assert !isFull();
		
		array[tail] = e;
		tail=nextPosition(tail);
		size++;
		
		assert !isEmpty();
	}
	
	public void out(){
		assert !isEmpty();
		
		head=nextPosition(head);
		size--;
	}
	
	public T peek(){
		assert !isEmpty();
		
		return array[head];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public boolean isFull(){
		return size==array.length;
	}
	
	
	public void clear(){
		size=0;
		assert isEmpty();
	}
	
	public int nextPosition(int p){
		return (p + 1) % array.length;
	}
	
	private T[] array;
	private int size=0;
	private int head, tail;
	
}
