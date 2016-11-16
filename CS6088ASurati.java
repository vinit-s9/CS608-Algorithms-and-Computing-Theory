import java.io.*;
import java.util.*;
import java.text.*;

class CS6088ASurati {

	static Hashtable<Integer,Integer> table;

	public static void main(String[] args) throws Exception
	{
		System.out.println("Name: Vinitkumar Surati");
		System.out.println("Course No.: CS608");	  
		Date date = new Date();
		System.out.println(date.toString()+"\n");
		System.out.println("PROGRAM TO DEMONSTRATE HASHING OF INTEGERS BY LINEAR PROBING\n");
		
		CS6088ASurati hashOp = new CS6088ASurati();

        int extIn[] = hashOp.Input("inputData8A.txt");

		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>(211);
		
		for (int i : extIn) 
		{
			Integer value = i;

			int key = i % 211;
			if(table.containsKey(key))
			while(true)
			{
				key++;
				
				if(!table.containsKey(key)){
					table.put(key,value);
					break;	
				}
			}
			if(!table.containsKey(key))
				table.put(key,value);		
		}

		int sub[]={0,20,35,50,60,80,90,120,150,170};
		
		System.out.println("\nSEARCHING ELEMENTS AT PARTICULAR SUBSCRIPTS\n");
		for (Integer a : sub) 
		{
			if(table.containsKey(a))
			{
				System.out.println("-> Element at subscript " + a + " is " + table.get(a) + "\n");	
			}
			else
			{
				System.out.println("Empty slot at subscript " + a + ", thus 0\n");
			}
			
		}
		
		int num[] = {10,200,174,291,212,152,34};
		
		System.out.println("\nSEARCHING SPECIFIC ELEMENTS\n");
		for (Integer i : num) {
			System.out.println(i + " in table: " + table.containsValue(i) + "\n");	
		}
	}
	
    private int[] Input(String filename) throws Exception
    {
        File f1 = new File(filename);
        Scanner filereader = new Scanner(f1);
        int inputData[] = new int[100];
       int i = 0;
        while (filereader.hasNextInt()) 
           inputData[i++] = filereader.nextInt();

        return inputData;
    }
	
}