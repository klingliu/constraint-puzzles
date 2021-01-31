public class HitoriConstraints {

    public static boolean hasRepeatRow(HitoriSpot[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() == 0)
                for (int j = 0; j < row.length; j++) {
                    //System.out.println("index: " + i + ", " + j + "  val: " + row[j].getValue() + "  num: " + row[j].getNum());
                    if (i != j && row[j].getValue() == 0 && row[i].getNum() == row[j].getNum()) return true;
                }
        }
        return false;
    }

    public static boolean hasRepeatCol(HitoriSpot[][] spots, int colNum) {
        HitoriSpot[] col = new HitoriSpot[spots.length];
        for (int i = 0; i < spots.length; i++)
            col[i] = spots[i][colNum];
        return hasRepeatRow(col);
    }

    public static boolean hasAdjacentBlack(Hitori puzzle, int i, int j) { // do this per black spot
        HitoriSpot[][] spots = puzzle.getSpots();
        int max = spots.length - 1;
        if (i == 0 && j == 0) return (spots[i+1][j].getValue() == 1 || spots[i][j+1].getValue() == 1);
        else if (i == 0 && j == max) return (spots[i+1][j].getValue() == 1 || spots[i][j-1].getValue() == 1);
        else if (i == max && j == 0) return (spots[i-1][j].getValue() == 1 || spots[i][j+1].getValue() == 1);
        else if (i == 0)      return (spots[i+1][j].getValue() == 1 || spots[i][j+1].getValue() == 1 || spots[i][j-1].getValue() == 1);
        else if (j == 0)      return (spots[i][j+1].getValue() == 1 || spots[i+1][j].getValue() == 1 || spots[i-1][j].getValue() == 1);
        else if (i == max && j == max) return (spots[i-1][j].getValue() == 1 || spots[i][j-1].getValue() == 1);
        else if (i == max)    return (spots[i-1][j].getValue() == 1 || spots[i][j+1].getValue() == 1 || spots[i][j-1].getValue() == 1);
        else if (j == max)    return (spots[i][j-1].getValue() == 1 || spots[i+1][j].getValue() == 1 || spots[i-1][j].getValue() == 1);
        else return (spots[i][j+1].getValue() == 1 || spots[i][j-1].getValue() == 1
                    || spots[i+1][j].getValue() == 1 || spots[i-1][j].getValue() == 1);
    }

/*    public static boolean isContinuous2(Hitori puzzle) {
        HitoriSpot[][] spots = puzzle.getSpots();
        int count = howManyWhite(spots);
        int count2 = count;
        HitoriSpot firstWhite = null;
        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < spots.length; i++) {
            for(int j = 0; j < spots[i].length; j++) {
                if (spots[i][j].getValue() % 2 == 0) firstWhite = spots[i][j];
                x = i;
                y = j;
                break;
            }
            break;
        }
        while (count2 != 0) {
            for (int i = 0; i < spots.length; i++)
                for(int j = 0; j < spots[i].length; j++)
                    if (spots[i][j].getValue() % 2 == 0) {
                        x2 = i;
                        y2 = j;
                        count2--;
                    }
        }

        HitoriSpot[] whole = new HitoriSpot[25];
        HitoriSpot[] wholeContinuous = firstWhite.getContinuous(whole, spots, x, y, x2, y2);

        return (wholeContinuous.length == count);
    }*/


    public static boolean isContinuous(Hitori puzzle) {
        puzzle.resetSpots();
        HitoriSpot[][] spots = puzzle.getSpots();

        // iterate through all the spots to count how many white spots there are
        int count = howManyWhite(spots);

        // iterate through all the white spots again
        // if it's a white spot, if it has an unvisited white spot neighbor(getVisited = false && getValue % 2 == 0), count--; and move on
        // if at any point there are no unvisited white spot neighbors, you're isolated, so return false
        // if you get to the point where count == 1, return true

        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                //System.out.println(i + " " + j + " count: " + count);
                if (count == 1) {
                    return true;
                }
                else {
                    if (spots[i][j].getValue() % 2 == 0 && hasAdjacentWhite(spots, i, j)) { // if spot is white && has unvisited white neighbor(s)
                        spots[i][j].setVisited(true);
                        count--;
                    } else {
                        //System.out.println(i + " " + j);
                    }
                }
            }
        }
        //System.out.println(count);
        return false;
    }

    private static boolean hasAdjacentWhite(HitoriSpot[][] spots, int i, int j) {
        int max = spots.length - 1;
        if (i == 0 && j == 0) return (spots[i+1][j].getValue() % 2 == 0 && !spots[i+1][j].getVisited()
                                        || spots[i][j+1].getValue() % 2 == 0 && !spots[i][j+1].getVisited());
        else if (i == 0 && j == max)
            if (spots[1][max].getValue() == 1) return (spots[i][j-1].getValue() % 2 == 0);
            else return (spots[i+1][j].getValue() % 2 == 0 && !spots[i+1][j].getVisited()
                    || spots[i][j-1].getValue() % 2 == 0 && !spots[i][j-1].getVisited());
        else if (i == max && j == 0)
                              return (spots[i-1][j].getValue() % 2 == 0
                                        || spots[i][j+1].getValue() % 2 == 0 && !spots[i][j+1].getVisited());
        else if (i == max && j == max)
                              return (spots[i-1][j].getValue() % 2 == 0
                                        || spots[i][j-1].getValue() % 2 == 0);
        else if (i == 0)      return (spots[i+1][j].getValue() % 2 == 0 && !spots[i+1][j].getVisited()
                                        || spots[i][j+1].getValue() % 2 == 0 && !spots[i][j+1].getVisited()
                                        || spots[i][j-1].getValue() % 2 == 0 && !spots[i][j-1].getVisited());
        else if (j == 0)      return (spots[i+1][j].getValue() % 2 == 0 && !spots[i+1][j].getVisited()
                                        || spots[i][j+1].getValue() % 2 == 0 && !spots[i][j+1].getVisited()
                                        || spots[i-1][j].getValue() % 2 == 0 && !spots[i-1][j].getVisited());
        else if (i == max)    return (spots[i - 1][j].getValue() % 2 == 0
                                        || spots[i][j - 1].getValue() % 2 == 0
                                        || spots[i][j + 1].getValue() % 2 == 0);
        else if (j == max)    return (spots[i-1][j].getValue() % 2 == 0
                                        || spots[i][j-1].getValue() % 2 == 0
                                        || spots[i+1][j].getValue() % 2 == 0);
        else return (  spots[i-1][j].getValue() % 2 == 0 && !spots[i-1][j].getVisited()
                    || spots[i][j-1].getValue() % 2 == 0 && !spots[i][j-1].getVisited()
                    || spots[i+1][j].getValue() % 2 == 0 && !spots[i+1][j].getVisited()
                    || spots[i][j+1].getValue() % 2 == 0 && !spots[i][j+1].getVisited());
    }

    private static int howManyWhite(HitoriSpot[][] spots) {
        int count = 0;
        for (int i = 0; i < spots.length; i++)
            for (int j = 0; j < spots[i].length; j++)
                if (spots[i][j].getValue() % 2 == 0) count++;
        return count;
    }








}
