public class User {
  
  int rank = -8;
  int progress = 0;
  
  
  public User(int rank, int progress){
    rank = this.rank;
    progress = this.progress;
  }
  
  public User(){}
  
  void incProgress(int difficulty){
    if(difficulty < -8 || difficulty > 8 || difficulty == 0)
      throw new IllegalArgumentException("invalid difficulty");
    
    int rank_difficulty_diff = difficulty < 0 || rank > 0 ? difficulty - rank : difficulty - rank - 1;
    
    progress += difficulty == rank ? 3 : rank == 1 ? (difficulty == (rank - 1) - 1 ? 1 :
                              difficulty <= (rank - 1) - 2 ? 0 : rank_difficulty_diff * rank_difficulty_diff * 10) 
                              : difficulty == rank - 1 ? 1 :
                              difficulty <= rank - 2 ? 0 : rank_difficulty_diff * rank_difficulty_diff * 10;
    while(progress > 100){
      progress -= 100;
      rank += rank == -1 ? 2 : 1;
    }
    
    if(rank >= 8){
      rank = 8;
      progress = 0;
    }
      
    
    
  }
  
}
