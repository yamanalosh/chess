
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
     return null;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    // the queens can move one piece forward and two pieces forward.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      //check for in bounds, other pieces in your way
      ArrayList<Square> returnList = new ArrayList<Square>();
      for (int i = 0; i < 7; i++) {
        for (int j = start.getCol(); j < 8; j++) {
          if (b.getSquareArray()[i][start.getCol()].isOccupied() == false) {
            if (i == start.getRow() - 1 || i == start.getRow() - 2) {
              returnList.append(b.getSquareArray()[i][start.getCol()]);
          }
        }
        else if (i == start.getRow() - 1) {
            returnList.append(b[i][start.getCol()]);
        }
    }
}
return returnList;
    }
  }