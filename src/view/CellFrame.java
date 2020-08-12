package view;

import java.awt.*;

import javax.swing.*;

import model.CellGeneration;
import model.ViewModel;

import static cellularAutomata.CellularAutomata.TOTAL_HEIGHT;
import static cellularAutomata.CellularAutomata.TOTAL_WIDTH;

/**
 * Class that visually represents a cellular automaton stored in a {@link model.Model} using JPanel
 * and Java's Swing graphics.
 */
public class CellFrame extends JFrame implements View {

  /**
   * Constructs a new visual view of a cellular automaton using the given read-only version of a
   * cellular automata model.
   *
   * @param viewModel a read-only version of a cellular automata model
   */
  public CellFrame(ViewModel viewModel) {
    if (viewModel == null) {
      throw new IllegalArgumentException("The model view shouldn't be null!");
    }

    add(new CellPanel(viewModel));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }


  /**
   * Represents a single {@link JPanel} that renders a cellular automata by drawing a {@link
   * ViewModel}'s generations with different colors depending on state.
   */
  private class CellPanel extends JPanel {
    private final ViewModel viewModel;

    /**
     * Constructs a new CellPanel using the given {@link ViewModel}.
     *
     * @param viewModel a read-only version of a cellular automata model
     */
    public CellPanel(ViewModel viewModel) {
      this.viewModel = viewModel;
      setPreferredSize(new Dimension(TOTAL_WIDTH, TOTAL_HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      int column = 0;
      for (CellGeneration gen : viewModel.getHistory()) {
        new DrawableGeneration(gen, column).draw(g);
        column += 1;
      }
      new DrawableGeneration(viewModel.getCurrentGeneration(), column).draw(g);
    }
  }
}
