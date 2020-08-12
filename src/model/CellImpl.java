package model;

import java.util.ArrayList;

/**
 * Represents a generic cell, which has a state (on/off), and a reproductive rule which
 * determines how its children are produced (in combination with its right and left neighbors).
 * It has the ability to create a child cell when given a right/left neighbor, and tell others
 * its state.
 */
public class CellImpl implements Cell {
  private final int state; // whether the current cell is on or off (if state is binary)
  private final int rule; // what numerical rule this cell follows

  /**
   * Constructs a cell using the given state and reproductive rule.
   * @param state the state of the cell (0 if off, and 1 if on)
   * @param rule the reproductive rule of the cell
   */
  public CellImpl(int state, int rule) {
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

    return new CellImpl(ruleList.get(left.getState() * 4
            + this.getState() * 2 + right.getState()), this.rule);
  }

  @Override
  public int getState() {
    return this.state;
  }

}


