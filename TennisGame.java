package CleanCode;

public class TennisGame {

    public static final String ALL = "All";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";

    public static String getScore(int play1Score, int play2Score) {
        String score = "";
        if (play1Score == play2Score) {
            switch (play1Score) {
                case 0:
                    score = LOVE + ALL;
                    break;
                case 1:
                    score = FIFTEEN + ALL;
                    break;
                case 2:
                    score = THIRTY + ALL;
                    break;
                case 3:
                    score = FORTY + ALL;
                    break;
                default:
                    score = DEUCE;
                    break;

            }
        } else if (play1Score >= 4 || play2Score >= 4) {
            score = getString(play1Score, play2Score);
        } else {
            score = getString(play1Score, play2Score, score);
        }
        return score;
    }

    private static String getString(int play1Score, int play2Score) {
        String score;
        int minusResult = play1Score - play2Score;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String getString(int play1Score, int play2Score, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = play1Score;
            else {
                score += "-";
                tempScore = play2Score;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}