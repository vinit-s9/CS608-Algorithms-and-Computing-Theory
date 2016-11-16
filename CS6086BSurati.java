import java.util.*;
import java.text.*;
import java.io.*;;
 
/* Class BSTNode */ 
class BSTNode 
{

    BSTNode left;
    int element;
    BSTNode right;

    /* Constructor */
    public BSTNode() {}

    /* Constructor */
    public BSTNode(int n) {
        left = null;
        element = n;
        right = null;
    }
}

/* Creating a BST */
class BSTExample {
    BSTNode root;
    BSTExample() {}

    public void insertStart(int element) {
        root = insert(root, element);     
    }

    BSTNode insert(BSTNode node, int element) {
        if (node == null)
            node = new BSTNode(element);
        else {
            if (element <= node.element)
                node.left = insert(node.left, element);
            else
                node.right = insert(node.right, element);
        }
        return node;
    }

	//INORDER TRAVERSAL
    public void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.element + " ");
            inOrder(node.right);
        }
    }

	//SEARCH FUNCTION
    static boolean search(BSTNode node, int key){        
   	 
   	 if(node==null) 
   		 return false;         
   	 if(node.element == key) 
   		 return true;         
   	 else {              
   	 if(key < node.element) 
   		 return search(node.left, key);             
   	 else 
   		 return search(node.right, key);         
   	 }     
   	 }
    
	//PRINT HEIGHT
    public int height(BSTNode node) {
        if (node == null) return -1;
        else {
            int tempLeft = height(node.left);
            int tempRight = height(node.right);
            if (tempLeft < tempRight) return tempRight + 1;
            else return tempLeft + 1;

        }
    }
    
	//PRINT LARGEST ELEMENT
    public int largest(BSTNode node) {
        if (node == null)
            return -1;
        while (node.right != null) {
            node = node.right;
        }
        return node.element;
    }
    
	//PRINT NUMBER OF NODES
    public int numberOfNodes(BSTNode root) {
        if (root == null)
            return 0;
        else
            return (numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
    }

	//LEVEL ORDER
    public void printElementsOnALevel(BSTNode node, int level){
        if (node == null)
            return;
        if (level == 0)
           System.out.print(node.element + " ");
        else if (level > 0) {
           printElementsOnALevel(node.left, level - 1);
           printElementsOnALevel(node.right, level - 1);
       }
    }
}
 
 /* Class AVLNode */
 class AVLNode
 {
     AVLNode left, right;
     int data;
     int height;
 
     /* Constructor */
     public AVLNode()
     {
         left = null;
         right = null;
         data = 0;
         height = 0;
     }
     /* Constructor */
     public AVLNode(int n)
     {
         left = null;
         right = null;
         data = n;
         height = 0;
     }     
 }
 
 /* Class AVLTree */
 class AVLTree
 {
      AVLNode root;     
 
     /* Constructor */
     public AVLTree()
     {
         root = null;
     }
     //CHECK FOR EMPTY TREE
     public boolean isEmpty()
     {
         return root == null;
     }
     
	 //MAKES TREE EMPTY
     public void makeEmpty()
     {
         root = null;
     }
     //INSERT DATA
     public void insert(int data)
     {
         root = insert(data, root);
     }
     //PRINT HEIGHT
     public int height(){
        return height(root);
     }
     private int height(AVLNode t )
     {
         return t == null ? -1 : t.height;
     }
     //MAXIMUM FUNCTION
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     //INSERT DATA IN AVL
     private AVLNode insert(int x, AVLNode t)
     {
         if (t == null)
             t = new AVLNode(x);
         else if (x < t.data)
         {
             t.left = insert( x, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x < t.left.data )
                     t = singleLeftRotation( t );
                 else
                     t = doubleLeftRotation( t );
         }
         else if( x > t.data )
         {
             t.right = insert( x, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x > t.right.data)
                     t = singleRightRotation( t );
                 else
                     t = doubleRightRotation( t );
         }
         else
           ;
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }

	 //SINGLE ROTATIONS
	 
     private AVLNode singleLeftRotation(AVLNode a2)
     {
         AVLNode a1 = a2.left;
         a2.left = a1.right;
         a1.right = a2;
         a2.height = max( height( a2.left ), height( a2.right ) ) + 1;
         a1.height = max( height( a1.left ), a2.height ) + 1;
         return a1;
     }
 
     private AVLNode singleRightRotation(AVLNode a1)
     {
         AVLNode a2 = a1.right;
         a1.right = a2.left;
         a2.left = a1;
         a1.height = max( height( a1.left ), height( a1.right ) ) + 1;
         a2.height = max( height( a2.right ), a1.height ) + 1;
         return a2;
     }
    
	//DOUBLE ROTATIONS
	
     private AVLNode doubleLeftRotation(AVLNode a3)
     {
         a3.left = singleRightRotation( a3.left );
         return singleLeftRotation( a3 );
     }
         
     private AVLNode doubleRightRotation(AVLNode a1)
     {
         a1.right = singleLeftRotation( a1.right );
         return singleRightRotation( a1 );
     }    
     private int countNodes(AVLNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     //SEARCH FUNCTION
     public boolean search(int val)
     {
         return search(root, val);
     }
     
     private boolean search(AVLNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.data;
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     //INORDER TRAVERSAL
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(AVLNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.data +" ");
             inorder(r.right);
         }
     }
	 
	 //PRINT LEVEL ORDER
     public void levelOrder(){
        for (int i = 0; i <= height(root); i++) {
            System.out.println();
            printElementsOnALevel(root, i);
        }
    
     } 
	 
     private void printElementsOnALevel(AVLNode node, int level){
        if (node == null)
            return;
        if (level == 0)
           System.out.print(node.data + " ");
        else if (level > 0) {
           printElementsOnALevel(node.left, level - 1);
           printElementsOnALevel(node.right, level - 1);
       }
     } 
	 
	 //PRINT LARGEST ELEMENT
     public int largest()
     {
        return largest(root);
     } 
     private int largest(AVLNode node) {
        if (node == null)
            return -1;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
     }  
 }

 public class CS6086BSurati
 {
     public static void main(String[] args)throws Exception
    {            
        System.out.println("Name: Vinitkumar Surati");
		System.out.println("Course No.: CS608");	  
		Date date = new Date();
		System.out.println(date.toString()+"\n");
		System.out.println("PROGRAM TO DEMONSTRATE BINARY SEARCH TREES AND AVL TREES");
        
		//BST TREE
		System.out.println("\n1) PROCESSING A BINARY SEARCH TREE");
		
        BSTExample one = new BSTExample();
		int [] elements = Input("BSTData.txt");
		
        long start = System.nanoTime();
        for (int i = 0; i < elements.length; i++)
            one.insertStart(elements[i]);
        long end = System.nanoTime();
        long totalTime1 = end-start;
        System.out.println("\nBST tree formation time: " + totalTime1 + " ns");

        System.out.print("\nInorder traversal: ");
        one.inOrder(one.root);

        System.out.print("\n\nHeight: " + one.height(one.root));

        System.out.print("\n\nLevel order: ");
        for (int i = 0; i <= one.height(one.root); i++) {
            System.out.println();
            one.printElementsOnALevel(one.root, i);
        }

        System.out.print("\n\nLargest element: " + one.largest(one.root) + "\n");
		
		//AVL TREE
        AVLTree avl = new AVLTree();
		
        start = System.nanoTime();
        for (int i : elements) {
            avl.insert(i);
        }
        System.out.println("\n2) PROCESSING AN AVL TREE");
        end = System.nanoTime();
        totalTime1 = end-start;
        
		System.out.println("\nAVL tree formation time: " + totalTime1 + " ns");
        
		System.out.print("\nInorder traversal: ");
        avl.inorder();

        System.out.print("\n\nHeight: " + avl.height());

        System.out.print("\n\nLevel order: ");
        avl.levelOrder();

        System.out.print("\n\nLargest element: " + avl.largest());
        
		//SEARCH
        Scanner sc = new Scanner(System.in);
        int in=-1;
        long totalTime2;
        
		System.out.print("\n\n3) SEARCH FOR AN ELEMENT IN BOTH TREES");
		System.out.println("\n\n(YOU CAN ENTER 0 ANYTIME TO EXIT!)");

		while (in!=0) {
        	System.out.print("\nEnter an element for a look-up: ");
            in = sc.nextInt();
            if (in == 0) {
                System.out.println("\nEnd");   
				break;
            }
            start = System.nanoTime();
            System.out.println("\nElement found = " + avl.search(in));
            end = System.nanoTime();
            totalTime2 = end-start;
            
			System.out.println("\nAVL tree search time: " + totalTime2 + " ns");
            start = System.nanoTime();
            one.search(one.root, in);
            end = System.nanoTime();
            totalTime2 = end-start;
            
			System.out.println("BST tree search time: " + totalTime2 + " ns");

        }

    }

    public static int[] Input(String filename) throws Exception{
        int[] in;
        File f1 = new File(filename);
        Scanner s = new Scanner(f1);
        ArrayList < Integer > a = new ArrayList < Integer > ();
        while (s.hasNextInt()) {
            a.add(s.nextInt());
        }
        in = new int[a.size()];
        for (int i = 0; i < in.length; i++) {
            in[i] = a.get(i);
        }
        return in;
    }
}