package model;

import java.util.ArrayList;

public class CellImpl implements BetterCell {
  private final int state; // whether the current cell is on or off (if state is binary)
  private final int rule; // what numerical rule this cell follows

  public CellImpl(int state, int rule) {
    this.state = state;
    this.rule = rule;
  }

  @Override
  public BetterCell childCell(Cell left, Cell right) {
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


