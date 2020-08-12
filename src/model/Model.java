package model;

/**
 * Interface representing the model for a cellular automaton. This is built upon the read-only
 * interface for a model, ViewModel. This interface adds capability to create the next
 * generation (while still storing the previous generations in history).
 */
public interface Model extends ViewModel {
  /**
   * Adds the current generation to the history and sets the current generation to the next one.
   */
  public void updateGeneration();
}
