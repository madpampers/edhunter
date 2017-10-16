package ru.edhunter.dz1.boom;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(new FileReader("E:\\IDEA\\edhunter\\src\\main\\java\\ru\\edhunter\\dz1\\boom\\test"));
        final Game newGame = new Game(scanner);
        newGame.start();
        newGame.printResult();
    }
}

class Game {
    private final int nOfTeams;
    private final int turnTimer;
    private final int nOfCards;
    private final List<Team> teams;
    private final Deque<Card> cards;

    Game(Scanner scanner) {
        DataReader.setScanner(scanner);
        this.nOfTeams = DataReader.getTeamsNumber();
        this.turnTimer = DataReader.getTimer();
        this.teams = createTeams();
        this.nOfCards = DataReader.getCardsNumber();
        this.cards = createCards();
    }

    private List<Team> createTeams() {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < nOfTeams; i++) {
            teams.add(new Team(new Player(), new Player()));
        }
        return teams;
    }

    private Deque<Card> createCards() {
        Deque<Card> cards = new ArrayDeque<>();
        for (int i = 0; i < nOfCards; i++) {
            cards.addLast(new Card(DataReader.getNextCard(), DataReader.getCardDifficulty()));
        }
        return cards;
    }

    void start() {
        while (cards.size() > 0) {
            for (Team team : teams) {
                team.makeTurn(cards, turnTimer);
            }
        }
    }

    void printResult() {
        for (Team team : teams) {
            System.out.print(team.doneCards.size());
            for (Card card : team.doneCards) {
                System.out.print(" " + card.word);
            }
            System.out.println();
        }
    }


    private static class Team {
        private Player activePlayer;
        private Player passivePlayer;
        private List<Card> doneCards = new ArrayList<>();
        private Map<Card, Integer> unDoneCards = new HashMap<>();

        Team(Player playerOne, Player playerTwo) {
            activePlayer = playerTwo;
            passivePlayer = playerOne;
        }

        private void onEndOfTurn() {
            Player player = activePlayer;
            activePlayer = passivePlayer;
            passivePlayer = player;
        }

        void makeTurn(final Deque<Card> cards, final int turnTimer) {
            int timer = turnTimer;
            while (!cards.isEmpty() && timer > 0) {
                int cardProgress = 0;
                Card card = cards.pollFirst();
                if (unDoneCards.containsKey(card)) cardProgress = unDoneCards.get(card);

                int needTime = getNeededTime(
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
            this.onEndOfTurn();
        }

        private int getNeededTime(final int difficulty, final int cardProgress) {
            return Math.max(1, difficulty - activePlayer.explaining - passivePlayer.understanding - cardProgress);
        }
    }


    private static class Player {
        int understanding;
        int explaining;

        Player() {
            this.understanding = DataReader.getUnderstanding();
            this.explaining = DataReader.getExplaining();
        }

        @Override
        public String toString() {
            return understanding + ", " + explaining;
        }
    }


    private static class Card {
        final String word;
        final int difficulty;

        Card(final String word, final int difficulty) {
            this.word = word;
            this.difficulty = difficulty;
        }
    }
}

class DataReader {

    static void setScanner(Scanner scanner) {
        DataReader.scanner = scanner;
    }

    private static Scanner scanner;

    static int getTeamsNumber() {
        return scanner.nextInt();
    }

    static int getTimer() {
        int timer = scanner.nextInt();
        scanner.nextLine();
        return timer;
    }

    static int getUnderstanding() {
        return scanner.nextInt();
    }

    static int getExplaining() {
        return scanner.nextInt();
    }

    static int getCardsNumber() {
        scanner.nextLine();
        return Integer.parseInt(scanner.nextLine());
    }

    static String getNextCard() {
        return scanner.nextLine();
    }

    static int getCardDifficulty() {
        return Integer.parseInt(scanner.nextLine());
    }
}
