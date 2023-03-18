package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * The type Hand of cards.
 */
public class HandOfCards {
  private ArrayList<PlayingCard> hand;

  /**
   * Instantiates a new Hand of cards.
   *
   * @param dealHand the deal hand
   */
  public HandOfCards(ArrayList<PlayingCard> dealHand) {
    this.hand = dealHand;
  }

  /**
   * Player hand.
   *
   * @param handSize the hand size
   */
  public void playerHand (int handSize) {
    hand = DeckOfCards.dealHand(handSize);
  }

  /**
   * Gets hand.
   *
   * @return the hand
   */
  public ArrayList<PlayingCard> getHand() {
    return hand;
  }

  /**
   * Gets sum of hand.
   *
   * @return the sum of hand
   */
  public int getSumOfHand() {
    return hand.stream()
            .mapToInt(PlayingCard::getFace)
            .sum();
  }

  /**
   * Check flush boolean.
   *
   * @return the boolean
   */
  public boolean checkFlush () {
    return hand.stream()
            .allMatch(card -> card.getSuit() == hand.get(0).getSuit());
  }

  /**
   * Check hearts array list.
   *
   * @return the array list
   */
  public ArrayList<String> checkHearts () {
    return hand.stream()
            .filter(card -> card.getSuit() == 'H')
            .map(PlayingCard::getAsString)
            .collect(Collectors.toCollection(ArrayList::new));
  }

  /**
   * Check queen of spades boolean.
   *
   * @return the boolean
   */
  public boolean checkQueenOfSpades() {
    return hand.stream()
            .anyMatch(card -> card.getAsString().equals("S12"));
  }

  @Override
  public String toString() {
    return "HandOfCards{" +
            "hand=" + hand +
            '}';
  }
}