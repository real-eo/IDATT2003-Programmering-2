package edu.ntnu.idi.idatt2003.cardgame;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  @Test
  void constructor_creates52Cards() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.size());
  }

  @Test
  void dealHand_invalidN_throws() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
  }

  @Test
  void dealHand_returnsCorrectSize() {
    DeckOfCards deck = new DeckOfCards(new Random(123)); // deterministisk
    HandOfCards hand = deck.dealHand(5);
    assertEquals(5, hand.getCards().size());
  }
}