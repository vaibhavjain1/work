package noUse;


public class MakeMytrip {

	class LinkedList{
		int data;
		LinkedList next;
		public LinkedList(int dataTObeEntered) {
			this.data =  dataTObeEntered;
			this.next=null;
		}
	}
	
	LinkedList head;
	
	public void add(int dataTobEnterd){
		addNode(dataTobEnterd);
	}
	
	public void addNode(int dataTobeEntered){
		if(head==null){
			head = new LinkedList(dataTobeEntered);
		} else{
			LinkedList temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			LinkedList newnode = new LinkedList(dataTobeEntered);
			temp.next = newnode;
		}
	}
	
	public void reverseLinkedList(){
		LinkedList prev = null;
		LinkedList nextnode = null;
		LinkedList curr = head;
		while(curr!=null){
			nextnode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextnode;
		}
		head = prev;
	}
	
	public void printLinkedList(){
		LinkedList temp = head;
		while (temp!=null) {
			System.out.println(temp.data+"-->");
			temp=temp.next;
		}
		
	}
	
	public static void main(String[] args) {
		MakeMytrip obj = new MakeMytrip();
		obj.add(10);
		obj.add(20);
		obj.add(30);
		obj.add(40);
		obj.reverseLinkedList();
		obj.printLinkedList();
	}

}
