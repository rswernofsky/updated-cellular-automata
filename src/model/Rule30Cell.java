package model;

/**
 * Represents a cell that follows the 30 numerical rule.
 */
public class Rule30Cell extends AbstractCell {
  public Rule30Cell(int row, int col, int state) {
    super(row, col, state, 30);
  }

  @Override
  public Cell produceCell(int state) {
    return new Rule30Cell(this.row + 1, this.col, state);
  }
}


//TODO:

//// a cell that follows the 182 numerical rule
//class Rule182 extends ACell {
//
//  // constructor
//  Rule182(int state) {
//    super(state, 182);
//  }
//
//  // creates a cell of the Rule82 type with the given state
//  ICell produceCell(int i) {
//    return new Rule182(i);
//  }
//}
//
//// a cell that follows the 54 numerical rule
//class Rule54 extends ACell {
//
//  // constructor
//  Rule54(int state) {
//    super(state, 54);
//  }
//
//  // creates a cell of the Rule54 type with the given state
//  ICell produceCell(int i) {
//    return new Rule54(i);
//  }
//}
