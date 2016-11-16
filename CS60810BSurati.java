import java.io.File;
import java.util.*;

class CS60810BSurati {
  
	public static void main(String []args) throws Exception {
    
	System.out.println("Name: Vinitkumar Surati");
	System.out.println("Course No.: CS608");	  
	Date date = new Date();
	System.out.println(date.toString()+"\n");
	System.out.println("PROGRAM TO DEMONSTRATE SHELL SORT\n");
			
    int[] array1 = Input("inputData10B.txt");
	int[] array2 = Input("inputData10B.txt");
	int[] array3 = Input("inputData10B.txt");
    int[] test = Input("inputData10B.txt");     
	int n = array1.length;            
	
/*	for (int i = 0; i<n; i++) 
		System.out.print(array1[i]+"   ");         
	
	System.out.println();  
*/	

	//GAP = RELATIVELY PRIME NUMBERS
	System.out.println("1) USING RELATIVELY PRIME NUMBERS AS GAPS\n");
	int pn =0;
    int num =0;
	
	
       String  primeNumbers = "";

       for (pn = 500; pn >= 1; pn--)         
       { 		  	  
          int counter=0; 	  
          for(num =pn; num>=1; num--)
	  {
             if(pn%num==0)
	     {
 		counter = counter + 1;
	     }
	  }
	  
	  if (counter ==2)
	  {
	     primeNumbers = primeNumbers + pn + " ";
	  }	
       }
	   
	String[] strings = primeNumbers.split(" ");
	int[] gaps1 = new int[strings.length];
	for (int j = 0; j < gaps1.length; j++) {
		gaps1[j] = Integer.parseInt(strings[j]);
		//System.out.println(gaps1[j]);
	}
	  
	int gap1;  
	
	long start = System.nanoTime();
	
	for (int p = 0; p<gaps1.length; p++){      
		gap1 = gaps1[p];   
	
	for (int i = gap1; i < n; i++) {    
	
	int j = i;    
	int temp = array1[i];    
	
		while (j >= gap1 && array1[j - gap1] > temp) {     
			array1[j] = array1[j - gap1];     
			j = j - gap1;    
		}    
	array1[j] = temp;   
	
	}   
	}
	
	//LAST STEP OF SHELL SORT
	for (int p = 0; p<1; p++){      
		gap1 = 1;   
	
	for (int i = gap1; i < n; i++) {    
	
	int j = i;    
	int temp = array1[i];    
	
		while (j >= gap1 && array1[j - gap1] > temp) {     
			array1[j] = array1[j - gap1];     
			j = j - gap1;    
		}    
	array1[j] = temp;   
	
	}   
	}
	long end = System.nanoTime();
	long pnTime = end-start;
	
/*	System.out.println("Gap = "+gap1);       
	
	for (int i = 0; i<n; i++) System.out.print(array1[i]+"   ");         
		System.out.println();  
	}     
	
	for (int i = 0; i<n; i++) System.out.print(array1[i]+"   ");         
		System.out.println(); 
*/

	System.out.println("Specific values in sorted array: \n");
	System.out.println("Value at position 100: " + array1[100]);
	System.out.println("Value at position 125: " + array1[125]);
	System.out.println("Value at position 250: " + array1[250]);
	System.out.println("Value at position 700: " + array1[700]);
	System.out.println("Value at position 900: " + array1[900]);
	
	Arrays.sort(test);
	System.out.println("\nVERIFICATION OF VALUES OBTAINED BY MANUAL SORTING, WITH VALUES OBTAINED BY BUILT-IN SORTING FUNCTION");
	
	if(test[100] == array1[100]) {
		System.out.println("\nValue at position 100 is correct");
	}			
	else {
		System.out.println("\nValue at position 100 is incorrect");
	}
	
	if(test[125] == array1[125]) {
		System.out.println("\nValue at position 125 is correct");
	}			
	else {
		System.out.println("\nValue at position 125 is incorrect");
	}
	
	if(test[250] == array1[250]) {
		System.out.println("\nValue at position 250 is correct");
	}			
	else {
		System.out.println("\nValue at position 250 is incorrect");
	}
	
	if(test[700] == array1[700]) {
		System.out.println("\nValue at position 700 is correct");
	}			
	else {
		System.out.println("\nValue at position 700 is incorrect");
	}
	
	if(test[900] == array1[900]) {
		System.out.println("\nValue at position 900 is correct");
	}			
	else {
		System.out.println("\nValue at position 900 is incorrect");
	}
 

	//GAP = HIBBARD'S SEQUENCE
	System.out.println("\n2) USING HIBBARD'S SEQUENCE AS GAPS\n");
		int h;
		int temp;
		int h2;

		int gap2 = 1;
		int k = 0;
		
		start = System.nanoTime();
		
		while (gap2 <= array2.length+1)
		{
			for (h2 = gap2; h2<=array2.length-1;h2++)
			{
				temp = array2[h2];
				h = h2;
				while ( h>=gap2 && array2[h-gap2]>temp)
				{
					array2[h] = array2[h-gap2];
					h = h - gap2;
				}
				array2[h]=temp;
			}
			k = k + 1; 
			gap2 = (int)(java.lang.Math.pow(2,k))-(int)1;

		}
		
		end = System.nanoTime();
		long hTime = end-start;
		
	/*	System.out.println("Required output is");
		for(int l=0; l < array2.length ; l++)
		{
			System.out.print(array2[l]+" ");
		}
	*/

	System.out.println("Specific values in sorted array: \n");
	System.out.println("Value at position 100: " + array2[100]);
	System.out.println("Value at position 125: " + array2[125]);
	System.out.println("Value at position 250: " + array2[250]);
	System.out.println("Value at position 700: " + array2[700]);
	System.out.println("Value at position 900: " + array2[900]);
	
	Arrays.sort(test);
	System.out.println("\nVERIFICATION OF VALUES OBTAINED BY MANUAL SORTING, WITH VALUES OBTAINED BY BUILT-IN SORTING FUNCTION");
	
	if(test[100] == array2[100]) {
		System.out.println("\nValue at position 100 is correct");
	}			
	else {
		System.out.println("\nValue at position 100 is incorrect");
	}
	
	if(test[125] == array2[125]) {
		System.out.println("\nValue at position 125 is correct");
	}			
	else {
		System.out.println("\nValue at position 125 is incorrect");
	}
	
	if(test[250] == array2[250]) {
		System.out.println("\nValue at position 250 is correct");
	}			
	else {
		System.out.println("\nValue at position 250 is incorrect");
	}
	
	if(test[700] == array2[700]) {
		System.out.println("\nValue at position 700 is correct");
	}			
	else {
		System.out.println("\nValue at position 700 is incorrect");
	}
	
	if(test[900] == array2[900]) {
		System.out.println("\nValue at position 900 is correct");
	}			
	else {
		System.out.println("\nValue at position 900 is incorrect");
	}
	
 	
	//POWERS OF 2
	System.out.println("\n3) USING POWERS of 2 AS GAPS\n");
		int p;
		int temp2;
		int p2;

		int gap3 = 1;
		int z = 0;
		
		start = System.nanoTime();
		
		while (gap3 <= array3.length+1)
		{
			for (p2 = gap3; p2<=array3.length-1;p2++)
			{
				temp2 = array3[p2];
				p = p2;
				while ( p>=gap3 && array3[p-gap3]>temp2)
				{
					array3[p] = array3[p-gap3];
					p = p - gap3;
				}
				array3[p]=temp2;
			}
			z = z + 1; 
			gap3 = (int)(java.lang.Math.pow(2,z));

		}
		
		end = System.nanoTime();
		long p2Time = end-start;
		
	/*	System.out.println("Required output is");
		for(int l=0; l < array3.length ; l++)
		{
			System.out.print(array3[l]+" ");
		}
	*/

	System.out.println("Specific values in sorted array: \n");
	System.out.println("Value at position 100: " + array3[100]);
	System.out.println("Value at position 125: " + array3[125]);
	System.out.println("Value at position 250: " + array3[250]);
	System.out.println("Value at position 700: " + array3[700]);
	System.out.println("Value at position 900: " + array3[900]);
	
	Arrays.sort(test);
	System.out.println("\nVERIFICATION OF VALUES OBTAINED BY MANUAL SORTING, WITH VALUES OBTAINED BY BUILT-IN SORTING FUNCTION");
	
	if(test[100] == array3[100]) {
		System.out.println("\nValue at position 100 is correct");
	}			
	else {
		System.out.println("\nValue at position 100 is incorrect");
	}
	
	if(test[125] == array3[125]) {
		System.out.println("\nValue at position 125 is correct");
	}			
	else {
		System.out.println("\nValue at position 125 is incorrect");
	}
	
	if(test[250] == array3[250]) {
		System.out.println("\nValue at position 250 is correct");
	}			
	else {
		System.out.println("\nValue at position 250 is incorrect");
	}
	
	if(test[700] == array3[700]) {
		System.out.println("\nValue at position 700 is correct");
	}			
	else {
		System.out.println("\nValue at position 700 is incorrect");
	}
	
	if(test[900] == array3[900]) {
		System.out.println("\nValue at position 900 is correct");
	}			
	else {
		System.out.println("\nValue at position 900 is incorrect");
	}
	
	System.out.println("\nThus, by using built-in sort() function, we have verified that the array is sorted correctly by manual approach!\n");
 	
	//SORTING TIMES
	System.out.println("\nTIME TAKEN FOR SHELL SORT ALGORITHM");
	System.out.println("\n->Using relatively prime numbers as gaps: " + pnTime + " ns");
	System.out.println("\n->Using hibbard's sequence as gaps: " + hTime + " ns");
	System.out.println("\n->Using powers of 2 as gaps: " + p2Time + " ns");
	
	}
	
	public static int[] Input(String filename) throws Exception
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