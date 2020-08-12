package model;

/**
 * Interface that dictates that all cells can get their current state (on/off),
 * and produce a child cell of itself given its left and right neighboring cells.
 */
public interface Cell {
  /**
   * Returns the state of this {@code Cell}. Returns 0 for an off cell, and 1 for an on cell.
   * @return the state of this cell
   */
  int getState();

  /**
   * Produces the child cell of this {@code Cell} with the same rule, using the given left and
   * right neighboring {@code Cell}s based on the cellular automata rule for the cell type that
   * they all follow.
   * @param left the neighboring cell to the left of {@code this} cell
   * @param right the neighboring cell to the right of {@code this} cell
   * @return the corresponding child cell of this cell and its left and right neighbors using
   * this cell's automata rule.
   */
  Cell childCell(Cell left, Cell right);
}
