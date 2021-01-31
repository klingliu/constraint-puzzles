public class SkySpot extends Spot {
    private int value;

    public SkySpot(int value) {
        this.value = value;
    }
    public int getValue() { return this.value; }
    public void setValue(int value) { this.value = value; }

    @Override
    public void unsetSpot() {
        this.setValue(0);
    }
}
