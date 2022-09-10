import java.util.*;

public class Player {
  private String name;
  List<Piece> characters = new ArrayList<Piece>();
  private int times;

  public void play(String name) {
    this.name = name;
  }

  public String initializePiece(String piece, int x, int y) {
    if (piece.charAt(0) == 'P') {
      Piece newPiece = new Pawn(piece);
      newPiece.setPosition(x, y);
      characters.add(newPiece);
    } else if (piece.charAt(0) == 'H' && piece.charAt(1) == '1') {
      Piece newPiece = new Hero1(piece);
      newPiece.setPosition(x, y);
      characters.add(newPiece);
    } else if (piece.charAt(0) == 'H' && piece.charAt(1) == '2') {
      Piece newPiece = new Hero2(piece);
      newPiece.setPosition(x, y);
      characters.add(newPiece);
    } else if (piece.charAt(0) == 'H' && piece.charAt(1) == '3') {
      Piece newPiece = new Hero3(piece);
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

  public String makeMove(Piece piece, String move) {
    String kill = "false";
    int steps = 1;
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
        case "FL":
          move = "BR";
          break;
        case "FR":
          move = "BL";
          break;
        case "BL":
          move = "FR";
          break;
        case "BR":
          move = "FL";
          break;
        case "RF":
          move = "LB";
          break;
        case "RB":
          move = "LF";
          break;
        case "LF":
          move = "RB";
          break;
        case "LB":
          move = "RF";
          break;
      }
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
      } else if (move.equals("FL")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y - steps < 0 || piece.x == 0)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y - steps][piece.x - 1].equals("-"))
          if (App.grid[piece.y - steps][piece.x - 1].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (--piece.x) + ":" + (piece.y -= steps) + ":" + kill;
      } else if (move.equals("FR")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y - steps < 0 || piece.x == App.grid.length - 1)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y - steps][piece.x + 1].equals("-"))
          if (App.grid[piece.y - steps][piece.x + 1].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (++piece.x) + ":" + (piece.y -= steps) + ":" + kill;
      } else if (move.equals("BL")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y + steps > App.grid.length - 1 || piece.x == 0)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y + steps][piece.x - 1].equals("-"))
          if (App.grid[piece.y + steps][piece.x - 1].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (--piece.x) + ":" + (piece.y += steps) + ":" + kill;
      } else if (move.equals("BR")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y + steps > App.grid.length - 1 || piece.x == App.grid.length - 1)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y + steps][piece.x + 1].equals("-"))
          if (App.grid[piece.y + steps][piece.x + 1].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (++piece.x) + ":" + (piece.y += steps) + ":" + kill;
      } else if (move.equals("RF")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y == 0 || piece.x + steps > App.grid.length - 1)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y - 1][piece.x + steps].equals("-"))
          if (App.grid[piece.y - 1][piece.x + steps].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (piece.x += steps) + ":" + (--piece.y) + ":" + kill;
      } else if (move.equals("RB")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y == App.grid.length - 1 || piece.x + steps > App.grid.length - 1)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y + 1][piece.x + steps].equals("-"))
          if (App.grid[piece.y + 1][piece.x + steps].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (piece.x += steps) + ":" + (++piece.y) + ":" + kill;
      } else if (move.equals("LF")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y == 0 || piece.x - steps < 0)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y - 1][piece.x - steps].equals("-"))
          if (App.grid[piece.y - 1][piece.x - steps].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (piece.x -= steps) + ":" + (--piece.y) + ":" + kill;
      } else if (move.equals("LB")) {
        if (piece.getClass() == new Hero3("").getClass())
          steps = 2;
        if (piece.y == App.grid.length - 1 || piece.x - steps < 0)
          return "Character going out of grid bounds.";
        if (!App.grid[piece.y + 1][piece.x - steps].equals("-"))
          if (App.grid[piece.y + 1][piece.x - steps].split("-")[0].equals(name))
            return "Targeting a friendly character, i.e a character from our own team.";
          else
            kill = "true";
        return piece.x + ":" + piece.y + ":" + (piece.x -= steps) + ":" + (++piece.y) + ":" + kill;
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
