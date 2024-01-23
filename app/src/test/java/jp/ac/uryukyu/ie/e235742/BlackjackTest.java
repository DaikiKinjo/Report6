package jp.ac.uryukyu.ie.e235742;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BlackjackTest {
    private Blackjack blackjack;
    @Test
    public void testMakeDeck() {      
        Blackjack blackjack = new Blackjack(); 
        blackjack.MakeDeck();
        // デッキが正しく作成されたかを確認するテスト
        assertEquals(13, blackjack.getDeck().size()); // 13種類のカードがあるかどうか
    }

}
