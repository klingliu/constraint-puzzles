import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Skyscraper extends Puzzle implements ActionListener {
    private SkySpot[][] spots;
    private SkyFrame frame;
    private int[] possibleValues = {1,2,3,4,5};
    private final int[] topInstances = new int[5];
    private final int[] botInstances = new int[5];
    private final int[] leftInstances = new int[5];
    private final int[] rightInstances = new int[5];

    Scanner scan = new Scanner(new java.io.FileReader("skyInstances.txt"));

    public Skyscraper(SkyFrame frame) throws FileNotFoundException {
        this.frame = frame;
        for (int i = 0; i < topInstances.length; i++) {
            topInstances[i] = scan.nextInt();
        }
        for (int i = 0; i < botInstances.length; i++) {
            botInstances[i] = scan.nextInt();
        }
        for (int i = 0; i < leftInstances.length; i++) {
            leftInstances[i] = scan.nextInt();
        }
        for (int i = 0; i < rightInstances.length; i++) {
            rightInstances[i] = scan.nextInt();
        }
        setSpots();
    }

    @Override
    public void setSpots() {
        spots = new SkySpot[5][5];
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                if (i == 3 && j == 1) {
                    spots[i][j] = new SkySpot(5);
                    spots[i][j].setPrefilled();
                }
                else spots[i][j] = new SkySpot(0);
            }
        }
    }

    public SkySpot[][] getSpots() { return this.spots; }

    public int[] getTopInstances() {
        return topInstances;
    }
    public int[] getBotInstances() {
        return botInstances;
    }
    public int[] getLeftInstances() { return leftInstances; }
    public int[] getRightInstances() { return rightInstances; }

    @Override
    public int checkRestraints() {
        for (int i = 0; i < spots.length; i++) {
            if (SkyConstraints.hasRepeatRow(spots[i])) return -1;
            if (SkyConstraints.hasRepeatCol(spots, i)) return -2;
            if (SkyConstraints.orderedRow(spots[i], leftInstances[i]) != 0) return 3;
            if (SkyConstraints.orderedRowReverse(spots[i], rightInstances[i]) != 0) return 3;
            if (SkyConstraints.orderedCol(spots, i, topInstances[i]) != 0) return 4;
            if (SkyConstraints.orderedColReverse(spots, i, botInstances[i]) != 0) return 4;
        }
        /*for (int i = 0; i < spots.length; i++) {
            if (SkyConstraints.orderedRow(spots[i], leftInstances[i]) == 1) return 3;
            if (SkyConstraints.orderedRowReverse(spots[i], rightInstances[i]) == 1) return 3;
            if (SkyConstraints.orderedCol(spots, i, topInstances[i]) == 1) return 4;
            if (SkyConstraints.orderedColReverse(spots, i, botInstances[i]) == 1) return 4;
        }*/
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
            if (right == -1 || right == 1) frame.setMessage("repeat in row");
            if (right == -2 || right == 2) frame.setMessage("repeat in column");
            if (right == -3 || right == 3) frame.setMessage("row: skyscrapers not in order");
            if (right == -4 || right == 4) frame.setMessage("column: skyscrapers not in order");
        }
        frame.repaint();
    }

    public int[] getPossibleValues() { return this.possibleValues; }

    @Override
    public JButton createButton(int i, int j, Spot spot) {
        SkyButton button = new SkyButton();
        button.setSpot((SkySpot) spot);
        return button;
    }

}
