package controller;

import javax.swing.*;

import model.Model;
import view.View;

/**
 * Represents an implementation of a controller for a cellular automaton. It runs the reproduction
 * by handling interaction between the {@link model.Model} and the {@link view.View}.
 */
public class ControllerImpl implements Controller {
  Model world;
  View view;

  /**
   * Constructs a new controller implementation using the given model and view.
   * @param world the cellular automata model
   * @param view the cellular automata view
   */
  public ControllerImpl(Model world, View view) {
    this.world = world;
    this.view = view;
  }

  @Override
  public void run(int fps) {
    new Timer(1000 / fps, e -> {
      view.repaint();
      world.updateGeneration();
    }).start();
  }
}
