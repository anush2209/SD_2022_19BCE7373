import java.util.*;

public class Hero2 extends Piece {
  private String type = "Hero2";
  private HashSet<String> moves = new HashSet<String>();

  public Hero2(String name) {
    super(name, 2);
    moves.add("FL");
    moves.add("FR");
    moves.add("BL");
    moves.add("BR");
    addMoves(moves);
  }

}
