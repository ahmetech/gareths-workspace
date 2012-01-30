package ListNode;

import java.util.Random;

public class ListNode {
	int data;
	ListNode next;
	public ListNode(int number){
		data=number;
		next=null;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public static void main(String[] args){
		/*Random numGenerator = new Random();
		int numHead=numGenerator.nextInt();
		ListNode head=new ListNode(numHead);
		ListNode g =new ListNode(numGenerator.nextInt());
		head.setNext(g);
		for(int i=0; i<9; i++){
			g.setNext(new ListNode(numGenerator.nextInt()));
			g.next.setNext(new ListNode(numGenerator.nextInt()));
		}
		ListNode head=new ListNode(0);
		ListNode g=new ListNode(1);
		head.setNext(g);
		makeListNode(g, 8);*/
		
		//Creates first ListNode
		ListNode head=new ListNode(0);
		head.setNext(new ListNode(1));
		head.next.setNext(new ListNode(2));
		head.next.next.setNext(new ListNode(3));
		head.next.next.next.setNext(new ListNode(4));
		head.next.next.next.next.setNext(new ListNode(5));
		head.next.next.next.next.next.setNext(new ListNode(6));
		//head.next.next.next.next.next.next.setNext(new ListNode(7));
		//head.next.next.next.next.next.next.next.setNext(new ListNode(8));
		//head.next.next.next.next.next.next.next.next.setNext(new ListNode(9));
		
		//Creates second ListNode
		ListNode head2=new ListNode(22);
		head2.setNext(new ListNode(37));
		head2.next.setNext(new ListNode(42));
		head2.next.next.setNext(new ListNode(12));
		head2.next.next.next.setNext(new ListNode(8));
		//head2.next.next.next.next.setNext(new ListNode(5));
		//head2.next.next.next.next.next.setNext(new ListNode(80));
		//head2.next.next.next.next.next.next.setNext(new ListNode(120));
		//head2.next.next.next.next.next.next.next.setNext(new ListNode(145));
		//head2.next.next.next.next.next.next.next.next.setNext(new ListNode(918));
		
		insert(head, 3, head2);
		
		int length=length(head);
		ListNode currentListNode=head;
		for(int i=0; i<length; i++){
			System.out.println(currentListNode.getData());
			ListNode tempListNode=currentListNode.getNext();
			currentListNode=tempListNode;
		}
		
	}
	
	/*public static void makeListNode(ListNode g, int number){
		while(number>0){
			g.setNext(new ListNode(g.getData()+1));
			g.next.setNext(new ListNode(g.next.getData()+1));
			number--;
			makeListNode(g.next, number);
		}
	}*/
	
	//Gets the data for the ListNode X away from the ListNode in parameter
	public static int getX(ListNode head, int pos){
		ListNode found=head;
		for(int i=0; i<pos; i++){
			if(i==0)found=head.getNext();
			else{
				found=found.getNext();
			}
		}
		return found.getData();
	}
	
	//Finds the Data of the ListNide at the location given(Must be the beginning of the ListNode)
	public static int findLoc(ListNode head, int loc){
		int total=0;
		ListNode currentListNode=head;
		while (!(total==loc)) {
			ListNode tempListNode=currentListNode.getNext();
			currentListNode=tempListNode;
			total++;
		}
		return currentListNode.getData();
	}
	
	//Returns the Node at the loc given
	public static ListNode findLocNode(ListNode head, int loc){
		int total=0;
		ListNode currentListNode=head;
		while (!(total==loc)) {
			ListNode tempListNode=currentListNode.getNext();
			currentListNode=tempListNode;
			total++;
		}
		return currentListNode;
	}
	
	//Finds the length of the ListNode
	public static int length(ListNode head){
		int total=1;
		ListNode currentListNode=head;
		while(!(currentListNode.getNext()==null)){
			ListNode tempListNode=currentListNode.getNext();
			currentListNode=tempListNode;
			total++;
		}
		return total;
	}
	
	//Returns the last Node in a ListNode
	public static ListNode findLastNode(ListNode head){
		ListNode currentListNode=head;
		while(!(currentListNode.getNext()==null)){
			ListNode tempListNode=currentListNode.getNext();
			currentListNode=tempListNode;
		}
		return currentListNode;
	}
	
	public static void insert(ListNode oldList, int  loc, ListNode newList){
		ListNode currentListNode=oldList;
		int numOfInsertion=findLoc(oldList, loc);
		while(!(currentListNode.getNext().getData()==numOfInsertion)){
			ListNode tempListNode=currentListNode.getNext();
			currentListNode=tempListNode;
		}
		ListNode pointAfterInsertion=currentListNode.getNext();
		currentListNode.setNext(newList);
		//final node in newList
		ListNode endOfONewList=findLastNode(newList);
		endOfONewList.setNext(pointAfterInsertion);
		
		
			
	}
}
