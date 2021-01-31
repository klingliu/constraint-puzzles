import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kakurasu extends Puzzle implements ActionListener {
    private KakurasuSpot[][] spots;
    private KakurasuFrame frame;
    private int[] possibleValues = {0, 1};
    private final int gridSize = 5;
    private final int[] rowInstances;
    private final int[] colInstances;

    Scanner scan = new Scanner(new java.io.FileReader("kakurasuInstances.txt"));

    public Kakurasu(KakurasuFrame frame, boolean solver) throws FileNotFoundException {
        this.frame = frame;
        rowInstances = new int[5];
        colInstances = new int[5];
        for (int i = 0; i < colInstances.length; i++) {
            colInstances[i] = scan.nextInt();
        }
        for (int i = 0; i < rowInstances.length; i++) {
            rowInstances[i] = scan.nextInt();
        }
        if (solver) setSpotsSolver();
        else setSpots();
    }

    @Override
    public void setSpots() {
        spots = new KakurasuSpot[5][5];
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                spots[i][j] = new KakurasuSpot(0,i+1, j+1);
            }
        }
    }

    @Override
    public void setSpotsSolver() {
        spots = new KakurasuSpot[5][5];
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                spots[i][j] = new KakurasuSpot(0,i+1,j+1);
            }
        }
    }

    public KakurasuSpot[][] getSpots() { return this.spots; }

    public int[] getRowInstances() {
        return rowInstances;
    }

    public int[] getColInstances() {
        return colInstances;
    }

    @Override
    public int checkRestraints() {
        // checking if rows and cols sum up to too big
        for (int i = 0; i < spots.length; i++) {
            if (KakurasuConstraints.isCorrectRow(spots[i], rowInstances[i]) == -1) return -1;
            if (KakurasuConstraints.isCorrectCol(spots, i, colInstances[i]) == -1) return -2;
        }
        // checking if rows and cols sum up to too small
        for (int i = 0; i < spots.length; i++) {
            if (KakurasuConstraints.isCorrectRow(spots[i], rowInstances[i]) == 1 ) return 1;
            if (KakurasuConstraints.isCorrectCol(spots, i, colInstances[i]) == 1 ) return 2;
        }

        return 0;

    }

    private int count = 0;
    public void actionPerformed(ActionEvent e) {
        // check and set a message
        int right = checkRestraints();
        if (right == 0) {
            frame.setDoneMessage("congratulations!"); // in this game if all constraints are satisfied, the puzzle's solved
        }
        else {
            if (right == -1 || right == 1) frame.setMessage("rows do not sum properly");
            if (right == -2 || right == 2) frame.setMessage("columns do not sum properly");
        }
        frame.repaint();
    }

    public int[] getPossibleValues() { return this.possibleValues; }

    @Override
    public JButton createButton(int i, int j, Spot spot) {
        KakurasuButton button = new KakurasuButton();
        button.setSpot((KakurasuSpot) spot);
        if (button.getSpot().getValue() == 1) button.setButtonBlack();
        return button;
    }
}
