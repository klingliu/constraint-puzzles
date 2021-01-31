public class Spot {
    private int value;
    private int num;
    private boolean prefilled = false;

    public int getValue() { return this.value; }
    public void setValue(int i) { this.value = i; }

    public int getNum() { return this.num; }

    public void unsetSpot() { }

    public void setPrefilled() { prefilled = true; }

    public boolean isPrefilled() {
        return prefilled;
    }
}
