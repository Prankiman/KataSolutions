import java.math.BigInteger;

public class Kata {
  public static String incrementString(String str) {
    
    String reversed = new StringBuilder(str).reverse().toString();
    
    char[] str_chars = reversed.toCharArray();
        
    String numbers = "";
    
    str = str.replaceAll("\\d+$", "");
    
    long leading_zeros = 0;
    
    for(char ch : str_chars){
      if(ch - '0' <= 9 && ch - '0' >= 0){
        numbers += ch;
      }
      else
        break;
    }
    
    numbers = new StringBuilder(numbers).reverse().toString();
    
    try{
      if(numbers.charAt(0) == '0')
        for(char ch : numbers.toCharArray()){
          if(ch != '0')
            break;
          else
            leading_zeros ++;
        }


      if(numbers.charAt(numbers.length()-1) == '0' && numbers.codePoints().distinct().count() == 1|| numbers.charAt(0) == '0' && numbers.charAt(numbers.length()-1) == '9' && numbers.codePoints().distinct().count() == 2)
        leading_zeros --;
    }
    catch(Exception e){}
    
    BigInteger new_numbers_val = new BigInteger("0" + numbers).add(new BigInteger("1"));
      
    for(int i = 0; i < leading_zeros; i++)
      str += "0";
      
    str += new_numbers_val;
    
    return str;
  }
}
