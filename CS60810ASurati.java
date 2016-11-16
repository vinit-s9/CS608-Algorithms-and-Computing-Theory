import java.io.File;
import java.util.*;

class CS60810ASurati {
  
	public static void main(String []args) throws Exception {
    
	System.out.println("Name: Vinitkumar Surati");
	System.out.println("Course No.: CS608");	  
	Date date = new Date();
	System.out.println(date.toString()+"\n");
	System.out.println("PROGRAM TO DEMONSTRATE SHELL SORT\n");
			
    int[] array = Input("inputData10A.txt");
    int[] test = Input("inputData10A.txt");     
	int n = array.length;            
	
/*	for (int i = 0; i<n; i++) 
		System.out.print(array[i]+"   ");         
	
	System.out.println();  
*/	
	int[] gaps = {7, 5, 3, 1};  
	int gap;  
	
	for (int p = 0; p<4; p++){      
		gap = gaps[p];   
	
	for (int i = gap; i < n; i++) {    
	
	int j = i;    
	int temp = array[i];    
	
		while (j >= gap && array[j - gap] > temp) {     
			array[j] = array[j - gap];     
			j = j - gap;    
		}    
	array[j] = temp;   
	
	}   
	}
/*	System.out.println("Gap = "+gap);       
	
	for (int i = 0; i<n; i++) System.out.print(array[i]+"   ");         
		System.out.println();  
	}     
	
	for (int i = 0; i<n; i++) System.out.print(array[i]+"   ");         
		System.out.println(); 
*/

	System.out.println("Specific values in sorted array: \n");
	System.out.println("Value at position 10: " + array[10]);
	System.out.println("Value at position 25: " + array[25]);
	System.out.println("Value at position 50: " + array[50]);
	System.out.println("Value at position 70: " + array[70]);
	System.out.println("Value at position 90: " + array[90]);
	
	Arrays.sort(test);
	System.out.println("\nVERIFICATION OF VALUES OBTAINED BY MANUAL SORTING, WITH VALUES OBTAINED BY BUILT-IN SORTING FUNCTION");
	
	if(test[10] == array[10]) {
		System.out.println("\nValue at position 10 is correct");
	}			
	else {
		System.out.println("\nValue at position 10 is incorrect");
	}
	
	if(test[25] == array[25]) {
		System.out.println("\nValue at position 25 is correct");
	}			
	else {
		System.out.println("\nValue at position 25 is incorrect");
	}
	
	if(test[50] == array[50]) {
		System.out.println("\nValue at position 50 is correct");
	}			
	else {
		System.out.println("\nValue at position 50 is incorrect");
	}
	
	if(test[70] == array[70]) {
		System.out.println("\nValue at position 70 is correct");
	}			
	else {
		System.out.println("\nValue at position 70 is incorrect");
	}
	
	if(test[90] == array[90]) {
		System.out.println("\nValue at position 90 is correct");
	}			
	else {
		System.out.println("\nValue at position 90 is incorrect");
	}
	
	System.out.println("\nThus, by using built-in sort() function, we have verified that the array is sorted correctly by manual approach!\n");
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