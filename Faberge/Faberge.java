import java.math.BigInteger;
import java.util.stream.LongStream;

public class Faberge {

  public static BigInteger height(BigInteger eggs, BigInteger tries) {
    
    // att current eggs and tries:  h(n, m), after one try:  h(n-1, m-1) or h(n, m-1)
    
    long n = eggs.intValue();
    
    
    // C(n,k)=C(n−1,k)+C(n−1,k−1)
    
    BigInteger height = BigInteger.ZERO, binomial_coeff_part = BigInteger.ONE;
    
    for(long i = 0; i < n; i++){
        binomial_coeff_part = binomial_coeff_part.multiply(tries).divide(BigInteger.valueOf(i+1));
        height = height.add(binomial_coeff_part);
        tries = tries.subtract(BigInteger.ONE);
    }
    
    return height;
    
  }
}
