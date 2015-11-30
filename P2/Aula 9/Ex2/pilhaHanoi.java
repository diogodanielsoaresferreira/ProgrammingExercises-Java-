package p2;

import static java.lang.System.*;

public class pilhaHanoi<T> {

	public pilhaHanoi(int maxsize){
		assert maxsize>0;
		
		array = (T[]) new Object[maxsize];
		size = 0;
		
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
	
	public void clear(){
		size = 0;
		
		assert isEmpty();
	}
	
	public boolean isFull(){
		return size == array.length;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void writeL(){
		for(int i=0;i<size;i++){
			out.print(array[i]+"\t");
		}
	}
	
	private int size;
	private T[] array;
	
}
