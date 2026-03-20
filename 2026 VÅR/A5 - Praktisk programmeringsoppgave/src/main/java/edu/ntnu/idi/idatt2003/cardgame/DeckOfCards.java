package edu.ntnu.idi.idatt2003.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private final List<PlayingCard> cards = new ArrayList<>(52);
    private final Random random;

    private static final char[] SUITS = {'S', 'H', 'D', 'C'};

    public DeckOfCards() {
        this(new Random());
    }

    public DeckOfCards(Random random) {
        this.random = random;

        for (char suit : SUITS) {
            for (int face = 1; face <= 13; face++) {
                cards.add(new PlayingCard(suit, face));
            }
        }
    }

    public int size() {
        return cards.size();
    }

    /**
     * Oppgave 3:
     * Deals n random cards (without removing from the deck).
     * For "real" dealing, we need to remove the cards while dealing.
     */
    public HandOfCards dealHand(int n) {
        if (n < 1 || n > 52) {
            throw new IllegalArgumentException("n must be between 1 and 52");
        }
        
        // Draws randomly without modifying the deck: shuffle a copy and take the first n
        List<PlayingCard> copy = new ArrayList<>(cards);

        Collections.shuffle(copy, random);

        return new HandOfCards(copy.subList(0, n));
    }
}