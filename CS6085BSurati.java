import java.util.*;
import java.text.*;
import java.io.*;

class CS6085BSurati {
	
	static Lab5BTMethods one = new Lab5BTMethods();
	static int elements[] ;
	static int temp = 0;
    static int count=0;
	static int levelWithMaxNodes = -1;
    static PrintWriter pw;
	
	public static void main(String[] args) throws Exception {

		System.out.println("Name: Vinitkumar Surati");
	    System.out.println("Course No.: CS608");	  
	    Date date = new Date();
	    System.out.println(date.toString()+"\n");
	    System.out.println("PROGRAM TO DEMONSTRATE BINARY TREES");
		
		one.createBinaryTree();
		elements = new int[numberOfNodes(one.root)];
		System.out.println();
		System.out.println("Binary Tree Pre-order Traversal Output: ");
		one.preOrder(one.root);
		System.out.println();
		System.out.println("\nHeight of the binary tree is "+one.height(one.root));
		System.out.print("\nLevel order of the binary tree: ");
		one.displayTree(one.root);
		System.out.println("\n\nNumber of nodes in the binary tree are " + numberOfNodes(one.root));
		largest(one.root);
		System.out.println("\nLargest element in the binary tree is " + temp + "\n");
		sumOfElements(one.root);
		searchFor(one.root);
		levelWithMaxNodes(one.root);
	}
	static int numberOfNodes(Lab5BTNode root){
		if(root == null)
			return 0;
		else 
			return(numberOfNodes(root.right) + numberOfNodes(root.left) + 1);
	}
	
	static void largest(Lab5BTNode root){
		
		if(root!=null)
		{
			elements[count++] = root.element;
			largest(root.left);
			largest(root.right);
		}
		for (int i =0; i<elements.length; i++) {
			if(elements[i]>temp){
				temp = elements[i];
			}
		}

	}
	
	static void sumOfElements(Lab5BTNode root) {
		
		int sum=0;
		
			for(int i=0; i<elements.length;i++)
			{
				sum+=elements[i];
			}
			System.out.println("The sum of elements in this binary tree is " + sum + "\n");
		
	}
	
	static void searchFor(Lab5BTNode root) {
	
	for(int i=0;i<elements.length;i++) {
		if(elements[i]==50) {
			System.out.println("Element '50' found in this binary tree!\n");
		}	
	}
	
	System.out.println("Element '50' not found in this binary tree!\n");
	
	}
	
	static void levelWithMaxNodes(Lab5BTNode root) throws Exception
	{
		File f = new File("temp.txt");
		pw = new PrintWriter("temp.txt");
		boolean b1 = f.createNewFile();
		if(!b1){
			for(int i = 0 ; i < (one.height(root)); i++)
			{
				printElementsOnALevel(one.root,i);
				pw.println();
			}
			pw.flush(); 
			pw.close();
		}
		
		boolean b2 = f.exists();

		if(b2)
		{
			Scanner s = new Scanner(f);
			int count = 0;
			String l0="",l1="",l2="",l3="",l4="",l5="",l6="",l7 = "",l8 = "",l9 = "",l10 = "";
			while (s.hasNextLine())
			{
				if(count==0)
					l0 = s.nextLine();
				if(count==1)
					l1 = s.nextLine();
				if(count==2)
					l2 = s.nextLine();
				if(count==3)
					l3 = s.nextLine();
				if(count==4)
					l4 = s.nextLine();
				if(count==5)
					l5 = s.nextLine();
				if(count==6)
					l6 = s.nextLine();
				if(count==7)
					l7 = s.nextLine();
				count++;
			}
			StringTokenizer token0 = new StringTokenizer(l0," ");
			int one = token0.countTokens();

			StringTokenizer token1 = new StringTokenizer(l1," ");
			int two = token1.countTokens();

			StringTokenizer token2 = new StringTokenizer(l2," ");
			int three = token2.countTokens();

			StringTokenizer token3 = new StringTokenizer(l3," ");
			int four = token3.countTokens();

			StringTokenizer token4 = new StringTokenizer(l4," ");
			int five = token4.countTokens();

			StringTokenizer token5 = new StringTokenizer(l5," ");
			int six = token5.countTokens();

			StringTokenizer token6 = new StringTokenizer(l6," ");
			int seven = token6.countTokens();

			StringTokenizer token7 = new StringTokenizer(l7," ");
			int eight = token7.countTokens();

			int temp[] = {one, two, three, four, five, six, seven, eight};
				
				int max = temp[0]; 

    	for(int i=1;i < temp.length;i++)
    	{ 
      		if(temp[i] > max)
      		{ 
         		max = temp[i]; 
         		
			}
		}
		
		System.out.println("There are "+max+" nodes at most in any level.\n" );
		System.out.println("The levels containing maximum nodes are printed below: ");
		
				if(max == one)
					System.out.println(l0);
				if(max == two)
					System.out.println(l1);
				if(max == three)
					System.out.println(l2);
				if(max == four)
					System.out.println(l3);
				if(max == five)
					System.out.println(l4);
				if(max == six)
					System.out.println(l5);
				if(max == seven)
					System.out.println(l6);
				if(max == eight)
					System.out.println(l7);
			f.delete();
		}

	}
	
	static void printElementsOnALevel(Lab5BTNode root, int lev)throws Exception
	{
		if(root == null) return;
		if(lev == 0) pw.print(root.element + " ");
		else if(lev>0){
			printElementsOnALevel(root.left, lev-1);
			printElementsOnALevel(root.right, lev-1);
		}
	}
}