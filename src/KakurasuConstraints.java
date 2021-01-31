public class KakurasuConstraints {

    public static int isCorrectRow(KakurasuSpot[] row, int trueSum) {
        //System.out.println("row" + trueSum);
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() == 1) {
                sum = sum + row[i].getCol();
                //System.out.println(i + " " + sum);
            }
        }
        return Integer.compare(trueSum, sum); // 1 if trueSum is bigger, -1 if smaller
    }

    public static int isCorrectCol(KakurasuSpot[][] spots, int colNum, int trueSum) {
        //System.out.println("col" + trueSum);
        KakurasuSpot[] col = new KakurasuSpot[spots.length];
        for (int i = 0; i < spots.length; i++) {
            col[i] = spots[i][colNum];
        }
        int sum = 0;
        for (int i = 0; i < col.length; i++) {
            if (col[i].getValue() == 1) {
                sum = sum + col[i].getRow();
                //System.out.println(i + " " + sum);
            }
        }
        return Integer.compare(trueSum, sum);
    }


}
