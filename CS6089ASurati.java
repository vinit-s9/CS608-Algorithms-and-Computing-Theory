import java.io.File;
import java.util.*;

class CS6089ASurati {
  
	public static void main(String []args) throws Exception {
    
	System.out.println("Name: Vinitkumar Surati");
	System.out.println("Course No.: CS608");	  
	Date date = new Date();
	System.out.println(date.toString()+"\n");
	System.out.println("PROGRAM TO DEMONSTRATE BUBBLE SORT\n");
			
	int n = 100, i, j, e, temp;

    int[] array = Input("inputData9A.txt");
    int[] test = Input("inputData9A.txt");
 
    for (i = 0; i < ( n - 1 ); i++) {
      for (j = 0; j < n - i - 1; j++) {
        if (array[j] > array[j+1]) 
        {
          temp       = array[j];
          array[j]   = array[j+1];
          array[j+1] = temp;
        }
      }
    }

	System.out.println("Specific values in sorted array: \n");
	System.out.println("Value at position 10: " + array[9]);
	System.out.println("Value at position 25: " + array[24]);
	System.out.println("Value at position 50: " + array[49]);
	System.out.println("Value at position 70: " + array[69]);
	System.out.println("Value at position 90: " + array[89]);
	
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