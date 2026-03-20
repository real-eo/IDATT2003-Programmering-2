package edu.ntnu.idi.idatt2003.cardgame;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class HandOfCards {
    private final List<PlayingCard> cards;

    public HandOfCards(List<PlayingCard> cards) {
        this.cards = List.copyOf(Objects.requireNonNull(cards, "cards"));
        if (this.cards.isEmpty()) {
            throw new IllegalArgumentException("Hand cannot be empty");
        }
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public String asString() {
        return cards.stream()
                .map(PlayingCard::getAsString)
                .collect(Collectors.joining(" "));
    }

    // Oppgave 5.1: sum av face-verdier (ess=1)
    public int sumFaces() {
        return cards.stream()
                .mapToInt(PlayingCard::getFace)
                .sum();
    }

    // Oppgave 5.2: bare hjerter
    public String heartsAsStringOrNoHearts() {
        String hearts = cards.stream()
                .filter(c -> c.getSuit() == 'H')
                .map(PlayingCard::getAsString)
                .collect(Collectors.joining(" "));
        return hearts.isBlank() ? "No Hearts" : hearts;
    }

    // Oppgave 5.3: sjekk Spar dame (S12)
    public boolean containsQueenOfSpades() {
        return cards.stream().anyMatch(c -> c.getSuit() == 'S' && c.getFace() == 12);
    }

    // Oppgave 5.4: 5-flush (minst 5 av samme suit)
    public boolean hasFiveCardFlush() {
        Map<Character, Long> counts = cards.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));
        return counts.values().stream().anyMatch(v -> v >= 5);
    }
}