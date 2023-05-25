class LongestConsec {
    
    public static String longestConsec(String[] strarr, int k) {
        String longest_concat = "";
      
        if(k > strarr.length || k <= 0 || strarr.length ==0)
          return "";
      
        for (int i = 0; i <= strarr.length-k; i++){
          String compare_string = strarr[i];
          for(int j = 1; j < k; j++)
            compare_string = compare_string.concat(strarr[i+j]);
          if(compare_string.length() > longest_concat.length())
              longest_concat = compare_string;
          
        }
      
        return longest_concat;
    }
}
