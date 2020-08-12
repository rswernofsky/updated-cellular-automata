package view;

import java.awt.*;

import model.Cell;
import model.CellGeneration;

/**
 * Adds drawing capabilities to {@link CellGeneration}s (allows them to act as {@link Drawable}s).
 */
public class DrawableGeneration implements Drawable {

  private final CellGeneration generation;
  private final int column;

  /**
   * Constructs a new drawable cell generation adaptation using the given column as a grid
   * coordinate.
   * @param generation the cell generation to draw
   * @param column the column to draw the generation at
   */
  public DrawableGeneration(CellGeneration generation, int column) {
    this.generation = generation;
    this.column = column;
  }

  @Override
  public void draw(Graphics g) {
    int row = 0;
    for (Cell cell : generation.getCells()) {
      new DrawableCellAdapter(cell, row, this.column).draw(g);
      row += 1;
    }
  }
}
