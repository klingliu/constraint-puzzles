public class HitoriNeighborSpot extends HitoriSpot {
    private int value;
    private int num;
    private boolean visited;
    private final int x;
    private final int y;

    public HitoriNeighborSpot(int num, int value, int x, int y) {
        super(num, value);
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setVisited(boolean visited)          { this.visited = visited; }
    public boolean getVisited()       { return this.visited; }

    public void setValue(int value) { this.value = value; }
    public int getValue()           { return this.value; }

    public int getNum() { return this.num; }

    public void unsetSpot() {
        this.setValue(2);
    }

}
