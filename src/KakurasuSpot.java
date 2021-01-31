public class KakurasuSpot extends Spot {
    private int value;
    private final int row;
    private final int col;

    public KakurasuSpot(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public int getValue() { return this.value; }
    public void setValue(int value) { this.value = value; }

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }

    @Override
    public void unsetSpot() {
        this.setValue(2);
    }

}
