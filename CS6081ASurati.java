import java.util.Date;

public class CS6081Axxxxx {
   public static void main(String[] args) {
	  float sum=0;
      float n=0; 
      float[] y = new float[10];
      float[] z = new float[10];
      int x =1001, k, i; 
      
      System.out.println("Name: Vinitkumar Surati");
      System.out.println("Course No.: CS608");	  
      Date date = new Date();
      System.out.println(date.toString()+"\n");
      
      for(k=0;k<10;k++)
      {  for(n=1;n<x;n++)
	  {
		  sum=(sum)+(1/(n*n));
	  }
	  System.out.println("sum"+(k+1)+": "+sum);
	  
	  x+=1000;
	  y[k]=sum;
	  
	  sum=0;
   }
      for(i=9;i>0;i--)
      {
      z[i]=y[i]-y[i-1];
      }	  
    
      if(z[9]<0.0001 || z[8]<0.0001 || z[7]<0.0001 || z[6]<0.0001 || z[5]<0.0001 || z[4]<0.0001 || z[3]<0.0001 || z[2]<0.0001 || z[1]<0.0001 || z[0]<0.0001 )
		  System.out.println("The series is convergent");
      else 
    	  System.out.println("The series is divergent");
     
   }
}
