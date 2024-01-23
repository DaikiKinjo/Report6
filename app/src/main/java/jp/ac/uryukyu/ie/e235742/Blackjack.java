package jp.ac.uryukyu.ie.e235742;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Blackjack {
    private ArrayList<Integer> deck; //deckのリスト
    private Scanner scanner;

    public Blackjack() {
        this.deck = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    private void MakeDeck() {
        for (int n = 1; n <= 13; n++) {  //デッキを作る
            deck.add(n);
        }
        Collections.shuffle(deck); //シャッフルする
    }

    private void playGame() {
        // プレイヤーの手札
        int handcard1 = deck.get(0); //1枚目取得
        System.out.println("あなたの1枚目のカードは [" + handcard1 + "] です");
        deck.remove(0);
        int handcard2 = deck.get(0); //2枚目取得
        System.out.println("あなたの2枚目のカードは [" + handcard2 + "] です");
        deck.remove(0);
        int total = (handcard1 > 10 ? 10 : handcard1) + (handcard2 > 10 ? 10 : handcard2); //total計算
        System.out.println("あなたのポイントは [" + total + "] です"); //total表示

        System.out.println("");

        //ディーラーの手札
        int dealer_card1 = deck.get(0); //1枚目取得
        System.out.println("ディーラーの1枚目のカードは [" + dealer_card1 + "] です");
        deck.remove(0);
        int dealer_total = dealer_card1;
        dealer_total = (dealer_card1 > 10 ? 10 : dealer_card1); //total計算 
        while(dealer_total <= 16){ //
            int dealercard = deck.get(0);
            dealer_total +=  + (dealercard > 10 ? 10 : dealercard);
    }

    while (total < 21) {
        System.out.println("");
        System.out.print("Hit（h）かStand（s）を選んでください: ");//ヒットかスタンドか選ばせる
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("h")) {
            // カードを引く
            int newCard = deck.get(0);
            System.out.println("");
            System.out.println("新しいカードは [" + newCard + "] です");
            deck.remove(0);
            total += (newCard > 10 ? 10 : newCard);
            System.out.println("あなたのポイントは [" + total + "] です");
        } else if (choice.equalsIgnoreCase("s")) {
            // Stand（何もせずに終了）
            break;
        } else {
            System.out.println("無効な入力です。Hit（h）かStand（s）を選んでください。");
        }
    }

    Judge(total, dealer_total);
    System.out.println("ディーラーのポイントは [" + dealer_total + "] でした");
    }

    private void Judge(int total, int dealer_total){
        if (total >=22){
            System.out.println("Burst!!");
            System.out.println("You lose.");
            } else if (dealer_total >= 22){
                System.out.println("Dealer's Burst!!");
                System.out.println("You win.");
            } else if (total == 21){
                System.out.println("BLACK JACK!!!!");
                System.out.println("You win.");
            } else if (dealer_total == 21){
                System.out.println("Dealer's BLACK JACK!!!!");
                System.out.println("You lose.");
            } else if (total > dealer_total && total < 21 ){
                System.out.println("You win.");
            } else if (dealer_total > total && dealer_total < 21){
                System.out.println("You lose.");
            } else if (total == dealer_total && total < 21){
                System.out.println("You lose.");
            }

    }

    public void StartGame(){
        System.out.println("----- BLACK JACK スタート！ -----");
        MakeDeck();
        playGame();
        scanner.close();
    }

}

