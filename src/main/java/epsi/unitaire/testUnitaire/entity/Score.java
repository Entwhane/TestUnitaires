package epsi.unitaire.testUnitaire.entity;

public class Score {
    private int playerScore;
    private int computerScore;
    private int draws;

    public Score() {
        playerScore = 0;
        computerScore = 0;
        draws = 0;
    }

    public void incrementPlayerScore() {
        playerScore++;
    }

    public void incrementComputerScore() {
        computerScore++;
    }

    public void incrementDraws() {
        draws++;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getDraws() {
        return draws;
    }

    public String score() {
        return "Joueur : " + this.getPlayerScore() + " / Ordinateur : " + this.getComputerScore() + " / Egalité : " + this.getDraws();
    }

    public void reset() {
        playerScore = 0;
        computerScore = 0;
        draws = 0;
    }
}
