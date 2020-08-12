package view;

import java.awt.*;

/**
 * Represents a cell that can be drawn in Swing.
 */
public interface Drawable {

  /**
   * Draws this {@code model.Cell} as a square Swing image that's black if the cell is on,
   * and white if it's off.
   *
   * @param g a Graphics object that this cell will be drawn onto
   */
  void draw(Graphics g);

}
