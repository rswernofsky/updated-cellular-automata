package view;

import java.awt.*;

import model.Cell;

import static cellularAutomata.CellularAutomata.CELL_SIZE;

/**
 * Adds drawing capabilities to {@link Cell}s (allows them to act as {@link Drawable}s).
 */
public class DrawableCellAdapter implements Drawable {

  private final Cell cell;
  private final int row;
  private final int col;

  /**
   * Constructs a new drawable cell adaptation using the given location in grid coordinates.
   * @param cell the cell to draw
   * @param row the row to draw the cell at
   * @param col the column to draw the cell at
   */
  public DrawableCellAdapter(Cell cell, int row, int col) {
    this.cell = cell;
    this.row = row;
    this.col = col;
  }

  @Override
  public void draw(Graphics g) {
    int cellState = cell.getState();
    if (cellState == 1) {
      g.setColor(Color.BLACK);
    } else if (cellState == 0) { // in the future the state could be another value
      g.setColor(Color.WHITE);
    }
    g.fillRect(row * CELL_SIZE, col * CELL_SIZE, CELL_SIZE, CELL_SIZE);
  }
}
