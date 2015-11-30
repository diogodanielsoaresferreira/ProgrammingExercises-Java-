/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class p93stack<T> {

	p93stack(int maxsize){
		assert maxsize>0;
		
		size=0;
		array = (T[]) new Object[maxsize];
		assert isEmpty();
	}
	
	public void push(T e){
		assert !isFull();
		
		array[size++] = e;
		
		assert !isEmpty();
	}
	
	public void pop(){
		assert !isEmpty();
		
		size--;
		
		assert !isFull();
	}
	
	public T top(){
		assert !isEmpty();
		
		return array[size-1];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return size == array.length;
	}
	
	public void print(){
		System.out.print("Stack: ");
		for(int i=0;i<size;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	private int size;
	private T[] array;
	
}
