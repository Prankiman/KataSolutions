public class JadenCase {

	public String toJadenCase(String phrase) {
		
    if(phrase != null && phrase.length() > 0){
      phrase = phrase.toLowerCase();

      String[] words = phrase.split(" ");

      for(int i = 0; i < words.length; i++){
        char[] jaden_word = words[i].toCharArray();
        jaden_word[0] = Character.toUpperCase(jaden_word[0]);
        words[i] = new String(jaden_word);
      }
      
      phrase = String.join(" ", words);
      
      return phrase;
    }
    
		return null;
	}

}
