package edu.ntnu.idatt2001;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class PlayingCardTest {

  @Nested
  class constructor {
    @Test
    @DisplayName("Test that constructor constructs object")
    void testThatConstructorConstructsObject() {
      PlayingCard card = new PlayingCard('H', 1);
      assertEquals(PlayingCard.class, card.getClass());
    }

    @Test
    @DisplayName("Test that constructor throws IllegalArgumentException when suit is not valid")
    void testThatConstructorThrowsIllegalArgumentExceptionWhenSuitIsNotValid() {
      assertThrows(IllegalArgumentException.class, () -> new PlayingCard('X', 1));
    }

    @Test
    @DisplayName("Test that constructor throws IllegalArgumentException when face is not valid")
    void testThatConstructorThrowsIllegalArgumentExceptionWhenFaceIsNotValid() {
      assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 0));
    }
  }

  @Nested
  class returnValues {
    @Test
    @DisplayName("Test that getAsString returns correct string")
    void testThatGetAsStringReturnsCorrectString() {
      PlayingCard card = new PlayingCard('H', 1);
      assertEquals("H1", card.getAsString());
    }

    @Test
    @DisplayName("Test that getSuit returns correct suit")
    void testThatGetSuitReturnsCorrectSuit() {
      PlayingCard card = new PlayingCard('H', 1);
      assertEquals('H', card.getSuit());
    }

    @Test
    @DisplayName("Test that getFace returns correct face")
    void testThatGetFaceReturnsCorrectFace() {
      PlayingCard card = new PlayingCard('H', 1);
      assertEquals(1, card.getFace());
    }
  }
}