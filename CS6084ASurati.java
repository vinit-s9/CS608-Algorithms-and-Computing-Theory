import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class CS6084ASurati {

	private static Scanner s;

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Name: Vinitkumar Surati");
	    System.out.println("Course No.: CS608");	  
	    Date date = new Date();
	    System.out.println(date.toString()+"\n");
	    System.out.println("PROGRAM TO DEMONSTRATE STACKS USING MATHEMATICAL EXPRESSIONS");
	    System.out.println("CONVERSION OF INFIX EXPRESSIONS TO POSTFIX EXPRESSIONS\n");
		
		myStack operatorsStack = new myStack(25);
		
		String s1="",s2="",s3="",s4="",s5="";
		
			File f = new File("infixData4A.txt");	

			s = new Scanner(f);
			int count = 0;
			while (s.hasNextLine() && count < 5)
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
					s5 = s.nextLine();
				
				count++;
			}
		
		String[] infixExpressions = {s1,s2,s3,s4,s5};
		String infixExpression="";
		
		for(int k=0;k<infixExpressions.length;k++) {
			 infixExpression = infixExpressions[k];
			 int inputLength = infixExpression.length();
			 String output = "";
			 
			 for(int i=0;i<inputLength;i++) {
				char currentCharacter = infixExpression.charAt(i);
				if(currentCharacter >='a' && currentCharacter<='z')
				output += currentCharacter;
				else {
				switch (currentCharacter) {
				case '+':
				case '-':
						if(operatorsStack.isEmpty()) {
							operatorsStack.push(currentCharacter);
						}
						else {
						while(!operatorsStack.isEmpty())
						output += (char) operatorsStack.pop();
						operatorsStack.push(currentCharacter);
						}
				break;
				case '*':
				case '/':
						if(operatorsStack.isEmpty() || operatorsStack.topElement() == '+' || operatorsStack.topElement != '-')
						operatorsStack.push(currentCharacter);
						else {
						while(!operatorsStack.isEmpty() && operatorsStack.topElement() != '+' && operatorsStack.topElement() != '-')
						output += (char) operatorsStack.pop();
						operatorsStack.push(currentCharacter);
						}
				break;
				}
				}
			 
			 }
			 while(!operatorsStack.isEmpty())
				output += (char) operatorsStack.pop();
			System.out.println("Given Infix Expression: " + infixExpression);
			System.out.println("Corresponding Postfix Expression: " + output + "\n");
		}

    }

}

class myStack {
	public char topElement;
	private int top;
	private char[] operatorsArray;
	
	public myStack(int size) {
		operatorsArray = new char[size];
		top = -1;
	
	}
	
	public void push(char op) {
	top++;
	operatorsArray[top] = op;
	
	}
	
	public char pop () {
		return operatorsArray[top--];
	
	}
	
	int topElement() {
		return operatorsArray[top];
	
	}
	
	public boolean isEmpty() {
		return(top==-1);
	
	}

}