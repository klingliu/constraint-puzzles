public class SkyConstraints {
    public static boolean hasRepeatRow(SkySpot[] row) {
        //System.out.println("repeat row");
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() != 0)
                for (int j = 0; j < row.length; j++) {
                    if (i != j && row[i].getValue() == row[j].getValue()) return true;
                }
        }
        return false;
    }

    public static boolean hasRepeatCol(SkySpot[][] spots, int colNum) {
        //System.out.println("repeat col");
        SkySpot[] col = new SkySpot[spots.length];
        for (int i = 0; i < spots.length; i++)
            col[i] = spots[i][colNum];
        return hasRepeatRow(col);
    }

    public static int orderedRow(SkySpot[] row, int seen) {
        //System.out.println("unordered row " + seen);
        int max = 0;
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() != 0)
                //System.out.print(row[i].getValue() + " " + max + "   ");
                if (row[i].getValue() > max) {
                    max = row[i].getValue();
                    count++;
                    //System.out.println(count);
                } //else System.out.println();
        }
        return Integer.compare(seen, count); // return 1 if seen (actual) is bigger
    }

    public static int orderedRowReverse(SkySpot[] row, int seen) {
        //System.out.println("ordered row reverse " + seen);
        int max = 0;
        int count = 0;
        for (int i = row.length - 1; i >= 0; i--) {
            if (row[i].getValue() != 0)
                //System.out.print(row[i].getValue() + " " + max + "   ");
                if (row[i].getValue() > max) {
                    max = row[i].getValue();
                    count++;
                    //System.out.println(count);
                } //else System.out.println();
        }
        return Integer.compare(seen, count);
    }

    public static int orderedCol(SkySpot[][] spots, int colNum, int seen) {
        //System.out.println("unordered column " + seen);
        SkySpot[] col = new SkySpot[spots.length];
        for (int i = 0; i < spots.length; i++)
            col[i] = spots[i][colNum];
        return orderedRow(col, seen);
    }

    public static int orderedColReverse(SkySpot[][] spots, int colNum, int seen) {
        //System.out.println("ordered column reverse " + seen);
        SkySpot[] col = new SkySpot[spots.length];
        for (int i = 0; i < spots.length; i++)
            col[i] = spots[i][colNum];
        return orderedRowReverse(col, seen);
    }


}
