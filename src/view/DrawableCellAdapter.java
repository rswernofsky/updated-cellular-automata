package view;

import java.awt.*;

import model.Cell;

/**
 * Adds drawing capabilities to {@link model.Cell}s (allows them to act as {@link DrawableCell}s).
 */
public class DrawableCellAdapter implements DrawableCell {

  private final Cell cell;
  public static final int CELL_SIZE = 20;
  private final int row;
  private final int col;

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
