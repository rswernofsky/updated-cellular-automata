package controller;


/**
 * Represents a controller for a cellular automaton. It has the ability to run the reproduction with
 * a given speed.
 */
public interface Controller {

  /**
   * Starts and runs the animation with the given speed.
   *
   * @param fps the speed of the animation in frames per second (fps)
   */
  void run(int fps);
}
