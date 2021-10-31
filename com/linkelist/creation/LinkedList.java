package com.linkelist.creation;

public class LinkedList {

	private Node head; 
	private int size;

	// method to add node at start
	public void add(int data) {
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
	public void append(int data) {
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
			add(data);
		}
		else if(pos == size+1) {
			append(data);
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
	
	// method to insert data after given data
	public void insertAfterGivenData(int prevData, int insertData) {
		Node temp;
		Node myNode = new Node();
		myNode.setData(insertData);
		if(isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			temp = head ;
			while(temp != null) {
				if(temp.getData() == prevData) {
					myNode.setNext(temp.getNext());
					temp.setNext(myNode);	
					size++;
					break;
				}
				temp = temp.getNext();	
			}
			if(temp == null) {
				System.out.println("Data is not present in the list");
			}
		}
	}

	// method to delete first node
	public void pop() {
		if(isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			head = head.getNext();
			size--;
		}
	}

	// method to remove last element of list
	public void popLast() {
		if(isEmpty()) {
			System.out.println("List is empty");
		}
		else if(size == 1) {
			head = null;
			size--;
		}
		else {
			Node temp;
			temp = head;
			for(int i = 1;i < size - 1; i++) {
				temp = temp.getNext();
			}
			temp.setNext(null);
			size--;
		}
	}

	// method to check list is empty or not
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		else
			return false;
	}

	// method to get size of list
	public int getSize() {
		return size;
	}

	// method to search particular data node
	public void search(int data) {
		int nodePos = 1;
		Node temp;
		if(isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			temp = head ;
			while(temp != null) {
				if(temp.getData() == data) {
					System.out.println("Data " + data + " is present at node no " + nodePos);
					break;
				}
				nodePos++;
				temp = temp.getNext();
			}
			if(temp == null) {
				System.out.println("Data is not present in the list");
			}
		}
	}

	// method to display nodes
	public void display() {
		Node temp;
		if(isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			temp = head;
			while (temp.getNext() != null) { // prints node data till next becomes zero
				System.out.print(temp.getData());
				if (temp.getData() != 0) {
					System.out.print("->");
				}
				temp = temp.getNext();
			}
			System.out.println(temp.getData());
			System.out.println("number of nodes in linkedlist are " + getSize());
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(56);
		list.append(30);
		list.append(70);

		list.insertAfterGivenData(30,40);		
		list.display();
	}
}
