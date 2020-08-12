package cellularAutomata;

import java.util.ArrayList;

import controller.ControllerImpl;
import model.Cell;
import model.CellGeneration;
import model.CellImpl;
import model.World;
import view.CellFrame;

import static model.World.NUM_HISTORY;

/**
 * Runs the cellular automata using MVC architecture!
 */
public class CellularAutomata {

  // constants
  public static final int CELL_SIZE = 10;
  public static final int INITIAL_OFF_CELLS = 20;
  public static final int TOTAL_CELLS = INITIAL_OFF_CELLS * 2 + 1;
  public static final int TOTAL_WIDTH = TOTAL_CELLS * CELL_SIZE;
  public static final int TOTAL_HEIGHT = NUM_HISTORY * CELL_SIZE;

  /**
   * Runs the cellular automata using command-line arguments.
   *
   * @param args command-line arguments. The first item should be an integer representing the rule
   *             for cellular recreation
   */
  public static void main(String[] args) {
    int rule = Integer.parseInt(args[0]);

    // Constructs a Controller with INITIAL_OFF_CELLS of off cells on the left,
    // then one on cell, then INITIAL_OFF_CELLS of off cells on the right
    ArrayList<Cell> cells = new ArrayList<>();
    cells.add(new CellImpl(1, rule)); // on
    for (int i = 0; i < INITIAL_OFF_CELLS; i += 1) {
      cells.add(0, new CellImpl(0, rule)); // off
      cells.add(new CellImpl(0, rule)); // off
    }
    World world = new World(new CellGeneration(cells));

    new ControllerImpl(world, new CellFrame(world)).run(4);
  }

}
