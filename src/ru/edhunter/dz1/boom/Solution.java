package ru.edhunter.dz1.boom;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Game newGame = new Game();
        newGame.init();
        newGame.start();
        newGame.printResult();
    }

    static class Game {
        private int curRound = 1;
        private int nOfTeams;
        private int nOfCards;
        private int turnTimer;
        List<Team> teams;
        ArrayDeque<Card> cards;

        void init() throws FileNotFoundException {
            Scanner scanner = new Scanner(System.in);
//            Scanner scanner = new Scanner(new File("E:\\IDEA\\edhunter\\src\\ru\\edhunter\\dz1\\boom\\test"));
            String[] gameProperties = scanner.nextLine().split(" ");
            nOfTeams = Integer.parseInt(gameProperties[0]);
            turnTimer = Integer.parseInt(gameProperties[1]);
            teams = formTeams(scanner, nOfTeams);
            nOfCards = Integer.parseInt(scanner.nextLine());
            cards = formCards(scanner, nOfCards);
        }

        private ArrayDeque<Card> formCards(Scanner scanner, int nOfCards) {
            ArrayDeque<Card> cards = new ArrayDeque<>();
            for (int i = 0; i < nOfCards; i++) {
                cards.addLast(new Card(scanner.nextLine(), Integer.parseInt(scanner.nextLine())));
            }
            return cards;
        }

        private List<Team> formTeams(Scanner scanner, int nOfTeams) {
            List<Team> teams = new ArrayList<>();
            for (int i = 0; i < nOfTeams; i++) {
                String[] playerProperties = scanner.nextLine().split(" ");
                int p1Understanding = Integer.parseInt(playerProperties[0]);
                int p1Explaining = Integer.parseInt(playerProperties[1]);
                int p2Understanding = Integer.parseInt(playerProperties[2]);
                int p2Explaining = Integer.parseInt(playerProperties[3]);
                Player newPlayer1 = new Player(p1Understanding, p1Explaining);
                Player newPlayer2 = new Player(p2Understanding, p2Explaining);
                teams.add(new Team(newPlayer1, newPlayer2, i));
            }
            return teams;
        }

        void start() {
            while (cards.size() > 0) {
                for (Team team : teams) {
                    team.makeTurn(cards, turnTimer, curRound);
                }
                curRound++;
            }
        }

        void printResult() {
            for (Team team : teams) {
                System.out.print(team.doneCards.size() + " ");
                for (Card card : team.doneCards) {
                    System.out.print(card.word + " ");
                }
                System.out.println();
            }
        }
    }
}

class Team {
    private int id;
    private Player[] players = new Player[2];
    List<Card> doneCards = new ArrayList<>();
    private HashMap<Card, Integer> unDoneCards = new HashMap<>(
    );

    Team(Player playerOne, Player playerTwo, int id) {
        players[0] = playerOne;
        players[1] = playerTwo;
        this.id = id;
    }

    void makeTurn(ArrayDeque<Card> cards, int turnTimer, int curRound) {
        int timer = turnTimer;
        int explain = players[curRound % 2].explaining;
        int understand = players[1 - curRound % 2].understanding;
        while (!cards.isEmpty() && timer > 0) {
            int cardProgress = 0;
            Card card = cards.pollFirst();
            if (unDoneCards.containsKey(card)) cardProgress = unDoneCards.get(card);

            int needTime = getNeededTime(explain,
                    understand,
                    card.difficulty,
                    cardProgress);

            if (needTime <= timer) {
                timer -= needTime;
                if (unDoneCards.containsKey(card)) unDoneCards.remove(card);
                doneCards.add(card);
            } else {
                cardProgress += timer;
                unDoneCards.put(card, cardProgress);
                timer = 0;
                cards.addLast(card);
            }
        }
    }

    private int getNeededTime(int explain, int understand, int difficulty, int cardProgress) {
        return Math.max(1, difficulty - explain - understand - cardProgress);
    }
}


class Player {
    int understanding;
    int explaining;

    Player(int understanding, int explaining) {
        this.understanding = understanding;
        this.explaining = explaining;
    }
}


class Card {
    String word;
    int difficulty;

    Card(String word, int difficulty) {
        this.word = word;
        this.difficulty = difficulty;
    }
}