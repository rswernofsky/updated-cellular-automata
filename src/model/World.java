package model;

import java.util.ArrayList;

/**
 * Represents a world of cells, with a current cell generation and previous cell generations.
 */
public class World implements Model {

  public static final int NUM_HISTORY = 41;

  // the current generation of cells
  private CellGeneration curGen;
  // the history of previous generations (earliest state at the start of the list)
  private ArrayList<CellGeneration> history;

  /**
   * Constructs a world with the given current generation and no previous generations.
   * @param curGen the current cell generation
   */
  public World(CellGeneration curGen) {
    this.curGen = curGen;
    this.history = new ArrayList<>();
  }

  /**
   * Convenience constructor that creates a world with the given current generation of cells and
   * an array of previous generations, with most recent generations at the end.
   * @param curGen the current cell generation
   * @param history an array of previous cell generations
   */
  public World(CellGeneration curGen, ArrayList<CellGeneration> history) {
    this.curGen = curGen;
    this.history = history;
  }

  @Override
  public CellGeneration getCurrentGeneration() {
    return curGen;
  }

  @Override
  public ArrayList<CellGeneration> getHistory() {
    return history;
  }

  @Override
  public void updateGeneration() {
    // remove the oldest generation from history if history is about to be larger
    // than the screen
    if (this.history.size() >= NUM_HISTORY) {
      this.history.remove(0);
    }
    this.history.add(this.curGen);
    this.curGen = this.curGen.nextGen();
  }
}
