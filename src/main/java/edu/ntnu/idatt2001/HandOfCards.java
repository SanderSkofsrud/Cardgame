package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class HandOfCards {
  List<PlayingCard> hand;

  public void PlayerHand (int handSize) {
    DeckOfCards deck = new DeckOfCards();
    hand = new ArrayList<>();
    hand = deck.dealHand(handSize);
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  public int getSumOfHand() {
    return hand.stream()
      .mapToInt(PlayingCard::getFace)
      .sum();
  }

  public boolean checkFlush () {
    return hand.stream()
      .filter(card -> card.getSuit() == hand.get(0).getSuit())
      .toList().size() == 5;

    //return hand.stream().allMatch(card -> card.getSuit() == hand.get(0).getSuit());
  }

  public ArrayList<PlayingCard> checkHearts () {
    //List<PlayingCard> hearts = hand.stream()
    //  .filter(card -> card.getSuit() == 'H')
    //  .toList();
    //return (ArrayList<PlayingCard>) hearts;

    return hand.stream()
      .filter(card -> card.getSuit() == 'H')
      .collect(Collectors.toCollection(ArrayList::new));
  }

  //public boolean checkQueenOfSpades () {
  //     return hand.stream()
  //    .filter(card -> card.getSuit() == 'S' && card.getFace() == 12)
  //    .toList().size() == 1;
  //}

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
