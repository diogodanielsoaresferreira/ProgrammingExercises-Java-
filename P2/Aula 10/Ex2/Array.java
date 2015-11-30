/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

@SuppressWarnings(value = "unchecked")
public class Array<T> {

	public Array(int maxsize){
		assert maxsize >= 0;
		
		array = (T[]) new Object[maxsize];
		size = 0;
	}
	
	public void set(int idx, T e){
		assert idx>0 && idx<array.length-1;
		
		Node n = new Node();
		n.e = idx;
		array[idx] = e;
		n.next = top;
		top = n;
		
		size++;
		
	}
	
	public boolean defined(int idx){
		Node tosearch = top;
		
		if(tosearch.e == idx) return true;
		while(tosearch.next!=null){
			tosearch = tosearch.next;
			if(tosearch.e==idx)
				return true;
		}
		
		return false;
		
	}
	
	public T get(int idx){
		assert idx>=0 && idx<array.length;
		assert defined(idx);
		
		Node tosearch = top;
		
		if(tosearch.e == idx) return array[tosearch.e];
		while(tosearch.next!=null){
			tosearch = tosearch.next;
			if(tosearch.e==idx)
				return array[tosearch.e];
		}
	
		T a = null;
		
		return a;
	}
	
	public int length(){
		return array.length;
	}
	
	private Node top=null;
	private T[] array = null;
	private int size;
	
	private class Node{
		int e;
		Node next;
	}
}
