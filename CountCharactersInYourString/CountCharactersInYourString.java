import java.util.Map;
import java.util.HashMap;

public class Kata {
    public static Map<Character, Integer> count(String str) {
        
        Map<Character, Integer> char_occurences = new HashMap<>();
      
        for (int i = 0; i < str.length(); i++){
          if(char_occurences.get(str.charAt(i)) != null)
            char_occurences.put(str.charAt(i), char_occurences.get(str.charAt(i)) + 1);
          else
            char_occurences.put(str.charAt(i), 1);
        }
      
        return char_occurences;
    }
}
