/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class BTree<T> {

	public void set(String key, T elem){
		
		if(search(key) != null) search(key).elem = elem;
		else{
			Node <T> n = new Node();
			n.key = key;
			n.elem = elem;
			insert(n);
		}
		
		
	}
	
	public T get(String key){
		assert exists(key);
		
		return search(key).elem;
	}
	
	public void delete(String key){
		assert exists(key);
		root = root.delete(key);
		assert !exists(key);
	}
	
	public boolean exists(String key){
		
		return search(key) != null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void clear(){
		root = null;
		size = 0;
		assert isEmpty();
	}
	
	public String[] keysToArray(){
		String [] arr = new String[0];
		return root.keysToArray(arr);
	}
	
	private Node<T> search(String key){
		if (root == null) return null;
		return root.search(key);
	}
	
	private void insert (Node <T> n){
		if(root == null) root = n;
		else root.insert(n);
	}
	
	private int size = 0;
	private Node<T> root = null;

	private class Node<T>{
		String key;
		T elem;
		Node <T> left;
		Node <T> right;
		
		Node<T> search (String key){
			if(this.key.equals(key)) return this;
			if(left != null && key.compareTo(this.key)<0) return left.search(key);
			else if(right != null && key.compareTo(this.key)> 0) return right.search(key);
			return null;
		}
		
		
		void insert (Node <T> n){
			if(n.key.compareTo(this.key)<0){
				if(left == null) left = n;
				else left.insert(n);
			}
			if(n.key.compareTo(this.key)>0){
				if(right == null) right = n;
				else right.insert(n);
			}
			
		}
	
		Node<T> delete(String key){
			if(key.compareTo(this.key)<0) return left = left.delete(key);
			else if(key.compareTo(this.key)>0) return right = right.delete(key);
			else{
				if(left == null) return right;
				else if(right == null) return left;
				else{
					right.insert(left);
					return right;
				}
			}
		}
		
		String[] keysToArray(String [] a){
			a = addElement (a, key);
			if(left!=null) return left.keysToArray(a);
			if(right!=null) return right.keysToArray(a);
			
			return a;
		}
		
		private String[] addElement(String[] array, String key){
			
			String[] copy = new String[array.length+1];
			
			System.arraycopy(array,0,copy,0,array.length);
			copy[array.length] = key;
			return copy;
		}
	}
}
