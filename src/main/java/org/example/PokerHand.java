package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerHand {
    private String hand;
    private List<String> cards;

    public PokerHand(String hand) {
        this.hand = hand;
        parseHand();
    }

    private void parseHand() {
        cards = Arrays.asList(hand.split(" "));
    }

    private char getRank(String card) {
        return card.charAt(0);
    }

    private char getSuit(String card) {
        return card.charAt(1);
    }

    private boolean hasStraight() {
        if (cards == null || cards.isEmpty()) {
            return false;
        }

        List<Character> ranks = new ArrayList<>();
        for (String card : cards) {
            ranks.add(getRank(card));
        }

        Collections.sort(ranks);

        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i) - ranks.get(i - 1) != 1) {
                return false;
            }
        }

        return true;
    }

    private boolean hasFlush() {
        if (cards == null || cards.isEmpty()) {
            return false;
        }

        char suit = getSuit(cards.get(0));

        for (String card : cards) {
            if (getSuit(card) != suit) {
                return false;
            }
        }

        return true;
    }

    public int compareTo(PokerHand other) {
        // Сначала проверяем комбинации
        if (hasStraight() && hasFlush() && !other.hasStraight() && !other.hasFlush()) {
            return 1; // Текущая рука - стрит-флэш, другая - нет, текущая сильнее
        } else if (!hasStraight() && !hasFlush() && other.hasStraight() && other.hasFlush()) {
            return -1; // Другая рука - стрит-флэш, текущая - нет, другая сильнее
        }

        // Если комбинации одинаковые или отсутствуют, сравниваем высшие карты
        if (cards == null  || other.cards == null || cards.size() == 0 || other.cards.size() == 0) {
            return 0; // Руки равны, так как не удалось сравнить высшие карты
        } else {

            List<Character> ranks1 = new ArrayList<>();
            List<Character> ranks2 = new ArrayList<>();

            for (String card : cards) {
                ranks1.add(getRank(card));
            }

            for (String card : other.cards) {
                ranks2.add(other.getRank(card));
            }

            Collections.sort(ranks1);
            Collections.sort(ranks2);

            for (int i = ranks1.size() - 1; i >= 0; i--) {
                if (ranks1.get(i) > ranks2.get(i)) {
                    return 1; // Текущая рука сильнее
                } else if (ranks1.get(i) < ranks2.get(i)) {
                    return -1; // Другая рука сильнее
                }
            }
        }
        return 0;
    }
}