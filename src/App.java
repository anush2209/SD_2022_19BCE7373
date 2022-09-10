import java.util.*;

public class App {
    static String[][] grid = new String[5][5];

    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        System.out.println("App: Hello, World!");
        Player player1 = new Player();
        Player player2 = new Player();
        player1.play("A");
        player2.play("B");
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], "-");
        }
        System.out.print("Player1 Input: ");
        String input = read.nextLine();
        String[] pieces = input.split(", ");
        for (int i = 0; i < pieces.length; i++)
            addGrid(player1.initializePiece(pieces[i], i, grid.length - 1), grid.length - 1, i);
        System.out.print("Player2 Input: ");
        input = read.nextLine();
        pieces = input.split(", ");
        for (int i = 0; i < pieces.length; i++)
            addGrid(player2.initializePiece(pieces[i], i, 0), 0, i);
        while (player1.getPiecesLeft() > 0 && player2.getPiecesLeft() > 0) {
            displayGrid(grid);
            String player1Message = "";
            String moveInput = "";
            while (!player1Message.contains(":")) {
                System.out.print("Player A’s Move: ");
                moveInput = read.nextLine();
                player1Message = player1.makeMove(moveInput);
                // System.out.println(player1Message + " " + player1.getPiecesLeft());
            }
            String[] directions = player1Message.split(":");
            if (directions[4].equals("true"))
                player2.killPiece(grid[Integer.parseInt(directions[3])][Integer.parseInt(directions[2])].split("-")[1]);
            grid[Integer.parseInt(directions[3])][Integer.parseInt(directions[2])] = player1.getName() + "-"
                    + moveInput.split(":")[0];
            grid[Integer.parseInt(directions[1])][Integer.parseInt(directions[0])] = "-";
            displayGrid(grid);
            String player2Message = "";
            while (!player2Message.contains(":")) {
                System.out.print("Player B’s Move: ");
                moveInput = read.nextLine();
                player2Message = player2.makeMove(moveInput);
                // System.out.println(player2Message + " " + player2.getPiecesLeft());
            }
            directions = player2Message.split(":");
            if (directions[4].equals("true"))
                player1.killPiece(grid[Integer.parseInt(directions[3])][Integer.parseInt(directions[2])].split("-")[1]);
            grid[Integer.parseInt(directions[3])][Integer.parseInt(directions[2])] = player2.getName() + "-"
                    + moveInput.split(":")[0];
            grid[Integer.parseInt(directions[1])][Integer.parseInt(directions[0])] = "-";

        }
    }

    private static void addGrid(String value, int i, int j) {
        grid[i][j] = value;
    }

    private static void displayGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
