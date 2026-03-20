package edu.ntnu.idi.idatt2003.cardgame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

  @Test
  void sumFaces_sumsCorrectly() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 1),
        new PlayingCard('S', 13),
        new PlayingCard('D', 5)
    ));
    assertEquals(19, hand.sumFaces());
  }

  @Test
  void heartsAsStringOrNoHearts_noHearts() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('S', 1),
        new PlayingCard('D', 2)
    ));
    assertEquals("No Hearts", hand.heartsAsStringOrNoHearts());
  }

  @Test
  void containsQueenOfSpades_trueWhenPresent() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('S', 12),
        new PlayingCard('H', 2)
    ));
    assertTrue(hand.containsQueenOfSpades());
  }

  @Test
  void hasFiveCardFlush_trueWhenAtLeastFiveSameSuit() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 1),
        new PlayingCard('H', 2),
        new PlayingCard('H', 3),
        new PlayingCard('H', 4),
        new PlayingCard('H', 5)
    ));
    assertTrue(hand.hasFiveCardFlush());
  }
}