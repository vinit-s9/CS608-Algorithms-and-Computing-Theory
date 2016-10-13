import java.util.Date;

public class CS6082ASurati {


   public static void main(String[] args) {
	  
	 long x=96, y=72;
	 long m=63235986, n=514229;
	 long p=701408733, q=3524578;
	 
      System.out.println("Name: Vinitkumar Surati");
      System.out.println("Course No.: CS608");	  
      Date date = new Date();
      System.out.println(date.toString()+"\n");
      System.out.println("PROGRAM TO CALCULATE GCD OF TWO NUMBERS"+"\n");
      
      gcd(x,y);
      gcd(m,n);      
      gcd(p,q);   
   
   }    
      public static void gcd(long a, long b){
   
      int count=0;	  
      long rem=0,t1=0,t2=0;
      
      t1=a; 
      t2=b;
      
      while(b!=0){
    	  	rem = a % b;
    	  	a = b;
    	  	b = rem;
      count++;
      }
      System.out.println("The Greatest Common Divisor of "+t1+" and "+t2+" is: "+a);
      System.out.println(count+" iterations were involved in this calculation."+"\n");
      }
      
}
