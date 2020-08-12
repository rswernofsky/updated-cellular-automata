package model;

import java.util.ArrayList;

public abstract class AbstractCell implements Cell {
  protected final int row;
  protected final int col;
  private final int state; // whether the current cell is on or off (if state is binary)
  private final int rule; // what numerical rule this cell follows

  public AbstractCell(int row, int col, int state, int rule) {
    this.row = row;
    this.col = col;
    this.state = state;
    this.rule = rule;
  }

  @Override
  public Cell childCell(Cell left, Cell right) {
    ArrayList<Integer> ruleList = new ArrayList<>();
    int temprule = this.rule;

    // create an 8-bit backwards binary representation of this cell's rule
    while (ruleList.size() < 8) {
      if ((temprule > 0) && (temprule % 2 == 0)) {
        ruleList.add(0);
        temprule = temprule / 2;
      } else if ((temprule > 0) && (temprule % 2 == 1)) {
        ruleList.add(1);
        temprule = (temprule - 1) / 2;
      } else {
        ruleList.add(0);
      }
    }

    return this.produceCell(ruleList.get(left.getState() * 4
            + this.getState() * 2 + right.getState()));
  }

  /**
   * Creates a {@link Cell} of this type with the given state in the row below.
   * @param state the state that the child cell should have
   */
  public abstract Cell produceCell(int state);

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return col;
  }

  @Override
  public int getState() {
    return this.state;
  }

}
