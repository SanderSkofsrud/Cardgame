package edu.ntnu.idatt2001;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class DeckOfCardsTest {

  @Nested
  class constructor {
    @Test
    @DisplayName("Test that constructor constructs object")
    void testThatConstructorConstructsObject() {
      DeckOfCards deck = new DeckOfCards();
      assertEquals(DeckOfCards.class, deck.getClass());
    }
  }

  @Nested
  class returnValues {
    @Test
    @DisplayName("Test that getPlayingCards returns correct ArrayList")
    void testThatGetPlayingCardsReturnsCorrectArrayList() {
      DeckOfCards deck = new DeckOfCards();
      assertEquals(52, deck.getPlayingCards().size());
    }

    @Test
    @DisplayName("Test that dealHand returns correct ArrayList")
    void testThatDealHandReturnsCorrectArrayList() {
      DeckOfCards deck = new DeckOfCards();
      assertEquals(5, deck.dealHand(5).size());
    }

    @Test
    @DisplayName("Test that dealHand throws IllegalArgumentException when numberOfCards is not valid")
    void testThatDealHandThrowsIllegalArgumentExceptionWhenNumberOfCardsIsNotValid() {
      DeckOfCards deck = new DeckOfCards();
      assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
    }
  }

  @Nested
  class functionality {
    @Test
    @DisplayName("Test that dealHand removes cards from deck")
    void testThatDealHandRemovesCardsFromDeck() {
      DeckOfCards deck = new DeckOfCards();
      deck.dealHand(5);
      assertEquals(47, deck.getPlayingCards().size());
    }
  }
}
