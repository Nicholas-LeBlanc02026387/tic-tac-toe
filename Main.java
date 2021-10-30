import java.util.Scanner;

class Main {
  private static Scanner sc;
  private static Board board;

  public static void main(String[] args) {
    board = new Board();
    sc = new Scanner(System.in);
    
    int player = 1;
    // at most 9 turns
    for(int i = 0; i < 9; i++) {
      doTurn(player);
      int win = board.testWin();
      if(win != 0) {
        board.printBoard();
        System.out.println("Player " + playerToText(win) + " wins!");
        return;
      }
      player = 3 - player;
    }
    board.printBoard();
    System.out.println("It's a tie!");
  }

  public static void doTurn(int player) {
    board.printBoard();
    while(true) {
      System.out.print(playerToText(player) + " > ");
      String code = sc.nextLine();
      int[] xy = parseXY(code);
      int x = xy[0], y = xy[1];
      if(board.get(x, y) == 0) {
        board.set(x, y, player);
        break;
      }
      System.out.println("Space occupied.");
    }

  }

  // A1 ... C3
  public static int[] parseXY(String code) {
    if(code.equalsIgnoreCase("flip the table")) {
      System.out.println("It's a tie!");
      flipTheTable(); 
    }
    int x = code.codePointAt(0) - 65;
    int y = code.codePointAt(1) - 49;
    return new int[]{x, y};
  }

  private static void flipTheTable() {
    System.out.println("It's a tie!");
    flipTheTable();
  }

  public static String playerToText(int player) {
    if(player == 0) return " ";
    else if(player == 1) return "\u001b[92mX\u001b[0m";
    else return "\u001b[91mO\u001b[0m";
  }
}