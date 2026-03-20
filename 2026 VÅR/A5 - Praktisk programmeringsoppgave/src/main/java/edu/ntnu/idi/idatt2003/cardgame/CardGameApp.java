package edu.ntnu.idi.idatt2003.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CardGameApp extends Application {

    private final DeckOfCards deck = new DeckOfCards();
    private HandOfCards hand;

    @Override
    public void start(Stage stage) {
        Label handLabel = new Label("Hand:");
        TextField handField = new TextField();
        handField.setEditable(false);

        Label sumLabel = new Label("Sum of faces:");
        TextField sumField = new TextField();
        sumField.setEditable(false);

        Label heartsLabel = new Label("Hearts:");
        TextField heartsField = new TextField();
        heartsField.setEditable(false);

        Label qsLabel = new Label("Queen of Spades present:");
        TextField qsField = new TextField();
        qsField.setEditable(false);

        Label flushLabel = new Label("5-card flush:");
        TextField flushField = new TextField();
        flushField.setEditable(false);

        Button dealButton = new Button("Deal hand");
        dealButton.setOnAction(e -> {
            hand = deck.dealHand(5);                                                    // Minimum 5
            handField.setText(hand.asString());

            // Reset the analysis fields for the next "Check hand"
            sumField.clear();
            heartsField.clear();
            qsField.clear();
            flushField.clear();
        });

        Button checkButton = new Button("Check hand");
        checkButton.setOnAction(e -> {
            if (hand == null) {
                handField.setText("Deal a hand first");
                return;
            }
            sumField.setText(String.valueOf(hand.sumFaces()));
            heartsField.setText(hand.heartsAsStringOrNoHearts());
            qsField.setText(hand.containsQueenOfSpades() ? "Yes" : "No");
            flushField.setText(hand.hasFiveCardFlush() ? "Yes" : "No");
        });

        VBox root = new VBox(10,
                handLabel, handField,
                dealButton,
                checkButton,
                sumLabel, sumField,
                heartsLabel, heartsField,
                qsLabel, qsField,
                flushLabel, flushField
        );
        root.setPadding(new Insets(12));

        stage.setTitle("CardGame");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}