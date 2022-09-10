import java.util.*;

public class Pawn extends Piece {
  private String type = "Pawn";
  private HashSet<String> moves = new HashSet<String>();

  public Pawn(String name) {
    super(name);
    moves.add("L");
    moves.add("R");
    moves.add("B");
    moves.add("F");
    addMoves(moves);
  }

}
