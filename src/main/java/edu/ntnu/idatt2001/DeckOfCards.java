package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
  private static final ArrayList<PlayingCard> playingCards = new ArrayList<>();

  public DeckOfCards(){
    fillDeck();
  }
  void fillDeck(){
    if (!playingCards.isEmpty()){
      playingCards.clear();
    }
    for (int i = 1; i < 14; i++){
      playingCards.add(new PlayingCard('S',i));
      playingCards.add(new PlayingCard('H',i));
      playingCards.add(new PlayingCard('D',i));
      playingCards.add(new PlayingCard('C',i));
    }
  }

  public ArrayList<PlayingCard> getPlayingCards() {
    return playingCards;
  }

  public static ArrayList<PlayingCard> dealHand(int numberOfCards){
    if (numberOfCards < 1 || numberOfCards > 52){
      throw new IllegalArgumentException("numberOfCards has to be between 1 and 52");
    }
    ArrayList<PlayingCard> hand = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < numberOfCards; i++){
      PlayingCard playingCard = playingCards.get(random.nextInt(playingCards.size()));
      hand.add(new PlayingCard(playingCard.getSuit(), playingCard.getFace()));
      playingCards.remove(playingCard);
    }
    return hand;
  }
}

