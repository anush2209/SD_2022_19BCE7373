# SD_2022_19BCE7373

## Installation

Use the code editor [vscode](https://code.visualstudio.com/) with [Project Manager for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency) extension to run.

## Structure
```bash
SD_2022_19BCE7373
|   .gitattributes
|   .gitignore
|   README.md # This file
|
+---.vscode
|       settings.json
|
+---lib # Dependency files
\---src # Source files
        App.java # Main App with Players, Pieces and Grid (with display and changes).
        Hero1.java # Extends Piece with Hero1 properties (name, strength and moves).
        Hero2.java # Extends Piece with Hero2 properties (name, strength and moves).
        Hero3.java # Extends Piece with Hero3 properties (name, strength and moves).
        Pawn.java # Extends Piece with Pawn properties (name, strength and moves).
        Piece.java # Used to initialize Pieces and get/set properties.
        Player.java # Used to initialize Players, make moves and kill Pieces.
```
