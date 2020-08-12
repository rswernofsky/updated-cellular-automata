package model;

import java.util.ArrayList;

/**
 * Interface to represent a read-only version of a model. It offers getters for important aspects of
 * the model, particularly for the current generation of cells, and the stored previous generations
 * of cells.
 */
public interface ViewModel {

  /**
   * Returns the current {@link CellGeneration} of cells.
   *
   * @return the current cell generation of cells
   */
  CellGeneration getCurrentGeneration();

  /**
   * Returns a list of the prior {@link CellGeneration}s of cells.
   *
   * @return an arraylist of the previous generations of cells, with the most recent at the end
   */
  ArrayList<CellGeneration> getHistory();
}
