package edu.ntnu.idatt2003.cardgame;

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
   * Deals n random cards (without removing from the deck).
   * If you want "real" dealing, you can instead remove the cards you deal.
   */
  public HandOfCards dealHand(int n) {
    if (n < 1 || n > 52) {
      throw new IllegalArgumentException("n must be between 1 and 52");
    }

    // Trekker tilfeldig uten å endre kortstokken: shuffler kopi og tar første n
    List<PlayingCard> copy = new ArrayList<>(cards);
    
    Collections.shuffle(copy, random);

    return new HandOfCards(copy.subList(0, n));
  }
}