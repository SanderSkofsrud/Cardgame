package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  ArrayList<PlayingCard> deck = new ArrayList<>();

  public DeckOfCards() {
    for (int i = 0; i < suits.length; i++) {
      for (int j = 1; j <= 13; j++) {
        PlayingCard card = new PlayingCard(suits[i], j);
        deck.add(card);
      }
    }
  }

  public ArrayList<PlayingCard> dealHand(int n) {
    ArrayList<PlayingCard> hand = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      hand.add(deck.remove(new Random().nextInt(deck.size())));
    }
    return hand;
  }
}
