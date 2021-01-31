import javax.swing.*;

public abstract class Puzzle {
    private int gridSize;
    private Spot[][] spots;
    private int[] possibleValues;

    public void setSpots() {   }

    public void setSpotsSolver() {  }

    public void resetSpots() { }

    public void unsetSpot() { }

    public Spot[][] getSpots() { return this.spots; }

    public int[] getPossibleValues() { return this.possibleValues; }

    public JButton createButton(int i, int j, Spot spot) { return new JButton(); }

    public int checkRestraints() {
        return 5;
    }

    public int getGridSize() {
        return gridSize;
    }


}