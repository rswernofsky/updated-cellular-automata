package model;

import java.util.ArrayList;

/**
 * Represents a single generation of cells, all in the same row, that has the ability to produce
 * a next generation based on its cell states.
 */
public class CellGeneration {

  // the current cells in this single row of cells
  private final ArrayList<Cell> cells;

  /**
   * Constructs a single generation of cells using the given input cells.
   * @param cells an array of cells in a single
   * @throws IllegalArgumentException if the given array of cells is null or contains no elements
   */
  public CellGeneration(ArrayList<Cell> cells) {
    if (cells == null || cells.size() < 1) {
      throw new IllegalArgumentException("A single generation of cells must contain at least one " +
              "cell.");
    }
    this.cells = cells;
  }

  /**
   * Returns a list of the cells in this generation of cells.
   * @return a list of cells in this generation of cells
   */
  public ArrayList<Cell> getCells() {
    return cells;
  }

  // returns a new CellArray containing the next generation of cells, based on
  // this CellArray's cells
  public CellGeneration nextGen() {
    ArrayList<Cell> result = new ArrayList<>();

    // add an inert cell at the beginning and end of the list of cells
    this.cells.add(0, new CellImpl(0,0));
    this.cells.add(new CellImpl(0,0));

    // loop though the cells of the original cells list (from before adding inert
    // cells at the beginning and end), and add the children to the result list
    for (int i = 1; i < this.cells.size() - 1; i += 1) {
      result.add(this.cells.get(i).childCell(this.cells.get(i - 1), this.cells.get(i + 1)));
    }

    // prevent inadvertent mutation
    this.cells.remove(0);
    this.cells.remove(this.cells.size() - 1);

    return new CellGeneration(result);
  }
}
