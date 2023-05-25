import java.util.HashMap;

public class BraceChecker {

  public boolean isValid(String braces) {
    char[] bracket_list = braces.toCharArray();
    
    int open_brackets = 0;
    int open_square_brackets = 0;
    int open_curly_brackets = 0;
    
    
    int closed_brackets = 0;
    int closed_square_brackets = 0;
    int closed_curly_brackets = 0;
    
    for(int i = 0; i < bracket_list.length; i++){
      switch(bracket_list[i]){
          case  '(':
            open_brackets ++;
            break;
          case ')':
            closed_brackets ++;
            if (open_brackets < closed_brackets || bracket_list[i-1] == '{' || bracket_list[i-1] == '[') 
              return false;
            break;
          
          case  '[':
            open_square_brackets ++;
            break;
          case ']':
            closed_square_brackets ++;
            if (open_square_brackets < closed_square_brackets ||bracket_list[i-1] == '(' || bracket_list[i-1] == '{')
              return false;
            break;  
          
          case  '{':
            open_curly_brackets ++;
            break;
          case '}':
            closed_curly_brackets ++;
            if (open_curly_brackets < closed_curly_brackets || bracket_list[i-1] == '(' || bracket_list[i-1] == '[')
              return false;
            break;
      }
    }
    if(open_brackets == closed_brackets && open_square_brackets == closed_square_brackets && open_curly_brackets == closed_curly_brackets)
      return true;
    
    return false;
  }

}
