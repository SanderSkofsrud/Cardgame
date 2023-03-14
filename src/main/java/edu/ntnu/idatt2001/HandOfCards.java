package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class HandOfCards {
  private ArrayList<PlayingCard> hand;

  public HandOfCards(ArrayList<PlayingCard> dealHand) {
    this.hand = dealHand;
  }

  public void playerHand (int handSize) {
    hand = DeckOfCards.dealHand(handSize);
  }

  public ArrayList<PlayingCard> getHand() {
    return hand;
  }

  public int getSumOfHand() {
    return hand.stream()
            .mapToInt(PlayingCard::getFace)
            .sum();
  }

  public boolean checkFlush () {
    return hand.stream()
            .allMatch(card -> card.getSuit() == hand.get(0).getSuit());
  }

  public ArrayList<String> checkHearts () {
    return hand.stream()
            .filter(card -> card.getSuit() == 'H')
            .map(PlayingCard::getAsString)
            .collect(Collectors.toCollection(ArrayList::new));
  }

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