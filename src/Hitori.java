import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hitori extends Puzzle implements ActionListener {
    private final int[][] puzzleGrid = {{4, 2, 4, 4, 5},
                                        {5, 4, 2, 3, 4},
                                        {2, 3, 1, 1, 4},
                                        {1, 1, 3, 5, 5},
                                        {1, 5, 2, 2, 3} };
    private HitoriSpot[][] spots;
    private HitoriFrame frame;
    private int[] possibleValues = {0, 1};
    private int gridSize = 5;

    public Hitori(HitoriFrame frame, boolean solver) {
        this.frame = frame;
        if (solver) setSpotsSolver();
        else setSpots();
    }

    public Hitori() { }

    @Override
    public void setSpots() {
        spots = new HitoriSpot[puzzleGrid.length][puzzleGrid[0].length];
        for (int i = 0; i < puzzleGrid.length; i++) {
            for (int j = 0; j < puzzleGrid[i].length; j++) {
                spots[i][j] = new HitoriSpot(puzzleGrid[i][j], 0);
            }
        }
    }

    @Override
    public void setSpotsSolver() {
        spots = new HitoriSpot[puzzleGrid.length][puzzleGrid[0].length];
        for (int i = 0; i < puzzleGrid.length; i++) {
            for (int j = 0; j < puzzleGrid[i].length; j++) {
                spots[i][j] = new HitoriSpot(puzzleGrid[i][j], 2);
            }
        }
    }

    @Override
    public void resetSpots() {
        for (int i = 0; i < spots.length; i++)
            for (int j = 0; j < spots[i].length; j++)
                spots[i][j].setVisited(false);
    }

    public int[][] getPuzzleGrid() { return this.puzzleGrid; }
    public HitoriSpot[][] getSpots() { return this.spots; }

    @Override
    public int checkRestraints() {
        // have a for loop that checks every spot's neighbor status (if there are adjacent shaded squares)
        for (int i = 0; i < spots.length; i++)
            for (int j = 0; j < spots[i].length; j++)
                if (spots[i][j].getValue() == 1 && HitoriConstraints.hasAdjacentBlack(this, i, j))
                    return -1;

        // checks if the entire puzzle's white spots are continuous
        if (!HitoriConstraints.isContinuous(this)) return -2;

        // checks if grid has any repeated elements within each row
        for (int i = 0; i < spots.length; i++)
            if (HitoriConstraints.hasRepeatRow(spots[i])) return -3;

        // checks if grid has any repeated elements within each column
        for (int i = 0; i < spots.length; i++)
            if (HitoriConstraints.hasRepeatCol(spots, i)) return -4;

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        // check and set a message
        int right = checkRestraints();
        if (right == 0) {
            frame.setDoneMessage("congratulations!"); // in this game if all constraints are satisfied, the puzzle's solved
        }
        else {
            if (right == -1) frame.setMessage("black squares are touching");
            if (right == -2) frame.setMessage("white squares not continuous");
            if (right == -3) frame.setMessage("row has repeat numbers");
            if (right == -4) frame.setMessage("column has repeat numbers");
        }
        frame.repaint();
    }

    /*@Override
    public SolverPanel getSolverPanel(int value, int num) {
        return new HitoriSolverPanel(value, num);
    }*/

    public int[] getPossibleValues() { return this.possibleValues; }

    @Override
    public JButton createButton(int i, int j, Spot spot) {
        HitoriButton button = new HitoriButton(this.getPuzzleGrid()[i][j]);
        button.setSpot((HitoriSpot) spot);
        if (button.getSpot().getValue() == 1) button.setButtonBlack();
        return button;
    }
}
