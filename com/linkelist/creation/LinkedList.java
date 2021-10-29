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
		Node temp;
		Node myNode = new Node();
		myNode.setData(data); 
		if (head == null) {
			head = myNode; // assigning value of first node to head
			temp = myNode;
		}
		else {
			temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(myNode);	
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
		numList.appendNode(70);
		numList.appendNode(30);
		numList.appendNode(56);
		numList.display();
	}
}
