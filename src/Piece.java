import java.util.*;

public class Piece {
  private String name;
  private int strength;
  public HashSet<String> moves;
  public int x;
  public int y;

  Piece(String name, int strength) {
    this.name = name;
    this.strength = strength;
  }

  void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int[] getPosition() {
    int[] value = new int[2];
    value[0] = x;
    value[1] = y;
    return value;
  }

  String getName() {
    return name;
  }

  int getStrength() {
    return strength;
  }

  void addMoves(HashSet<String> value) {
    this.moves = value;
  }
}
