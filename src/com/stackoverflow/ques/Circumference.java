package com.stackoverflow.ques;

import com.yahoo.algos.TreeNode;

public class Circumference<T> {

	static int maxPath = -1;
	private int printTree(TreeNode<T> node) {
		if (node.getLeft() == null && node.getRight() == null){
			node.setDepth(0);node.setPathSize(-1);
			return 0;
		}
		int lDepth = node.getLeft()!=null? printTree(node.getLeft()) : -1;
		int rDepth = node.getRight()!=null? printTree(node.getRight()) : -1;
		
		node.setDepth(1+Math.max(lDepth, rDepth));
		
		if(node.getLeft()!=null && node.getRight() != null){
			int pathSize = 2 + lDepth + rDepth;
			if (pathSize > maxPath) maxPath = pathSize;
			node.setPathSize(2 + lDepth + rDepth);
		}
		
		return 1+Math.max(lDepth, rDepth);
	}
	
	public static void main(String[] args) {
		/*
		 *             0
		 *          /     \
		 *        5         6
		 *      /  \       / \ 
		 *    3     4     7    8
		 *     \     \   /\    /\
		 *     10    12 13 14 15 16
		 *  
		 */
		
		
		TreeNode<Integer> root = new TreeNode<Integer>(0); 
		TreeNode<Integer> five = new TreeNode<Integer>(5); 
		TreeNode<Integer> six = new TreeNode<Integer>(6); 
		TreeNode<Integer> three = new TreeNode<Integer>(3); 
		TreeNode<Integer> four = new TreeNode<Integer>(4); 
		TreeNode<Integer> seven = new TreeNode<Integer>(7); 
		TreeNode<Integer> eight = new TreeNode<Integer>(8); 
		TreeNode<Integer> nine = new TreeNode<Integer>(9); 
		TreeNode<Integer> ten = new TreeNode<Integer>(10); 
		TreeNode<Integer> eleven = new TreeNode<Integer>(11); 
		TreeNode<Integer> twelve = new TreeNode<Integer>(12); 
		TreeNode<Integer> thirteen = new TreeNode<Integer>(13); 
		TreeNode<Integer> fourteen = new TreeNode<Integer>(14); 
		TreeNode<Integer> fifteen = new TreeNode<Integer>(15); 
		TreeNode<Integer> sixteen = new TreeNode<Integer>(16); 
		
		
//		root.setLeft(five);root.setRight(six);
//		five.setLeft(three);five.setRight(four);
//		//three.setLeft(nine);
//		three.setRight(ten);
//		//four.setLeft(eleven);
//		four.setRight(twelve);
//		
//		six.setLeft(seven);six.setRight(eight);
//		seven.setLeft(thirteen);seven.setRight(fourteen);
//		eight.setLeft(fifteen);eight.setRight(sixteen);
		
		
		/*             0
		 *          /     \
		 *        5         6
		 *         \       / \ 
		 *          4     7    8
		 *           \   /    
		 *           12 13   
		 *   
		 */
//		root.setLeft(five);root.setRight(six);
//		five.setRight(four);four.setRight(twelve);
//		six.setLeft(seven);seven.setLeft(thirteen);
//		six.setRight(eight);
//		
		
		/*             0
		 *            /  \
		 *          10     6
		 *                 / \ 
		 *                7    5
		 *               /    /
		 *             13   4
		 *             /     \
		 *           12      16  
		 */
		root.setRight(six);root.setLeft(ten);
		six.setLeft(seven);six.setRight(five);
		seven.setLeft(thirteen); 
		thirteen.setLeft(twelve);
		five.setLeft(four); four.setRight(sixteen);
		
		System.out.println(new Circumference<Integer>().printTree(root));
		System.out.println(root.getPathSize());
		System.out.println("Max "+maxPath);
		//Circumference do dfs and find all max path sizes
	}


}
