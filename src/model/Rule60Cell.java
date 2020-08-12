package model;

/**
 * Represents a cell that follows the 60 numerical rule.
 */
public class Rule60Cell extends AbstractCell {
  public Rule60Cell(int row, int col, int state) {
    super(row, col, state, 60);
  }

  @Override
  public Cell produceCell(int state) {
    return new Rule60Cell(this.row + 1, this.col, state);
  }
}
