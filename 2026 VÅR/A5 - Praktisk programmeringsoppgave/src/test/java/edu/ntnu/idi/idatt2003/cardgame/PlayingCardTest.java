package edu.ntnu.idi.idatt2003.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

  @Test
  void constructor_invalidSuit_throws() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('X', 1));
  }

  @Test
  void constructor_invalidFace_throws() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 0));
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 14));
  }

  @Test
  void equals_sameSuitAndFace_true() {
    assertEquals(new PlayingCard('S', 12), new PlayingCard('S', 12));
  }
}