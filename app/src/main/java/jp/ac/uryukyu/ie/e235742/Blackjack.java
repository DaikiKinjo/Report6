package jp.ac.uryukyu.ie.e235742;
import java.util.ArrayList;
import java.util.Collections;

public class Blackjack {
    public static void main(String[] args){
        ArrayList<Integer> deck = new ArrayList<>();//山札のリスト
        for (int n = 1; n <= 13; n++) {
            deck.add(n);
        }
        
        Collections.shuffle(deck); //シャッフルする
    }
}

