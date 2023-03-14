package edu.ntnu.idatt2001;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class CardGame extends Application {
  DeckOfCards deckOfCards = new DeckOfCards();
  HandOfCards handOfCards = new HandOfCards(DeckOfCards.dealHand(5));
  Button dealHand = new Button("Deal hand");
  Button shuffle = new Button("Shuffle");
  Button enter = new Button("Enter");
  Label sum = new Label("Sum of cards : " + handOfCards.getSumOfHand());
  Text flush = new Text("Flush : " + handOfCards.checkFlush());
  Text hearts = new Text("Check hearts : " + handOfCards.checkHearts());
  Text queenOfSpades = new Text("Check Queen of Spades : " + handOfCards.checkQueenOfSpades());
  StackPane entrance = new StackPane();
  StackPane main = new StackPane();
  StackPane root = new StackPane();

  /**
   * The main method of the application.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Overrides the start() method which takes a single parameter stage.
   * Uses the show() method to display the stage.
   *
   * @param primaryStage Stage to show
   */
  @Override
  public void start(Stage primaryStage) {
    Image entranceImage = new Image("/entrance.png", true);
    ImageView entranceImageView = new ImageView(entranceImage);
    Image enteranceOpenImage = new Image("/entranceOpen.png", true);
    ImageView entranceOpenImageView = new ImageView(enteranceOpenImage);
    enter.setStyle("-fx-font-size: 15px; -fx-min-width: 115px; -fx-min-height: 40px; -fx-background-color: #9FB8AD; -fx-border-width: 2; -fx-background-radius: 5em;");
    entrance.getChildren().addAll(entranceOpenImageView, entranceImageView, enter);
    ScaleTransition stStart = new ScaleTransition(Duration.millis(3000), entranceOpenImageView);
    stStart.setByX(50f);
    stStart.setByY(50f);
    FadeTransition ftStart = new FadeTransition(Duration.millis(3000), entranceImageView);
    ftStart.setFromValue(1.0);
    ftStart.setToValue(0.0);
    Image image = new Image("/casino.png", true);
    BackgroundImage imageView = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, true));
    Image hand = new Image("/hand.png", true);
    ImageView handImageView = new ImageView(hand);
    VBox vBox = new VBox();
    vBox.getChildren().add(handImageView);
    vBox.setAlignment(Pos.CENTER_LEFT);
    Rectangle rectangle = new Rectangle(850, 500);
    rectangle.setFill(Color.GREEN);
    rectangle.setStroke(Color.BLACK);
    rectangle.setStrokeWidth(5);
    rectangle.setArcHeight(250);
    rectangle.setArcWidth(250);
    HBox hBox = new HBox(5);
    hBox.setSpacing(35);
    for (int i = 0; i < 5; i++) {
      hBox.getChildren().add(rectangle());
    }
    hBox.setAlignment(Pos.CENTER);
    HBox cards = new HBox();
    VBox results = new VBox();
    results.setAlignment(Pos.CENTER_LEFT);
    dealHand.setStyle("-fx-font-size: 15px; -fx-min-width: 115px; -fx-min-height: 40px; -fx-background-color: #9FB8AD; -fx-border-width: 2; -fx-background-radius: 5em;");
    shuffle.setStyle("-fx-font-size: 15px; -fx-min-width: 115px; -fx-min-height: 40px; -fx-background-color: #9FB8AD; -fx-border-width: 2; -fx-background-radius: 5em;");
    dealHand.setDisable(false);
    shuffle.setDisable(true);
    dealHand.setOnAction(e -> {
      cards.getChildren().clear();
      handOfCards.playerHand(5);
      cards.getChildren().add(getCards(5));
      results.getChildren().clear();
      results.getChildren().add(results());
    });
    shuffle.setOnAction(e -> {
      deckOfCards.fillDeck();
      dealHand.setDisable(false);
      shuffle.setDisable(true);
    });
    HBox buttons = new HBox();
    buttons.getChildren().addAll(dealHand, shuffle);
    buttons.setSpacing(60);
    buttons.setAlignment(Pos.BOTTOM_CENTER);
    cards.setAlignment(Pos.CENTER);
    cards.setSpacing(60);
    main.getChildren().addAll(rectangle, hBox, cards, vBox, results, buttons);
    main.setBackground(new Background(imageView));
    root.getChildren().addAll(entrance, main);
    entrance.setVisible(true);
    main.setVisible(false);
    enter.setOnAction(e -> {
      enter.setVisible(false);
      ftStart.play();
      ftStart.setOnFinished(event -> {
          entrance.getChildren().remove(entranceImageView);
          stStart.play();
          stStart.setOnFinished(event1 -> {
              entrance.setVisible(false);
              main.setVisible(true);
          });
      });
    });
    primaryStage.setScene(new Scene(root));
    primaryStage.setMaximized(true);
    primaryStage.setTitle("CardGame");
    primaryStage.show();
  }

  public Rectangle rectangle() {
    Rectangle rectangle = new Rectangle(100, 150);
    rectangle.setFill(Color.TRANSPARENT);
    rectangle.setStroke(Color.BLACK);
    rectangle.setStrokeWidth(5);
    rectangle.setArcHeight(20);
    rectangle.setArcWidth(20);
    return rectangle;
  }

  public ImageView getCardImage(String card) {
      Image image = new Image(card);
      ImageView imageView = new ImageView(image);
      imageView.setFitHeight(130);
      imageView.setFitWidth(80);
      return imageView;
  }

  public HBox getCards(int i) {
    HBox hBox = new HBox(i);
    hBox.setSpacing(60);
      ArrayList<PlayingCard> cards = handOfCards.getHand();
      for (int j = 0; j < i; j++) {
        hBox.getChildren().add(getCardImage("/cards/" + cards.get(j).getAsString() + ".png"));
      }
      hBox.setAlignment(Pos.CENTER);
      if (deckOfCards.getPlayingCards().size() < 5) {
        dealHand.setDisable(true);
        shuffle.setDisable(false);
      }
      return hBox;
  }

 public VBox results() {
    VBox vBox = new VBox();
    vBox.setSpacing(25);
    vBox.setMinHeight(100);
    sum.setText("Sum of cards : " + handOfCards.getSumOfHand());
    flush.setText("Flush : " + handOfCards.checkFlush());
    hearts.setText("Check hearts : " + handOfCards.checkHearts());
    queenOfSpades.setText("Check Queen of Spades : " + handOfCards.checkQueenOfSpades());
    vBox.getChildren().addAll(sum, flush, hearts, queenOfSpades);
    vBox.setAlignment(Pos.CENTER_LEFT);
    vBox.setPadding(new Insets(45));
    vBox.setStyle("-fx-font: 10px Verdana;");
    return vBox;
  }
}
