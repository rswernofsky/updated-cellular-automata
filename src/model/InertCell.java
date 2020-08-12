package model;

/**
 * Represents a cell that is always off.
 */
public class InertCell extends AbstractCell {

  public InertCell(int row, int col) {
    super(row, col, 0, 0);
  }

  @Override
  public Cell produceCell(int state) {
    return new InertCell(this.row + 1, this.col);
  }
}