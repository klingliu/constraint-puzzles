import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Solver extends JFrame implements ActionListener {
    private Puzzle puzzle;
    private Spot[][] grid;
    private int[] possibleValues;
    int loopCount = 0;

    public Solver(Puzzle puzzle) {
        this.puzzle = puzzle;
        this.grid = puzzle.getSpots();
        this.possibleValues = puzzle.getPossibleValues();
    }

    public boolean label(int row, int col) {
        loopCount++;
        if (row == grid.length) {
            return (puzzle.checkRestraints() == 0);
        }
        else if (grid[row][col].isPrefilled()) {
            int newcol = col + 1;
            int newrow = row;
            if (newcol == grid[row].length) {
                newcol = 0;
                newrow++;
            }
            if (label(newrow, newcol)) return true;
        }
        else {
            for (int v : possibleValues) {
                //System.out.println("row: " + row + " col: " + col + " V IS NOW " + v);
                grid[row][col].setValue(v);
                boolean check = (puzzle.checkRestraints() >= 0);
                //System.out.println("CHECK RESULT: " + check + " CHECKRESTRAINTS VAL: " + puzzle.checkRestraints());
                if (check) {
                    int newcol = col + 1;
                    int newrow = row;
                    //System.out.println("newcol " + newcol);
                    if (newcol == grid[row].length) {
                        newcol = 0;
                        newrow++;
                        //System.out.println("row " + newrow);
                    }
                    if (label(newrow, newcol))
                        return true; // and then you can use the labelled grid to make jpanels to add to 5x5 grid
                }
            }
        }
        if (!grid[row][col].isPrefilled()) grid[row][col].unsetSpot();
        return false;

    }

    public void actionPerformed(ActionEvent e) {
        if (this.label(0,0)) {
            createFrame();
            System.out.println(loopCount);
        }
    }

    public void createFrame() {
        int size = grid.length;
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(size, size));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = puzzle.createButton(i, j, grid[i][j]);
                button.setEnabled(false);
                frame.add(button);
            }
        }
        frame.pack();
        frame.setPreferredSize(new Dimension(600,600));
        frame.setVisible(true);
        frame.repaint();
    }




}
