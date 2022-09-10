import java.util.*;

public class Player {
  private String name;
  private List<Piece> characters = new ArrayList<Piece>();

  public void play(String name) {
    this.name = name;
  }

  public String initializePiece(String piece, int x, int y) {
    if (piece.charAt(0) == 'P') {
      Piece newPiece = new Pawn(piece);
      newPiece.setPosition(x, y);
      characters.add(newPiece);
    }
    return name + "-" + piece;
  }

  public String getName() {
    return name;
  }

  public int getPiecesLeft() {
    return characters.size();
  }

  public String makeMove(String input) {
    String characterName = input.split(":")[0];
    String move = input.split(":")[1];
    if (name == "B")
      switch (move) {
        case "F":
          move = "B";
          break;
        case "B":
          move = "F";
          break;
        case "L":
          move = "R";
          break;
        case "R":
          move = "L";
          break;
      }
    Piece piece = null;
    String kill = "false";
    for (int i = 0; i < characters.size(); i++)
      if (characters.get(i).getName().equals(characterName))
        piece = characters.get(i);
    if (piece != null) {
      if (!piece.moves.contains(move))
        return "Invalid move presented for a given character.";
      if (move.equals("L")) {
        if (piece.x == 0)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y][piece.x - 1].equals("-"))
          if (App.grid[piece.y][piece.x - 1].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (--piece.x) + ":" + piece.y + ":" + kill;
      } else if (move.equals("R")) {
        if (piece.x == App.grid.length - 1)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y][piece.x + 1].equals("-"))
          if (App.grid[piece.y][piece.x + 1].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (++piece.x) + ":" + piece.y + ":" + kill;
      } else if (move.equals("F")) {
        if (piece.y == 0)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y - 1][piece.x].equals("-"))
          if (App.grid[piece.y - 1][piece.x].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + piece.x + ":" + (--piece.y) + ":" + kill;
      } else if (move.equals("B")) {
        if (piece.y == App.grid.length - 1)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y + 1][piece.x].equals("-"))
          if (App.grid[piece.y + 1][piece.x].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + piece.x + ":" + (++piece.y) + ":" + kill;
      } else if (move.equals("")) {

      } else if (move.equals("")) {

      } else if (move.equals("")) {

      } else if (move.equals("")) {

      }
    } else
      return "Input command on a character that does not exist";
    return "Invalid moves for a player";
  }

  public void killPiece(String value) {
    Piece piece = null;
    for (int i = 0; i < characters.size(); i++) {
      // System.out.println(characters.get(i).getName() + " " +
      // characters.get(i).getName().equals(value));
      if (characters.get(i).getName().equals(value))
        piece = characters.get(i);
    }
    characters.remove(piece);
  }
}
