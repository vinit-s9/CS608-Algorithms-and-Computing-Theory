import java.math.BigInteger;
import java.util.Date;
import java.util.Scanner;

public class CS6083BSurati {

private static Scanner s;

public static void main(String[] args) {
       s = new Scanner(System.in);
       
       System.out.println("Name: Vinitkumar Surati");
       System.out.println("Course No.: CS608");	  
       Date date = new Date();
       System.out.println(date.toString()+"\n");
       System.out.println("PROGRAM TO CALCULATE FACTORIAL OF A GIVEN NUMBER"+"\n");
       
       System.out.println("Do you want to calculate factorial value of a number?\nEnter 1 if YES\nEnter 0 if NO");
       
       int c = s.nextInt();
       
       if (c==0){
    	   System.out.println("Okay! :)");
    	   System.exit(c);
       }
       
       do {
           System.out.print("Enter the number to calculate its factorial value: ");
           int m = s.nextInt();
           BigInteger fact = factorial(m);
           System.out.println(m + "! is: " + fact);
           System.out.println("\nDo you want to calculate factorial value of other number?\nEnter 1 if YES\nEnter 0 if NO");
           c = s.nextInt();

       } 
       while(c==1);
       
      if (c==0){
    	   System.out.println("Thank you for using this program! :)");
       }
       else {
    	   System.out.println("Please enter correct value!");
       }
}

public static BigInteger factorial(int m) {

	BigInteger fact = new BigInteger("1");
	
	for (int i = 1; i <= m; i++) {
		fact = fact.multiply(new BigInteger(i + ""));
		}
	return fact;
   }

}