import java.io.*;
import java.util.*;
import java.text.*;

class CS6088BSurati 
{
	static Hashtable<Integer,String> table;

	public static void main(String[] args) throws Exception
	{
		System.out.println("Name: Vinitkumar Surati");
		System.out.println("Course No.: CS608");	  
		Date date = new Date();
		System.out.println(date.toString()+"\n");
		System.out.println("PROGRAM TO DEMONSTRATE HASHING OF STRINGS BY LINEAR PROBING\n");
		 
		CS6088BSurati hashOp = new CS6088BSurati();

        String extIn[] = hashOp.Input("inputData8B.txt");

		Hashtable<Integer,String> table = new Hashtable<Integer,String>(353);
		
		for (String i : extIn) 
		{
			String value = i;
			
			int key = (int)(i.hashCode() & 0x7ffffffffL) % 353;
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
		
		int sub[]={0,20,35,50,60,180,220,270,340,350};
		
		System.out.println("\nSEARCHING STRINGS AT PARTICULAR SUBSCRIPTS\n");
		for (Integer a : sub) 
		{
			if(table.containsKey(a))
			{
				System.out.println("-> String at subscript " + a + ": " + table.get(a) + "\n");	
			}
			else
			{
				System.out.println("String at subscript " + a + ": NULL, i.e. 0"  + "\n");		
			}
			
		}
		
		String cities[] = {"Boston","Brussels","Pleasantville","Shanghai","Johannesburg"};
		
		System.out.println("\nSEARCHING SPECIFIC STRINGS\n");
		for (String i : cities) {
			System.out.println(i + " in table: " + table.containsValue(i) + "\n");	
		}
	}

    private String[] Input(String filename) throws Exception
    {
        File f1 = new File(filename);
        Scanner filereader = new Scanner(f1);
        String inputData[] = new String[175];
       int i = 0;
        while (filereader.hasNextLine()) 
           inputData[i++] = filereader.nextLine();

        return inputData;
    }

}