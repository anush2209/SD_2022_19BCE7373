import java.util.*;

public class Hero3 extends Piece {
  private String type = "Hero";
  private HashSet<String> moves = new HashSet<String>();

  public Hero3(String name) {
    super(name, 1);
    moves.add("FL");
    moves.add("FR");
    moves.add("BL");
    moves.add("BR");
    moves.add("RF");
    moves.add("RB");
    moves.add("LF");
    moves.add("LB");
    addMoves(moves);
  }

}
