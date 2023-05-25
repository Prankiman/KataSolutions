class Solution {
  
   public static String rot13(String message) {
     
     String alphabetical_order = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
     String offset_by_13 = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";
     
     char[] ciphered = message.toCharArray();
     
     for (int i = 0; i < ciphered.length; i++){
       if(alphabetical_order.contains(Character.toString(ciphered[i])))
        ciphered[i] = offset_by_13.charAt(alphabetical_order.indexOf(ciphered[i]));
     }
     
     return new String(ciphered);
   }
}
