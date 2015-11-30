/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

@SuppressWarnings(value = "unchecked")
public class AssociativeArray<T> {
	
	AssociativeArray(int maxsize){
		array = (Node<T>[]) new Node[maxsize];
		for (int i=0;i<maxsize;i++){
			array[i] = new Node<T>();
		}
		size = 0;
	}
	
	public void set(String key, T e){
		if(exists(key)){
			searchNode(key).e = e;
		}
		else{
			int pos = Math.abs(key.hashCode()) % array.length;
			Node<T> n = new Node<T>();
			n.key = key;
			n.e = e;
			n.next = array[pos];
			array[pos] = n;
			size++;
		}
		
	}
	
	public T get(String key){
		assert exists(key);
		
		return (T)searchNode(key).e;
	}
	
	public boolean exists(String key){
		if(searchNode(key).key != null) return true;
		else return false;
	}
	
	public void delete(String key){
		assert exists(key);
		
		int pos = Math.abs(key.hashCode()) % array.length;
		Node search = array[pos];
		Node lastn = null;
		
		while (search != null){
			if(search.key.equals(key)) break;
			lastn = search;
		}
		
		lastn.next = search.next;
		size--;
	}
	
	public void clear(){
		size = 0;
		for(int i=0;i<array.length;i++){
			array[i] = null;
		}
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public String[] keysToArray(){
		String [] keys = new String[0];
		for(int i=0;i<array.length;i++){
			Node search = array[i];
			while(search.key != null){
				keys = addEl(keys, search.key);
				search = search.next;
			}
		}
		return keys;
	}
	
	private String[] addEl(String[]key, String a){
		String []array = new String[key.length+1];
		System.arraycopy(key,0,array,0,key.length);
		array[key.length] = a;
		return array;
	}
	
	private Node searchNode(String key){
		int pos = Math.abs(key.hashCode()) % array.length;

		Node search = array[pos];
		
		while(search.key != null){
			if(search.key.equals(key)){
				return search;
			}
			search = search.next;
		}
		
		return search;
	}
	
	
	private class Node<T>{
		String key;
		T e;
		Node next;
	}
	private Node<T>[] array;
	private int size;
}
