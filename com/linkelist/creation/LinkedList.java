package com.linkelist.creation;

public class LinkedList {

	Node head; 
	int size;

	// method to add node at start
	public void addNode(int data) {
		Node myNode = new Node();
		myNode.setData(data);  
		if (head == null) {
			head = myNode; // assigning value of first node to head
		} else {
			myNode.setNext(head); // 
			head = myNode;
		}
		size++;
	}
	
	// method to add node at last
	public void appendNode(int data) {
		Node tail;
		Node myNode = new Node();
		myNode.setData(data);
		if(head == null) {
			head = myNode;
		}
		else {
			tail = head;
			while(tail.getNext() != null) {
				tail = tail.getNext();
			}
			tail.setNext(myNode);
		}
		size++;
	}
	
	// method to add node at given position 
	public void insertAtPos(int pos, int data) {
		if(pos == 1) {
			addNode(data);
		}
		else if(pos == size+1) {
			appendNode(data);
		}
		else if(pos > 1 && pos <= size) {
			Node temp;
			temp = head;
			Node myNode = new Node();
			myNode.setData(data);
			for(int i = 1; i < pos-1 ; i++) {
				temp = temp.getNext();
			}
			myNode.setNext(temp.getNext());
			temp.setNext(myNode);	
		}
		else {
			System.out.println("entered position out of range");
			}
		size++;	
	}

	// method to display nodes
	public void display() {
		Node temp = new Node();
		temp = head;
		while (temp.getNext() != null) { // prints node data till next becomes zero
			System.out.print(temp.getData());
			if (temp.getData() != 0) {
				System.out.print("->");
			}
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
		System.out.println("number of nodes in linkedlist are " + size);
	}
	
	public static void main(String[] args) {
		LinkedList numList = new LinkedList();
		numList.appendNode(56);
		numList.appendNode(70);
		numList.insertAtPos(2,30);
		numList.display();
	}
}
