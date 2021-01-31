public class HitoriSpot extends Spot {
    private int value;
    private int num;
    private boolean visited;
    private int index = 0;

    public HitoriSpot(int num, int value) {
        this.num = num;
        this.value = value;
        this.visited = false;
    }

    public void setVisited(boolean visited)          { this.visited = visited; }
    public boolean getVisited()       { return this.visited; }

    public void setValue(int value) { this.value = value; }
    public int getValue()           { return this.value; }

    public int getNum() { return this.num; }

    @Override
    public void unsetSpot() {
        this.setValue(2);
    }


    /* recursive
    public HitoriSpot[] getContinuous(HitoriSpot[] whole, HitoriSpot[][] spots, int i, int j, int a, int b) { // first called on the first white spot
        this.setVisited(true); // sets the spot to true
        if (i == a && j == b) return whole; // if the spot is black by any chance, return whole
        whole[index] = this; // otherwise, add the white spot to the array of continuous white spots
        this.setNeighbors(spots, i, j);
        for (HitoriNeighborSpot n : neighbors) { // now look at the white spots neighbors
            if (!n.getVisited() && n.getValue() != 1) { // the first unvisited white neighbor is of consequence
                index++; // increment the index for adding elements in the recursive call
                n.getContinuous(whole, spots, n.getX(), n.getY(), a, b); // do the recursive call on the neighbor of consequence
            }

        }
        return whole;
    }*/

    /*
    public void addNeighbor(int index, HitoriSpot toAdd, int x, int y) {
        System.out.println(index + " " + toAdd.getNum() + " " + toAdd.getValue() + " " + x + " " + y);
        this.neighbors[index] = new HitoriNeighborSpot(toAdd.getNum(), toAdd.getValue(), x, y);
    }

    public void setNeighbors(HitoriSpot[][] spots, int i, int j) {
        int max = spots.length - 1;
        if (i == 0 && j == 0) {
            neighbors = new HitoriNeighborSpot[2];
            this.addNeighbor(0, spots[i+1][j], i+1, j);
            this.addNeighbor(1, spots[i][j+1], i, j+1);
        }
        else if (i == 0 && j == max) {
            neighbors = new HitoriNeighborSpot[2];
            this.addNeighbor(0, spots[i+1][j], i+1, j);
            this.addNeighbor(1, spots[i][j-1], i, j-1);
        }
        else if (i == max && j == 0) {
            neighbors = new HitoriNeighborSpot[2];
            this.addNeighbor(0, spots[i-1][j], i-1, j);
            this.addNeighbor(1, spots[i][j+1], i, j+1);
        }
        else if (i == max && j == max) {
            neighbors = new HitoriNeighborSpot[2];
            this.addNeighbor(0, spots[i-1][j], i-1, j);
            this.addNeighbor(1, spots[i][j-1], i, j-1);
        }
        else if (i == 0) {
            neighbors = new HitoriNeighborSpot[3];
            this.addNeighbor(0, spots[i+1][j], i+1, j);
            this.addNeighbor(1, spots[i][j-1], i, j-1);
            this.addNeighbor(2, spots[i][j+1], i, j+1);
        }
        else if (j == 0) {
            neighbors = new HitoriNeighborSpot[3];
            this.addNeighbor(0, spots[i-1][j], i-1, j);
            this.addNeighbor(1, spots[i][j+1], i, j+1);
            this.addNeighbor(2, spots[i+1][j], i+1, j);
        }
        else if (i == max) {
            neighbors = new HitoriNeighborSpot[3];
            this.addNeighbor(0, spots[i-1][j], i-1, j);
            this.addNeighbor(1, spots[i][j-1], i, j-1);
            this.addNeighbor(2, spots[i][j+1], i, j+1);
        }
        else if (j == max) {
            neighbors = new HitoriNeighborSpot[3];
            this.addNeighbor(0, spots[i-1][j], i-1, j);
            this.addNeighbor(1, spots[i][j-1], i, j-1);
            this.addNeighbor(2, spots[i+1][j], i+1, j);
        }
        else {
            neighbors = new HitoriNeighborSpot[4];
            this.addNeighbor(0, spots[i-1][j], i-1, j);
            this.addNeighbor(1, spots[i][j-1], i, j-1);
            this.addNeighbor(2, spots[i+1][j], i+1, j);
            this.addNeighbor(3, spots[i][j+1], i, j+1);
        }
    }

    public HitoriNeighborSpot[] getNeighbors() {
        return neighbors;
    }*/

}
