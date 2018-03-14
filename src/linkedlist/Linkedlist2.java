package linkedlist;


public class Linkedlist2<T> {
	private class Node{
		T data;
		Node next;
	}
	private Node head;
	private Node tail;
	public Linkedlist2() {
		head = null;
		tail = null;
	}
	public void addStart(T v) {
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
	public void addEnd(T v) {
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
	
	public void output() {
		for(Node i = head;i!=null;i=i.next) {
			System.out.print(i.data+" ");
		}System.out.println(" ");
	}
	public static void main(String[] args) {
		Linkedlist2<Integer> list = new Linkedlist2<>();
		list.output();
	}
}
