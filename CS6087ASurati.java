import java.io.*;
import java.util.*;
import java.text.*;
class CBTNode {

    CBTNode left;
    int element;
    CBTNode right;

    /* Constructor */
    public CBTNode() {}

    /* Constructor */
    public CBTNode(int n) {
        left = null;
        element = n;
        right = null;
    }
}

/* Creating a CBT */
class CBT {
	
    static int[] input;
    static CBTNode root;
    CBT(String filename) throws Exception {
        File f1 = new File(filename);
        Scanner filereader = new Scanner(f1);
        ArrayList < Integer > al = new ArrayList < Integer > ();
        while (filereader.hasNextInt()) {
            al.add(filereader.nextInt());
        }
        input = new int[al.size()];
        for (int i = 0; i < input.length; i++) {
            input[i] = al.get(i);
        }

    }

    public void insertData(int element) {
        root = insert(root, element);     
    }

    static CBTNode insert(CBTNode node, int element) {
        if (node == null)
            node = new CBTNode(element);
        else {
            if (element <= node.element)
                node.left = insert(node.left, element);
            else
                node.right = insert(node.right, element);
        }
        return node;
    }

    static boolean search(CBTNode node, int key) {
        if (node == null)
            return false;
        if (node.element == key)
            return true;
        else {
            if (key < node.element)
                return search(node.left, key);
            else
                return search(node.right, key);
        }
    }
    static int height(CBTNode node) {
        return (int)(Math.log(1000) / Math.log(2));
    }

    static int largest(CBTNode node) {
        if (node == null)
            return -1;
        while (node.right != null) {
            node = node.right;
        }
        return node.element;
    }
    static int numberOfNodes(CBTNode root) {
        if (root == null)
            return 0;
        else
            return (numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
    }
    
}

public class CS6087ASurati {
    public static void main(String[] args) throws Exception {
		System.out.println("Name: Vinitkumar Surati");
		System.out.println("Course No.: CS608");	  
		Date date = new Date();
		System.out.println(date.toString()+"\n");
		System.out.println("PROGRAM TO DEMONSTRATE COMPLETE BINARY TREES");
	
        CBT tree = new CBT("inputData7.txt");
		
		for (int i = 0; i < tree.input.length; i++)
            tree.insertData(tree.input[i]);
        
		System.out.print("\nHeight: " + tree.height(tree.root));
        
        System.out.println("\n\nNumber of nodes: " + tree.numberOfNodes(tree.root));
		
        System.out.println("\nLargest element: "+ tree.largest(tree.root));     
    
        Scanner s = new Scanner(System.in);
	int in=-1;
	System.out.print("\nSEARCH FOR AN ELEMENT");
	System.out.println("\n(YOU CAN ENTER 0 ANYTIME TO EXIT!)");
	while (in!=0) {
         System.out.print("\nEnter an element for a look-up: ");
         in = s.nextInt();
         if (in == 0) {
        	 System.out.println("\nEnd");   
        	 break;
         }

         System.out.println("Element found = " + tree.search(tree.root, in));

}
    }
}