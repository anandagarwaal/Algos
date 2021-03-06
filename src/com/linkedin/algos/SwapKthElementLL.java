package com.linkedin.algos;

public class SwapKthElementLL {

	/**
	 * TODO what if the they are next toeach other
	 * 
	 */
	
	public static void swapElement(Node<String> head){
		//swap kth element from start and end
		int k = 6;
		Node<String> start = head;
		Node<String> tmp1 = head;
		
		//length of LL
		int len = 1;
		while(start.next!=null){
			tmp1 = start;
			start = start.next;
			len++;
		}
		
		if(k>len) { System.out.println("k ("+k+") bigger than length of LinkedList: "+len);return;}
		//Swap first last if k==1
		if(k==1) {
			start.next = head.next;
			head.next = null;
			tmp1.next = head;
			Node.printLL(start);
			return;
		}
		
		//Find the first swap element
		start = head;
		Node<String> swapStartPrev = moveNext(start, k-1);
		Node<String> swapStart = swapStartPrev.next;
		Node<String> swapStartNext = swapStart.next;
		
		//Find the last swap element
		start = head;
		Node<String> swapEndPrev = moveNext(start, len-k);
		Node<String> swapEnd = swapEndPrev.next;
		Node<String> swapEndNext = swapEnd.next;

		//If they are same
		if(swapEnd == swapStart){
			System.out.println("Same"); return;
		}
		
		//If they are next to each other
		if(swapStart.next == swapEnd ){
			swapStartPrev.next = swapEnd;
			swapEnd.next = swapStart;
			swapStart.next = swapEndNext;
			Node.printLL(head);
			return;
		}
		
		//Swap now
		swapStartPrev.next = swapEnd;
		swapEnd.next = swapStartNext;
		swapEndPrev.next = swapStart;
		swapStart.next = swapEndNext;
		
		Node.printLL(head);
		
	}
	
	private static Node<String> moveNext(Node<String> start , int k ){
		for(int i =1;i<k; i++){
			start = start.next;
		}
		
		return start;
	}
	
	public static void main(String[] args) {   
		Node<String> first = new Node<String>("a");
	    Node<String> second = new Node<String>("b");
	    Node<String> third = new Node<String>("c");
	    Node<String> fourth = new Node<String>("d");
	    Node<String> fifth = new Node<String>("e");
	    Node<String> sixth = new Node<String>("f");
	    Node<String> seventh = new Node<String>("g");
	    Node<String> eight = new Node<String>("h");
	    Node<String> nine = new Node<String>("i");
	
	    first.setNext(second);
	    second.setNext(third);
	    third.setNext(fourth);
	    fourth.setNext(fifth);
	    fifth.setNext(sixth);
	    sixth.setNext(seventh);
	    seventh.setNext(eight);
	    eight.setNext(nine);
	    
	    Node.printLL(first);
	    
	    swapElement(first);
    }

}
