import java.math.BigInteger;

public class Faberge {
  
  
 
  
 	public static BigInteger height(BigInteger eggs, BigInteger tries) {
    
    BigInteger minimum = new BigInteger("-1");
    
    System.out.println("beInG eXeCUted");
    
    if(eggs.equals(BigInteger.ONE) || tries.equals(BigInteger.ONE) || tries.equals(BigInteger.ZERO))
		    return tries;
  
    for(BigInteger i = BigInteger.ZERO; i.compareTo(tries) == -1; i.add(BigInteger.ONE)){
        if(!minimum.equals(new BigInteger("-1")))
      	  minimum = minimum.min(height(eggs, tries.subtract(BigInteger.ONE)).max(height(eggs.subtract(BigInteger.ONE), tries.subtract(BigInteger.ONE))).add(BigInteger.ONE));
        else
        	minimum = height(eggs, tries.subtract(BigInteger.ONE)).max(height(eggs.subtract(BigInteger.ONE), tries.subtract(BigInteger.ONE))).add(BigInteger.ONE);
      }
      return minimum;
    }
    
}
