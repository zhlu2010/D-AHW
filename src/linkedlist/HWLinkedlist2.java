package linkedlist;

public class HWLinkedlist2 {
	private class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	public HWLinkedlist2() {
		head = null;
		tail = null;
	}
	public void addStart(int v) {
		if(head == null) {
			head = new Node();
			head.data = v;
			tail = head;
			tail.next = null;
		}else {
			Node temp = new Node();
			temp.data = v;
			temp.next = head;
			head = temp;
		}
	}
	public void addEnd(int v) {
		if(head == null) {
			head = new Node();
			head.data = v;
			tail = head;
			tail.next = null;
		}else {
			Node temp = new Node();
			temp.data = v;
			tail.next = temp;
			tail = temp;
			tail.next = null;
		}
	}
	public void removeStart() {
		if(head == null)
			return;
		else {
			head = head.next;
		}
	}
	public void removeEnd() {
		if(head == null) {
			return;
			}else if(head == tail){
				head = null;
				tail = null;
			}else {
				Node last2 = head;
				while(last2.next.next!=null) {
					last2 = last2.next;
			}
				tail = last2;
				tail.next = null;
		}
	}
	public void addFront(int start, int step, int end) {
		for(int i = start;i<=end;i+=step)
			addStart(i);
	}
	public void addBack(int start, int step, int end) {
		for(int i = start;i<=end;i+=step)
			addEnd(i);
	}
	public void removeFront(int m) {
		for(int i = 0;i<m;i++)
			removeStart();
	}
	public void removeBack(int m) {
		for(int i = 0;i<m;i++)
			removeEnd();
	}
	public void output() {
		for(Node i = head;i!=null;i=i.next) {
			System.out.print(i.data+" ");
		}System.out.println(" ");
	}
	public static void main(String[] args) {
		HWLinkedlist2 list = new HWLinkedlist2();
		list.addFront(1, 2, 10);
		list.addBack(5, 5, 25);
		list.output();
		list.removeFront(2);
		list.removeBack(2);
		list.output();
	}
}
