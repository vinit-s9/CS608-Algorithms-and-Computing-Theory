import java.util.Date;

public class CS6082BSurati {

    static private int end = -1;
    
   public static void main(String[] args) {
	
	int f1=0,f2=0,f3=0,f4=0;
	int[] z= new int[100];
	   
	System.out.println("Name: Vinitkumar Surati");
    System.out.println("Course No.: CS608");	  
    Date date = new Date();
    System.out.println(date.toString()+"\n");
    System.out.println("PROGRAM TO IMPLEMENT FOUR DIFFERENT ALGORITHMS OF MAXIMUM SUBSEQUENCE SUM PROBLEM"+"\n");
    
    z[0]=33;
    z[1]=6;
    z[2]=16;
    z[3]=1;
    z[4]=7;
    z[5]=-49;
    z[6]=53;
    z[7]=95;
    z[8]=48;
    z[9]=79;
    z[10]=-42;
    z[11]=27;
    z[12]=63;
    z[13]=-22;
    z[14]=60;
    z[15]=90;
    z[16]=13;
    z[17]=2;
    z[18]=8;
    z[19]=51;
    z[20]=28;
    z[21]=18;
    z[22]=30;
    z[23]=93;
    z[24]=98;
    z[25]=44;
    z[26]=26;
    z[27]=24;
    z[28]=35;
    z[29]=70;
    z[30]=66;
    z[31]=89;
    z[32]=-61;
    z[33]=9;
    z[34]=-43;
    z[35]=87;
    z[36]=38;
    z[37]=92;
    z[38]=3;
    z[39]=-80;
    z[40]=55;
    z[41]=78;
    z[42]=32;
    z[43]=50;
    z[44]=77;
    z[45]=73;
    z[46]=-83;
    z[47]=17;
    z[48]=19;
    z[49]=31;
    z[50]=39;
    z[51]=76;
    z[52]=62;
    z[53]=96;
    z[54]=-23;
    z[55]=65;
    z[56]=72;
    z[57]=4;
    z[58]=37;
    z[59]=12;
    z[60]=-54;
    z[61]=15;
    z[62]=94;
    z[63]=21;
    z[64]=-52;
    z[65]=58;
    z[66]=64;
    z[67]=40;
    z[68]=59;
    z[69]=82;
    z[70]=81;
    z[71]=41;
    z[72]=-57;
    z[73]=69;
    z[74]=25;
    z[75]=97;
    z[76]=-11;
    z[77]=47;
    z[78]=88;
    z[79]=-36;
    z[80]=20;
    z[81]=68;
    z[82]=67;
    z[83]=34;
    z[84]=-45;
    z[85]=10;
    z[86]=56;
    z[87]=91;
    z[88]=29;
    z[89]=14;
    z[90]=74;
    z[91]=-46;
    z[92]=84;
    z[93]=100;
    z[94]=5;
    z[95]=86;
    z[96]=99;
    z[97]=75;
    z[98]=-85;
    z[99]=71;
    
    System.out.println("1.");
    System.out.println("Timestamp before execution: "+System.currentTimeMillis()+" ms");
    f1=maxSumAlgo1(z);
    System.out.println("Cubic maximum contiguous subsequence sum: "+f1);
    System.out.println("Timestamp after execution: "+System.currentTimeMillis()+" ms");
    
    System.out.println("2.");
    System.out.println("Timestamp before execution: "+System.currentTimeMillis()+" ms");
    f2=maxSumAlgo2(z);
    System.out.println("Quadratic maximum contiguous subsequence sum: "+f2);
    System.out.println("Timestamp after execution: "+System.currentTimeMillis()+" ms\n");

    System.out.println("3.");
    System.out.println("Timestamp before execution: "+System.currentTimeMillis()+" ms");
    f3=maxSumAlgo3(z);
    System.out.println("Recursive maximum contiguous subsequence sum: "+f3);
    System.out.println("Timestamp after execution: "+System.currentTimeMillis()+" ms\n");

    System.out.println("4.");
    System.out.println("Timestamp before execution: "+System.currentTimeMillis()+" ms");
    f4=maxSumAlgo4(z);
    System.out.println("Linear-time maximum contiguous subsequence sum: "+f4);
    System.out.println("Timestamp after execution: "+System.currentTimeMillis()+" ms\n");

    int n=end+1;
    System.out.println( "Sequence: First " + n + " numbers out of the 100 numbers in the input array." + "\n");
   }
   
    public static int maxSumAlgo1( int[] a) 
    { 
    	int maxSum = 0; 
    	 
    	for( int i = 0; i < a.length; i++ ) 
		   for( int j = i; j < a.length; j++ ) 
    	   { 
    	   int thisSum = 0;
    	      for( int k = i; k <= j; k++ ) 
    	      thisSum += a[ k ]; 
    	      if( thisSum > maxSum ) {
    	      maxSum = thisSum; 
              end   = j;
    	      }
    	   } 
    	   return maxSum; 
    }
    
    public static int maxSumAlgo2( int []a) 
    {
    	int maxSum = 0; 
    	for( int i = 0; i < a.length; i++ ) { 
    		int thisSum = 0; 
    		for( int j = i; j < a.length; j++ ) { 
    			thisSum += a[ j ]; 
    			if( thisSum > maxSum ) {
    				maxSum = thisSum;
    				end = j;
    			} 
    		}  
    	} 
    	return maxSum; 
    } 
    
    private static int maxSumRec( int [ ] a, int left, int right ) { 
    
    	if( left == right ) // Base case 
    		if( a[ left ] > 0 ) 
    			return a[ left ]; 
    		else 
    			return 0; 
    	int center = ( left + right ) / 2; 
    	int maxLeftSum = maxSumRec( a, left, center ); 
    	int maxRightSum = maxSumRec( a, center + 1, right ); 
    	int maxLeftBorderSum = 0, leftBorderSum = 0; 
    	
    	for( int i = center; i >= left; i-- ) { 
    	leftBorderSum += a[ i ]; 
    		if( leftBorderSum > maxLeftBorderSum )
    			maxLeftBorderSum = leftBorderSum; 
    	} 
    	
    	int maxRightBorderSum = 0, rightBorderSum = 0;
    	
    	for( int i = center + 1; i <= right; i++ ) { 
    	rightBorderSum += a[ i ]; 
    		if( rightBorderSum > maxRightBorderSum )
    			maxRightBorderSum = rightBorderSum;
    	} 
    	
    	int p = maxLeftSum, q = maxRightSum , r = maxLeftBorderSum + maxRightBorderSum;
        return p > q ? ( p > r ? p : r) : (q > r ? q : r);

    }
    	
    public static int maxSumAlgo3( int []a) { 
    	return maxSumRec( a, 0, a.length - 1 ); 
    }

    public static int maxSumAlgo4( int []a) {
    	
    	int maxSum = 0, thisSum = 0; 
    	
    	for( int j = 0; j < a.length; j++ ) { 
    	thisSum += a[ j ];
    		if( thisSum > maxSum ) {
    			maxSum = thisSum;
				end = j;
    		}
    		else if( thisSum < 0 ) 
    			thisSum = 0; 
    	} 
    	return maxSum; 
    }
	
}

