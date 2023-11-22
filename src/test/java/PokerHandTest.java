import org.example.PokerHand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PokerHandTest {

    @Test
    public void testCompareTo_FlushVsStraight() {
        PokerHand flush = new PokerHand("2S 4S 6S 8S TS");
        PokerHand straight = new PokerHand("8H 7C 6D 5S 4C");

        assertEquals(1, flush.compareTo(straight));
    }

    @Test
    public void testCompareTo_ThreeOfAKindVsTwoPairs() {
        PokerHand threeOfAKind = new PokerHand("5H 5C 5D QS 8C");
        PokerHand twoPairs = new PokerHand("8H 8C 9D KS KH");

        assertEquals(1, threeOfAKind.compareTo(twoPairs));
    }

    @Test
    public void testCompareTo_OnePairVsHighCard() {
        PokerHand onePair = new PokerHand("3S 3H 8D QC KS");
        PokerHand highCard = new PokerHand("5H 7C 9D JS AC");

        assertEquals(1, onePair.compareTo(highCard));
    }

    @Test
    public void testCompareTo_TwoStraights() {
        PokerHand straight1 = new PokerHand("9S 8H 7D 6C 5S");
        PokerHand straight2 = new PokerHand("8H 7C 6D 5S 4C");

        assertEquals(1, straight1.compareTo(straight2));
    }

    @Test
    public void testCompareTo_TwoFlushes() {
        PokerHand flush1 = new PokerHand("2S 4S 6S 8S TS");
        PokerHand flush2 = new PokerHand("3H 7H 9H JH AH");

        assertEquals(1, flush1.compareTo(flush2));
    }
}