package epsi.unitaire.testUnitaire.controller;

import epsi.unitaire.testUnitaire.entity.Score;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

import java.util.*;

@RestController
@RequestMapping(path="/game")
public class GameController {

    Score score = new Score();

    @RequestMapping(path = "/play/{action}", method = RequestMethod.GET)
    public String playPawn(@PathVariable("action") String action) {
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        String result = "";

        int computerChoice = random.nextInt(choices.length);
        String userChoice = action;

        if (userChoice.equals(choices[computerChoice])) {
            result = ("fait égalité !");
            this.score.incrementDraws();
        } else if (userChoice.equals("rock")) {
            if (choices[computerChoice].equals("scissors")) {
                result = ("gagné !");
                this.score.incrementPlayerScore();
            } else {
                result = ("perdu !");
                this.score.incrementComputerScore();
            }
        } else if (userChoice.equals("paper")) {
            if (choices[computerChoice].equals("rock")) {
                result = ("gagné !");
                this.score.incrementPlayerScore();
            } else {
                result = ("perdu !");
                this.score.incrementComputerScore();
            }
        } else if (userChoice.equals("scissors")) {
            if (choices[computerChoice].equals("paper")) {
                result = ("gagné !");
                this.score.incrementPlayerScore();
            } else {
                result = ("perdu !");
                this.score.incrementComputerScore();
            }
        } else {
            return "Choix incorrect";
        }
        return "Vous avez joué" + action + ", l'ordinateur a joué" + choices[computerChoice] + ", " + result;
    }

    @RequestMapping(path = "/restart", method = RequestMethod.POST)
    public void restartGame() {
        this.score.reset();
    }

    @RequestMapping(path = "/score", method = RequestMethod.GET)
    public String showScore() {
        return this.score.score();
    }

    @RequestMapping(path = "/score/{win}/{lose}/{tie}", method = RequestMethod.PUT)
    public String putScore(@PathVariable("win") String win, @PathVariable("lose") String lose, @PathVariable("tie") String tie) {
        return "test";
    }
}

