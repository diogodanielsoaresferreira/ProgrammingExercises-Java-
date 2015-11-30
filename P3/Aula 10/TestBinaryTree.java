/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula10;

import java.util.Iterator;

public class TestBinaryTree {

	public static void main(String[] args){
		BinarySearchTree<Integer> tree= new BinarySearchTree<>();
		
		tree.insert(5);
		tree.insert(2);
		tree.insert(3);
		tree.insert(6);
		tree.insert(8);
		tree.insert(1);

		Iterator<Integer> itree = tree.iterator();
		while(itree.hasNext()){
			System.out.println(itree.next());
		}
		
		System.out.println(tree.contains(5));
		System.out.println(tree.contains(3));
		System.out.println(tree.contains(7));
		System.out.println(tree.contains(4));
		System.out.println(tree.contains(1));
		tree.remove(1);
		tree.remove(3);
		System.out.println(tree.contains(1));
		System.out.println(tree.contains(7));
		System.out.println(tree.contains(3));
		

		
		
		
	}

}
