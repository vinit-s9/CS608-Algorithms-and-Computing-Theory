import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CS6084BSurati
{
	private static Scanner s;
	private static Scanner sc;


public static String stdEq(String str) {
	
	
	str = str.replaceAll("\\s","");
	
	
	StringTokenizer tokens = new StringTokenizer(str, "()^*/+-", true);
 
	ArrayList<String> l1 = new ArrayList<String>();
    
	while(tokens.hasMoreTokens()) {
    	l1.add(tokens.nextToken());
    	l1.add (" ");
    }
    String[] array = new String[l1.size()];
    for (int i=0; i < array.length; i++)
        array[i] = l1.get(i);
    
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < array.length; i++) {
    	buffer.append(array[i]);
    }

    return buffer.toString();
}
public static double infixEval(String expression)
{
	String exps = stdEq(expression);

	Stack<Double> values = new Stack<Double>();

	Stack<String> ops = new Stack<String>();

	sc = new Scanner(exps);

	while (sc.hasNext())
	{
		String token = sc.next();

		if(token.equals(" "))
		{
			continue;
		}

		
		if(token.matches("\\d+\\.\\d+")||token.matches("\\d+"))
		{
			values.push(Double.valueOf(token));
			
		}

		else if (token.equals("("))
			ops.push(token);

		else if (token.equals(")"))
		{
			while (!(ops.peek()).equals("("))
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
			ops.pop();
		}

		else if(token.equals("^") || token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-"))
        {
        	while (!ops.empty() && hasPrecedence(token, ops.peek()))
        	{
				values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        	}

			ops.push(token);
		}
	}
	while (!ops.empty())
		values.push(applyOp(ops.pop(), values.pop(), values.pop()));


	return values.pop();

}


public static boolean hasPrecedence(String op1, String op2)
{
	if (op2.equals("(") || op2.equals(")"))
		return false;
	if ( (op1.equals("^")) && (op2.equals("+")|| op2.equals("-")))
        return false;
    if ( (op1.equals("^") ) && (op2.equals("*")|| op2.equals("/")))
        return false;
    if ( (op1.equals("*")) && (op2.equals("+")|| op2.equals("-")))
        return false;
    if ( (op1.equals("/")) && (op2.equals("+")|| op2.equals("-")))
        return false;
	else
		return true;
}

public static double applyOp(String op, double b, double a)
{
    switch (op)
    {
    case "^":
        return Math.pow(a,b);
    case "+":
        return a + b;
    case "-":
        return a - b;
    case "*":
        return a * b;
    case "/":
        if (b == 0)
           System.out.println("error");
        return a / b;
    }
    return 0;
}

    
	public static void main(String[] args) throws FileNotFoundException
    {
    	System.out.println("Name: Vinitkumar Surati");
	    System.out.println("Course No.: CS608");	  
	    Date date = new Date();
	    System.out.println(date.toString()+"\n");
	    System.out.println("PROGRAM TO DEMONSTRATE STACKS USING MATHEMATICAL EXPRESSIONS");
	    System.out.println("EVALUATION OF INFIX EXPRESSIONS");
		
		String s1="", s2="", s3="", s4="", s5="", s6="", s7="", s8="", s9="", s10="";
		
			File f = new File("infixData4B.txt");	

			s = new Scanner(f);
			int count = 0;
			while (s.hasNextLine() && count < 10)
			{		
				if (count==0)
					s1 = s.nextLine();
				if (count==1)
					s2 = s.nextLine();
				
				if (count==2)
					s3 = s.nextLine();
				if (count==3)
					s4 = s.nextLine();
				
				if (count==4)
					s5=s.nextLine();
				if (count==5)
					s6 = s.nextLine();
				
				if (count==6)
					s7 = s.nextLine();
				if (count==7)
					s8 = s.nextLine();
			
				if (count==8)
					s9 = s.nextLine();
				if (count==9)
					s10 = s.nextLine();
		
				count++;
			}
			
			System.out.println("\nEvaluation of String 1: " + s1);
			
			String[] partsA = s2.split(" ");
			String part1a = partsA[0];
			String part2a = partsA[1];
			String part3a = partsA[2];
			String part4a = partsA[3];
			
			s1 = s1.replaceAll("a",part1a);
			s1 = s1.replaceAll("b",part2a);
			s1 = s1.replaceAll("c",part3a);
			s1 = s1.replaceAll("d",part4a);

			System.out.println("i.e.\n" + s1 + "\n= " +CS6084BSurati.infixEval(s1) + "\nwhere the values are: " + "\na = " + part1a + " | b = " + part2a + " | c = " +part3a + " | d = " + part4a);	
			
			System.out.println("\nEvaluation of String 2: " + s3);

			String[] partsB = s4.split(" ");
			String part1b = partsB[0];
			String part2b = partsB[1];
			String part3b = partsB[2];
			String part4b = partsB[3];
			
			s3 = s3.replaceAll("a",part1b);
			s3 = s3.replaceAll("b",part2b);
			s3 = s3.replaceAll("c",part3b);
			s3 = s3.replaceAll("d",part4b);
			
			System.out.println("i.e.\n" + s3 + "\n= " +CS6084BSurati.infixEval(s3) + "\nwhere the values are: " + "\na = " + part1b + " | b = " + part2b + " | c = " +part3b + " | d = " + part4b);	
    		
			System.out.println("\nEvaluation of String 3: " + s5);

			String[] partsC = s6.split(" ");
			String part1c = partsC[0];
			String part2c = partsC[1];
			String part3c = partsC[2];
			String part4c = partsC[3];
			
			s5 = s5.replaceAll("a",part1c);
			s5 = s5.replaceAll("b",part2c);
			s5 = s5.replaceAll("c",part3c);
			s5 = s5.replaceAll("d",part4c);
			
			System.out.println("i.e.\n" + s5 + "\n= " +CS6084BSurati.infixEval(s5) + "\nwhere the values are: " + "\na = " + part1c + " | b = " + part2c + " | c = " +part3c + " | d = " + part4c);	
			
			System.out.println("\nEvaluation of String 4: " + s7);

			String[] partsD = s8.split(" ");
			String part1d = partsD[0];
			String part2d = partsD[1];
			String part3d = partsD[2];
			String part4d = partsD[3];
			
			s7 = s7.replaceAll("a",part1d);
			s7 = s7.replaceAll("b",part2d);
			s7 = s7.replaceAll("c",part3d);
			s7 = s7.replaceAll("d",part4d);
			
			System.out.println("i.e.\n" + s7 + "\n= " +CS6084BSurati.infixEval(s7) + "\nwhere the values are: " + "\na = " + part1d + " | b = " + part2d + " | c = " +part3d + " | d = " + part4d);	
			
			System.out.println("\nEvaluation of String 5: " + s9);

			String[] partsE = s10.split(" ");
			String part1e = partsE[0];
			String part2e = partsE[1];
			String part3e = partsE[2];
			String part4e = partsE[3];
			
			s9 = s9.replaceAll("a",part1e);
			s9 = s9.replaceAll("b",part2e);
			s9 = s9.replaceAll("c",part3e);
			s9 = s9.replaceAll("d",part4e);
			
			System.out.println("i.e.\n" + s9 + "\n= " +CS6084BSurati.infixEval(s9) + "\nwhere the values are: " + "\na = " + part1e + " | b = " + part2e + " | c = " +part3e + " | d = " + part4e);	
    }
        
}



