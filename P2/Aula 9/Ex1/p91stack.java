package p2;

public class p91stack <T> {

	
	public void push(T e){
		
		addElement(e);
		size++;
		
		assert !isEmpty() && top()==e;
	}
	
	public void pop(){
		assert !isEmpty();		

		size--;

	}
	
	public T top(){
		assert !isEmpty();
		
		return array[size-1];

	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public void clear(){
		size=0;
		
		assert isEmpty();
	}
	
	private void addElement(T e){
		T[] array2 = (T[]) new Object[size+1];
		
		int i;
		for(i=0;i<size();i++){
			array2[i] = array[i];
		}
		array2[i] = e;
		
		array = array2;
	}
	
	private int size=0;
	private T[] array;
	
}
