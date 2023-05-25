public class Kata {
  public static String sumStrings(String a, String b) {
    
    String na = "0" + a;
    String nb = "0" + b;
    
    char[] a_chars = na.toCharArray();
    char[] b_chars = nb.toCharArray();
    
    int carry = 0, i;
    
    if(a_chars.length < b_chars.length){
      for(i = b_chars.length - 1 ; i > b_chars.length - a_chars.length -1 ; i--){
        b_chars[i] += a_chars[i + a_chars.length - b_chars.length] - '0' + carry;
        if(b_chars[i] - '0' > 9){
          carry = 1;
          b_chars[i] -= 10;
        }
        else
          carry = 0;
      }
       try{
        b_chars[b_chars.length - a_chars.length - 1] += carry;
      }
      catch(Exception e){}
      
      return new String(b_chars).replaceAll("^0+", "");
    }
    else{
      for(i = a_chars.length - 1 ; i > a_chars.length - b_chars.length - 1; i--){
        a_chars[i] += b_chars[i + b_chars.length - a_chars.length] - '0' + carry;
        if(a_chars[i] - '0' > 9){
          carry = 1;
          a_chars[i] -= 10;
        }
        else
          carry = 0;
      }
      try{
        a_chars[a_chars.length - b_chars.length - 1] += carry;
      }
      catch(Exception e){}
      
      
      return new String(a_chars).replaceAll("^0+", "");
    }
    
    
    
    
  }
}
