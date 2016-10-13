import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class CS6083ASurati  {  

	private static class Node     {       

		private int data;        

		private Node next;  

		public Node(int data, Node next)        {           

			this.data = data;           

			this.next = next;        
			}     
		}     

	private Node head;
	private static Scanner s2;
	private static Scanner s1;  

// Constructs an empty list      

	public CS6083ASurati()    {       
		head = null;    
		}    

// Returns true if the list is empty otherwise returns false        

	public boolean isEmpty()    {       
		return (head == null);    
		}    

// Inserts a new node in this list.  

	public void insertAtBeginning(int element)    {       
		head = new Node(element, head);    
		}	
	
// Adds a new node in the beginning of the list
	
	public static Node addLast(Node head, int x) {
	       // save the reference to the header so we can return it.
	       Node ret = head;

	       // check base case, header is null.
	       if (head == null) {
	           return new Node(x, null);
	       }

	       // loop until we find the end of the list
	       while ((head.next != null)) {
	           head = head.next;
	       }

	       // set the new node to the Object x, next will be null.
	       head.next = new Node(x, null);
	       return ret;
	   }
	
// Returns the last element in the list.  

	public int getLast()    {     
		if(head == null) {      
			System.out.println("Empty linked list");      
			throw new IndexOutOfBoundsException();     
			}
		return head.data;    
		}   

// Removes the first node in the list.  
	
	public int removeFirstNode()   {       
		int tmp = getLast();       
		head = head.next;       
		return tmp;    
		}    

// Empties linked list    
	public void clear()   {       
		head = null;    
		}  

// Returns the length of the linked list   

	public static int LLlength(Node head) {     
		int length = 0;     
		Node currentNode = head;    
		while(currentNode != null) {      
			length++;      
			currentNode = currentNode.next;     
			}     
		return length;    
		}
	
// Displays the linked list elements in reverse order       
	
	public static void displayReverse(Node head) {     
		if(head == null) {      
			System.out.println("Empty linked list");      
			throw new IndexOutOfBoundsException();     
			}
		Node currentNode = head;    
		while(currentNode != null) {      
			System.out.print(currentNode.data+"  ");      
			currentNode = currentNode.next;     
			}    
		}
	
// Displays the linked list elements    

	public static void display(Node head) {      
		if(head == null) { }      
		else {       
			Node currentNode = head;       
			display(currentNode.next);        
			System.out.print(currentNode.data+"  ");              
			}     
		}

// Searches for an element  	
	public static boolean searchFor(Node head, int element) {     
		if(head == null) {      
			System.out.println("Empty linked list");      
			throw new IndexOutOfBoundsException();     
			}
		Node currentNode = head; 
		boolean flag = false;
		while(currentNode != null) {      
			if(currentNode.data == element ) {
				flag = true;
	            break;
			}
			currentNode = currentNode.next;     
			}
		return flag;    
		}

// Prints first element in the linked list	
	public static void getFirstElement(Node head) {     
		if(head == null) {      
			System.out.println("Empty linked list");      
			throw new IndexOutOfBoundsException();     
			}
		Node currentNode = head;    
		while(currentNode.next != null) {            
			currentNode = currentNode.next;  
			}    
		System.out.println("First element is: " + currentNode.data);
		}
	
	
public static void main(String[] args) throws FileNotFoundException    {    
	
	System.out.println("Name: Vinitkumar Surati");
    System.out.println("Course No.: CS608");	  
    Date date = new Date();
    System.out.println(date.toString()+"\n");
    System.out.println("PROGRAM TO DEMONSTRATE A LINKED LIST"+"\n");

	CS6083ASurati list = new CS6083ASurati();
	
	File f = new File ("dataForLinkedList.txt");
	s1 = new Scanner (f);
	int count=0;
	int[] a = new int[20];
	int search=-9, last_elem=-9, first_elem=-9;
	while (count<4 && s1.hasNextLine()) {
		String sentence = s1.nextLine();
		s2 = new Scanner (sentence);
		int i=0;
		while(s2.hasNextInt() && count == 0) {
			a[i] = s2.nextInt();
			i++;
		}
		if (count == 0) {
			search = s1.nextInt();
		}
		if (count == 1) {
			first_elem = s1.nextInt();
		}
		if (count == 2) {
			last_elem = s1.nextInt();
		}
	count++;
	}
	
	for(int k=0; k<a.length;k++) {
	
		if(a[k]==0) {
			break;
		}
		list.insertAtBeginning(a[k]);
	}
	
	System.out.println("Original Linked List: ");
	display(list.head);
	
	System.out.println("\n\nSize of linked list is: " + LLlength(list.head));
	
	System.out.println("\nSearch element found? " + searchFor(list.head, search));
	
	System.out.println("\nLast Element is: " + list.getLast() + "\n");
	
	addLast(list.head, first_elem);
	System.out.println("Linked List after adding an element in beginning: ");
	display(list.head);
	
	list.insertAtBeginning(last_elem);
	System.out.println("\n\nLinked List after adding an element at last: ");
	display(list.head);	
	
	System.out.println("\n\nLinked List in reverse order: ");
	displayReverse(list.head);
	
	list.clear();
	System.out.println("\n\nLinked List after clearing: ");
	display(list.head);
	
	

}

}
   
