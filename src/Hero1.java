import java.util.*;

public class Hero1 extends Piece {
  private String type = "Hero";
  private HashSet<String> moves = new HashSet<String>();

  public Hero1(String name) {
    super(name, 2);
    moves.add("L");
    moves.add("R");
    moves.add("B");
    moves.add("F");
    addMoves(moves);
  }

}
