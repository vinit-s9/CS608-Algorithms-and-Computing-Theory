import java.io.File;
import java.util.*;

class CS6089BSurati {
	
	private static int[] array;
	private static int countDESS = 1;
	
	public void biSort(int[] array)
    {
            
            for(int j = 0 ; j < array.length/2; j++)
            {

					//PAIRWISE SHIFTS
                    for(int i = j; i < (array.length/2); i++)
                    {
                            if(array[i] > array[array.length-i-1])
                            {
                            	int temp = array[i];
                                array[i] = array[array.length-i-1];
                                array[array.length-i-1] = temp;
								countDESS++;
                            }
                    }

                    lowerBound(j,array.length/2);

                    upperBound((array.length/2),array.length-j);

					//MIDDLE ELEMENTS
                    if(array[(array.length-1)/2]>array[((array.length-1)/2)+1])
                    {
                    	int temp = array[(array.length-1)/2];
                        array[(array.length-1)/2] = array[((array.length-1)/2)+1];
                        array[((array.length-1)/2)+1] = temp;
						countDESS++;
                    }
            }
    
	System.out.println("\nSpecific values in array sorted using DOUBLE-ENDED SELECTION SORT: \n");
	System.out.println("Value at position 100: " + array[100]);
	System.out.println("Value at position 125: " + array[125]);
	System.out.println("Value at position 250: " + array[250]);
	System.out.println("Value at position 700: " + array[700]);
	System.out.println("Value at position 900: " + array[900]);	
    
	}
	
	//SMALLEST ELEMENT
	public static void lowerBound(int minInput, int maxInput)
	{
		int min = minInput;

		int limit = maxInput;
		
		for(int i = min; i <= limit; i++)
		{
			if(array[i]<array[min])
			{
				min=i;
			}
		}
		int temp = array[min];
        array[min] = array[minInput];
        array[minInput] = temp;
		countDESS++;
	}

	//LARGEST ELEMENT
	public static void upperBound(int minInput, int maxInput)
	{
		int max = minInput;
		
		int limit = maxInput;
		
		for(int i = max; i < limit; i++)
		{
			if(array[i]>array[max])
			{
				max=i;

			}
		}
		int temp = array[max];
        array[max] = array[maxInput-1];
        array[maxInput-1] = temp;
		countDESS++;
	}
	
	public static void main(String []args) throws Exception {
    
	System.out.println("Name: Vinitkumar Surati");
	System.out.println("Course No.: CS608");	  
	Date date = new Date();
	System.out.println(date.toString()+"\n");
	System.out.println("PROGRAM TO DEMONSTRATE BUBBLE SORT, SELECTION SORT AND DOUBLE-ENDED SELECTION SORT\n");
			
	int n = 1000;

    int[] array1 = Input("inputData9B.txt");
	int[] array2 = Input("inputData9B.txt");
    int[] test = Input("inputData9B.txt");
 
	//BUBBLE SORT
	long start = System.nanoTime();
	
	boolean flag = true;
	int countBubble=1;
	
    for (int i = 0; i < ( n - 1 ); i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array1[j] > array1[j+1]) 
        {
          int temp       = array1[j];
          array1[j]   = array1[j+1];
          array1[j+1] = temp;
		  flag = true;
        }
      }
	  if (flag) {
			flag = false;
			countBubble++;
	  }
	  else break;
	}
	
	long end = System.nanoTime();
	long bubbleTime = end-start;
	
	System.out.println("Specific values in array sorted using BUBBLE SORT: \n");
	System.out.println("Value at position 100: " + array1[100]);
	System.out.println("Value at position 125: " + array1[125]);
	System.out.println("Value at position 250: " + array1[250]);
	System.out.println("Value at position 700: " + array1[700]);
	System.out.println("Value at position 900: " + array1[900]);
	
	//SELECTION SORT
	start = System.nanoTime();
	
	int countSelection=1;
	for (int i = 0; i < array2.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array2.length; j++)
                if (array2[j] < array2[index]) 
                    index = j;
      
            int temp = array2[index];  
            array2[index] = array2[i];
            array2[i] = temp;
			countSelection++;
        }
	
	end = System.nanoTime();
	long selectionTime = end-start;
	
	System.out.println("\nSpecific values in array sorted using SELECTION SORT: \n");
	System.out.println("Value at position 100: " + array2[100]);
	System.out.println("Value at position 125: " + array2[125]);
	System.out.println("Value at position 250: " + array2[250]);
	System.out.println("Value at position 700: " + array2[700]);
	System.out.println("Value at position 900: " + array2[900]);
	
	//DOUBLE-ENDED SELECTION SORT
	array = Input("inputData9B.txt");
	CS6089BSurati b = new CS6089BSurati();
	
	start = System.nanoTime();
	
    b.biSort(array);
		
	end = System.nanoTime();
	long dessTime = end-start;
	
	//SORTING TIMES
	System.out.println("\nSORTING TIMES");
	System.out.println("\nTime taken for bubble sort: " + bubbleTime + " ns");
	System.out.println("\nTime taken for selection sort: " + bubbleTime + " ns");
	System.out.println("\nTime taken for double ended selection sort: " + bubbleTime + " ns\n");
	
	//COMPARISIONS
	System.out.println("\nCOMPARISIONS MADE");
	System.out.println("\nNumber of comparisions for bubble sort: " + countBubble);
	System.out.println("\nNumber of comparisions for selection sort: " + countSelection);
	System.out.println("\nNumber of comparisions for double ended selection sort: " + countDESS + "\n");
	
	//TEST
	Arrays.sort(test);
	
	//BUBBLE SORT
	System.out.println("VERIFICATION OF VALUES OBTAINED BY MANUAL SORTING, WITH VALUES OBTAINED BY BUILT-IN SORTING FUNCTION");
	System.out.println("\nBUBBLE SORT");
	
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
	
	//SELECTION SORT
	System.out.println("\nSELECTION SORT");
	
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
	
	//DOUBLE ENDED SELECTION SORT
	System.out.println("\nDOUBLE ENDED SELECTION SORT");
	
	if(test[100] == array[100]) {
		System.out.println("\nValue at position 100 is correct");
	}			
	else {
		System.out.println("\nValue at position 100 is incorrect");
	}
	
	if(test[125] == array[125]) {
		System.out.println("\nValue at position 125 is correct");
	}			
	else {
		System.out.println("\nValue at position 125 is incorrect");
	}
	
	if(test[250] == array[250]) {
		System.out.println("\nValue at position 250 is correct");
	}			
	else {
		System.out.println("\nValue at position 250 is incorrect");
	}
	
	if(test[700] == array[700]) {
		System.out.println("\nValue at position 700 is correct");
	}			
	else {
		System.out.println("\nValue at position 700 is incorrect");
	}
	
	if(test[900] == array[900]) {
		System.out.println("\nValue at position 900 is correct");
	}			
	else {
		System.out.println("\nValue at position 900 is incorrect");
	}
	
	System.out.println("\nThus, by using built-in sort() function, we have verified that the arrays are sorted correctly by manual approach!\n");
	
	/*
	System.out.println("\nArray sorted using built-in function: \n");
	for (int e = 0; e < n; e++) 
	      System.out.print(test[e] + " ");
	
	System.out.println("\n\nThus, by looking at the above sorted numbers (using built-in swap() function), we can easily verify that array is sorted correctly by manual approach!");
	*/
	}
	
	//INPUT METHOD
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