package model;

/**
 * Interface that dictates that all cells can get their current state (on/off),
 * and produce a child cell of itself given its left and right neighboring cells.
 */
public interface BetterCell {
  /**
   * Gets the state of this {@code model.Cell}. Returns 0 for an off cell, and 1 for an on cell.
   * @return
   */
  int getState();

  // TODO: indicate that all of the cells are the same type, and that type is a subclass of Cell
  /**
   * Produces the child cell of this {@code Cell} with the given left and right neighboring
   * {@code Cell}s (of the same type) based on the cellular automata rule for the cell type that
   * they all follow.
   * @param left the neighboring cell to the left of {@code this} cell
   * @param right the neighboring cell to the right of {@code this} cell
   * @return the corresponding child cell of this cell and its left and right neighbors using
   * this cell's automata rule.
   */
  // produces the child cell of this ICell with the given left and right neighbors
  BetterCell childCell(Cell left, Cell right);
}
