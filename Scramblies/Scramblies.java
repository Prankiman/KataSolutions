import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

public class Scramblies {
    
    public static boolean scramble(String str1, String str2) {    
      
      LinkedList<Character> str1_list = new LinkedList<Character>(Arrays.asList(str1.chars().mapToObj(c -> (char)c).toArray(Character[]::new)));
      LinkedList<Character> str2_list = new LinkedList<Character>(Arrays.asList(str2.chars().mapToObj(c -> (char)c).toArray(Character[]::new)));
      
      
      LinkedList<Character> tested_chars = new LinkedList<Character>();
      
      for(Character c : str2_list){
        if(tested_chars.contains(c))
          continue;
        if(Collections.frequency(str1_list, c) < Collections.frequency(str2_list, c))
          return false;
        tested_chars.add(c);
      }
      
      return true;
    }
}
