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
class BST {
    BSTNode root;
    BST() {}

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
	   
 }

/* Class CBSTree */
class CBSTree   
{
    //NUMBER OF CHILDREN FOR EACH NODE
    private static final int d = 2;
    private int size;
    private int[] cbsArray;
    private HashSet set;
 
    public CBSTree(int capacity)
    {
        size = 0;
        cbsArray = new int[capacity + 1];
        Arrays.fill(cbsArray, -1);
    }
 
    //SUBSCRIPT OF PARENT OF I
    private int parent(int i) 
    {
        return (i - 1)/d;
    }
 
    //SUBSCRIPT OF I
    private int kthChild(int i, int k) 
    {
        return d * i + k;
    }
 
    //INSERT ELEMENT
    public void insert(int x)
    {
        cbsArray[size++] = x;
        pushUp(size - 1);
    }
	
    //HEIGHT
    public int getHeight()
    {       
        return (int)(Math.log(size) / Math.log(2));
    }
 
    //SEARCH ELEMENT 
    public boolean search(int searchElement)
    {
        return set.contains(searchElement);
    }

    //PUSH ELEMENT UP
    private void pushUp(int childSubscript)
    {
        int tmp = cbsArray[childSubscript];    
        while (childSubscript > 0 && tmp < cbsArray[parent(childSubscript)])
        {
            cbsArray[childSubscript] = cbsArray[ parent(childSubscript) ];
            childSubscript = parent(childSubscript);
        }                   
        cbsArray[childSubscript] = tmp;
    }
 
    //PULL ELEMENT DOWN
    private void pullDown(int subscript)
    {
        int child;
        int tmp = cbsArray[ subscript ];
        while (kthChild(subscript, 1) < size)
        {
            child = minChild(subscript);
            if (cbsArray[child] < tmp)
                cbsArray[subscript] = cbsArray[child];
            else
                break;
            subscript = child;
        }
        cbsArray[subscript] = tmp;
    }
 
    //SMALLEST CHILD
    private int minChild(int subscript) 
    {
        int minimum = kthChild(subscript, 1);
        int k = 2;
        int pos = kthChild(subscript, k);
        while ((k <= d) && (pos < size)) 
        {
            if (cbsArray[pos] < cbsArray[minimum]) 
                minimum = pos;
            pos = kthChild(subscript, k++);
        }    
        return minimum;
    }
    //HASHSET FUNCTION TO POPULATE SEARCH KEYS
    private void populateSet(int a[])
    {
        set = new HashSet(Arrays.asList(a));
        
    }
    public void populateSet()
    {
        populateSet(cbsArray);
    }
} 
 
 public class CS6087BSurati
 {
     public static void main(String[] args)throws Exception
    {            
        System.out.println("Name: Vinitkumar Surati");
		System.out.println("Course No.: CS608");	  
		Date date = new Date();
		System.out.println(date.toString()+"\n");
		System.out.println("PROGRAM TO DEMONSTRATE BINARY SEARCH TREES, AVL TREES AND CBS TREES");
        
        BST bst = new BST(); 
        AVLTree avl = new AVLTree();
        CBSTree cbs = new CBSTree(1000);
        
        int [] newElements = getInput("inputData7.txt");
        
        long start = System.nanoTime();
        for (int i : newElements) {
            bst.insertStart(i);
        }
        long end = System.nanoTime();
        long BSTMake = end-start;
		
		start = System.nanoTime();
        for (int i : newElements) {
            avl.insert(i);
        }
        end = System.nanoTime();
        long AVLMake = end-start;

        start = System.nanoTime();
        for (int i : newElements) {
            cbs.insert(i);
        }
        end = System.nanoTime();
        long CBSMake = end-start;

        //HEIGHTS
        System.out.println("\nHEIGHT OF THE TREES\n");
		
		System.out.print("BST Tree: ");
        System.out.println(bst.height(bst.root));

        System.out.print("AVL Tree: ");
        System.out.println(avl.height());

        System.out.print("CBS Tree: " );
        System.out.println(cbs.getHeight());
        

        //TREE FORMATION TIME
        System.out.println("\nTIME TAKEN TO FORM ALL THE TREES\n");
		
		System.out.println("BST Tree: " + BSTMake + " nanoseconds");
        
        System.out.println("AVL Tree: " + AVLMake + " nanoseconds");

        System.out.println("CBS Tree: " + CBSMake + " nanoseconds");

        //KEY SEARCH
        int searchKeys[] = {250,2504,2078,2158,3502,7138,6230,9661,1330,6136};
        ArrayList<Integer> keysFound= new ArrayList<Integer>();
        start = System.nanoTime();
        
        //AVL TREE
        for (int i = 0; i<searchKeys.length; i++)
        {
            boolean flag = avl.search(searchKeys[i]);
            if(flag) 
                keysFound.add(searchKeys[i]);
        }
        end = System.nanoTime();
        long AVLSearch = end-start;

        //CREATING ARRAY
        int numOfKeys[] = new int[keysFound.size()];
        for (int i = 0; i < numOfKeys.length; i++) 
        {
            numOfKeys[i] = keysFound.get(i);
        }
        keysFound.clear();

        //BST TREE
        start = System.nanoTime();
        for (int i = 0; i<searchKeys.length; i++)
        {
            boolean flag = bst.search(bst.root, searchKeys[i]);
            if(flag) 
                keysFound.add(searchKeys[i]);
        }
        end = System.nanoTime();
        long BSTSearch = end-start;
        keysFound.clear();

        //CBS TREE
        cbs.populateSet();
        start = System.nanoTime();
        for (int i = 0; i<searchKeys.length; i++)
        {
            boolean flag = cbs.search(searchKeys[i]);
            if(flag) 
                keysFound.add(searchKeys[i]);
        }
        end = System.nanoTime();
        long CBSSearch = end-start;
		
        //TIME TO SEARCH ALL KEYS
		System.out.println("\nTIME TAKEN TO SEARCH ALL KEYS IN THE TREES\n");
        
		System.out.println("BST trees : " + BSTSearch + " nanoseconds");
		System.out.print("Keys Found : ");
        for(int i = 0; i<numOfKeys.length; i++)
            System.out.print(numOfKeys[i] + " ");
        System.out.println("\n");
        
		System.out.println("AVL trees : " + AVLSearch + " nanoseconds");
		System.out.print("Keys Found : ");
        for(int i = 0; i<numOfKeys.length; i++)
            System.out.print(numOfKeys[i] + " ");
        System.out.println("\n");
        
		System.out.println("CBS trees : " + CBSSearch + " nanoseconds");
        System.out.print("Keys Found : ");
        for(int i = 0; i<numOfKeys.length; i++)
            System.out.print(numOfKeys[i] + " ");
        System.out.println("\n");
    }

    public static int[] getInput(String filename) throws Exception
    {
        int[] inputData;
        File f1 = new File(filename);
        Scanner filereader = new Scanner(f1);
        ArrayList < Integer > al = new ArrayList < Integer > ();
        while (filereader.hasNextInt()) {
            al.add(filereader.nextInt());
        }
        inputData = new int[al.size()];
        for (int i = 0; i < inputData.length; i++) {
            inputData[i] = al.get(i);
        }
        return inputData;
    }
}