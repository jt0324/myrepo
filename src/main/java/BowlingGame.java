public class BowlingGame {

    /**
     * To get score
     *
     * @param str
     * @return
     */
    public int[][] getScore(String str) {
        int[][] score = new int[11][2];
        String[] strs = str.split("\\|");
        if (strs.length == 12) {
            strs[10] = strs[11];
        }
        for (int i = 0; i < 10; ++i) {
            String s = strs[i];
            if ("X".equals(s)) {
                score[i][0] = 10;
                score[i][1] = -1;
            } else {
                if (s.charAt(0) != '-')
                    score[i][0] = (s.charAt(0) - '0');
                if (s.charAt(1) == '/') {
                    score[i][1] = (10 - score[i][0]);
                } else if (s.charAt(1) == '-') {
                    score[i][1] = 0;
                } else {
                    score[i][1] = (s.charAt(1) - '0');
                }
            }
        }
        if (strs.length > 10) {
            String s = strs[10];
            if (s.charAt(0) == 'X') {
                score[10][0] = 10;
            } else {
                score[10][0] = (s.charAt(0) - '0');
            }
            if (s.length() > 1) {
                if (s.charAt(1) == 'X') {
                    score[10][1] = 10;
                } else {
                    score[10][1] = (s.charAt(1) - '0');
                }
            }
        }
        return score;
    }
    public int getBowlingScore(String bowlingCode) {

        int sum = 0;
        int[][] score = getScore(bowlingCode);

        for (int i = 0; i < 10; i++) {
            int first = score[i][0];
            int second = score[i][1];
            sum += first;
            if (first == 10) {
                sum += score[i + 1][0];
                if (score[i + 1][1] == -1) {
                    sum += score[i + 2][0];
                } else {
                    sum += score[i + 1][1];
                }
            } else {
                sum += second;
                if (first + second == 10) {
                    sum += score[i + 1][0];
                }
            }
        }
        return sum;
    }
}
