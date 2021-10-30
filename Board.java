class Board {
  // 0 = blank, 1 = X, 2 = O
  int[][] board;

  public Board() {
    board = new int[3][3];
  }

  public void set(int x, int y, int val) {
    board[x][y] = val;
  }

  public int get(int x, int y) {
    return board[x][y];
  }

  public int testWin() {
    //for (int i=0; i<3; i++){
     // if (board[i][i] != 0){
       // return 
     // }
    //}
    //return 0;

    //tests top left win
    if (board[0][0] != 0){
      if (board[0][0] == board [1][0] && board[0][0] == board [2][0]){
        return board[0][0];
      }
      else if (board[0][0] == board [0][1] && board[0][0] == board [0][2]){
        return board[0][0];
      }
    }

    //tests middle win
    if (board[1][1] != 0){
      if (board[1][1] == board[2][1] && board[1][1] == board[0][1]){
        return board[1][1];
      }
      else if (board[1][1] == board[1][2] && board[1][1] == board [1][0]){
        return board[1][1];
      }
      else if (board[1][1] == board[0][0] && board[1][1] == board[2][2]){
        return board[1][1];
      }
      else if (board[1][1] == board[0][2] && board[1][1] == board[2][0]){
        return board[1][1];
      }
    }
    
    //tests bottom right win
    if (board[2][2] != 0){
      if (board[2][2] == board [1][2] && board[2][2] == board [0][2]){
        return board[2][2];
      }
      else if (board[2][2] == board [2][1] && board[2][2] == board [2][0]){
        return board[2][2];
      }
    }
    return 0;
  }

  // public boolean hasSpaceLeft() {
  //   for(int x = 0; x < 3; x++) {
  //     for(int y = 0; y < 3; y++) {
  //       if(board[x][y] == 0) return true;
  //     }
  //   }
  //   return false;
  // }

  //    A   B   C
  // 1  ? | ? | ?
  //   ---+---+---
  // 2  ? | ? | ?
  //   ---+---+---
  // 3  ? | ? | ?
  public void printBoard() {
    System.out.println("\u001b[37m   A   B   C");
    System.out.println("\u001b[37m1\u001b[0m  " + cellText(0,0) 
      + " | " + cellText(1,0) 
      + " | " + cellText(2,0));
    System.out.println("  ---+---+---");
    System.out.println("\u001b[37m2\u001b[0m  " + cellText(0,1) 
      + " | " + cellText(1,1) 
      + " | " + cellText(2,1));
    System.out.println("  ---+---+---");
    System.out.println("\u001b[37m3\u001b[0m  " + cellText(0,2) 
      + " | " + cellText(1,2) 
      + " | " + cellText(2,2));
  }
  
  // https://en.wikipedia.org/wiki/ANSI_escape_code#Colors
  private String cellText(int x, int y) {
    return Main.playerToText(board[x][y]);
  }
  
}
