/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula10;

import java.util.*;
import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
	
	private static class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		
		BSTNode(T theElement) {
			element = theElement;
			left = right = null;
		}
		
	}
	
	private BSTNode<T> root;
	private int numNodes;
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	
	public void insert(T value) {
		root = insert(value, root);
		numNodes++;
	}
	
	public void remove(T value) {
		root=remove(value, root);
		numNodes--;
	}
	
	public boolean contains(T value) {
		return find(value, root) != null;
	}
	
	public int size(){
		return numNodes;
	}
	
	public void clear(){
		root=null;
		numNodes=0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new TreeIterator();
	}
	
	BSTNode<T> insert(T value, BSTNode<T> node){
		if(node==null) return node=new BSTNode<T>(value);
		if(node.element.compareTo(value)>0){
			if(node.left == null) node.left = new BSTNode<T>(value);
			else insert(value, node.left);
		}
		else{
			if(node.right == null) node.right = new BSTNode<T>(value);
			else insert(value, node.right);
		}
		return node;
	}
	
	
	// Mal Implementado
	BSTNode<T> remove(T value, BSTNode<T> node){
		if(node.element.compareTo(value)>0) return node.left=remove(value, node.left);
		else if(node.element.compareTo(value)<0) return node.right=remove(value, node.right);
		else{
			if(node.left == null) node=node.right;
			else if(node.right == null) node=node.left;
			else{
				node=insert(node.left.element, node.right);
			}
			return node;
		}
	}
	
	BSTNode<T> find(T value, BSTNode<T> node){
		try{
			if((node.element).compareTo(value)>0) return find(value, node.left);
			else if((node.element).compareTo(value)<0) return find(value, node.right);
			else return node;
		}
		catch(NullPointerException e){
			return null;
		}
	}
	
	// Mal implementado
	public class TreeIterator implements Iterator<T> {

	    private List<BSTNode<T>> stack = new LinkedList<>();
	    private BSTNode<T> n=root;

	    public TreeIterator(){
	    	while (n != null) {
	            stack.add(n);
	            BSTNode<T> n2=n.right;
	            while(n2!=null){
	            	stack.add(n2);
	            	n2=n2.right;
	            }
	            n = n.left;
	        }

	    }
	    
	    @Override
	    public T next() {
	        stack.remove(n);
	        BSTNode<T> node = n;
	        n = n.right;

	        return node.element;
	    }

	    @Override
	    public boolean hasNext() {
	        return (!stack.isEmpty() || n != null);
	    }
	}
}
