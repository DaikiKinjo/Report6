package jp.ac.uryukyu.ie.e235742;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Blackjack {
    private int playerHp = 100; //プレイヤーのHP
    private int playerAttack = 50; //プレイヤーの攻撃力
    private int dealerHp = 100; //ディーラーのHP
    private int dealerAttack = 50; //ディーラーの攻撃力
    private ArrayList<Integer> deck; //deckのリスト
    private Scanner scanner;

    public Blackjack() {
        this.deck = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    void MakeDeck() {
        for (int n = 1; n <= 13; n++) {  //デッキを作る
            deck.add(n);
        }
        Collections.shuffle(deck); //シャッフルする
    }

    public ArrayList<Integer> getDeck() {
        return deck;
    }

    private void playGame() {
        while (playerHp > 0 && dealerHp > 0) {
        MakeDeck();
        System.out.println("ディーラーのHPは残り " + dealerHp + " です");
        System.out.println("あなたのHPは残り " + playerHp + " です");

        System.out.println("---------------------");
        // プレイヤーの手札
        int handcard1 = deck.get(0); //1枚目取得
        System.out.println("\nあなたの1枚目のカードは [" + handcard1 + "] です");
        deck.remove(0);
        int handcard2 = deck.get(0); //2枚目取得
        System.out.println("あなたの2枚目のカードは [" + handcard2 + "] です");
        deck.remove(0);
        int total = (handcard1 > 10 ? 10 : handcard1) + (handcard2 > 10 ? 10 : handcard2); //total計算
        System.out.println("あなたのポイントは [" + total + "] です"); //total表示

        //ディーラーの手札
        int dealer_card1 = deck.get(0); //1枚目取得
        System.out.println("\nディーラーの1枚目のカードは [" + dealer_card1 + "] です");
        deck.remove(0);
        int dealer_total = dealer_card1;
        dealer_total = (dealer_card1 > 10 ? 10 : dealer_card1); //total計算 
        while(dealer_total <= 16){ //ealer_totalが17以上になるまで引く
            int dealercard = deck.get(0);
            dealer_total += (dealercard > 10 ? 10 : dealercard); //引いた数字を足す
    }

    while (total < 21) {
        System.out.print("\nHit（h）かStand（s）を選んでください: ");//ヒットかスタンドか選ばせる
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("h")) {
            // カードを引く
            int newCard = deck.get(0);
            System.out.println("\n新しいカードは [" + newCard + "] です");
            deck.remove(0);
            total += (newCard > 10 ? 10 : newCard);
            System.out.println("あなたのポイントは [" + total + "] です");
        } else if (choice.equalsIgnoreCase("s")) {
            // Stand（何もせずに終了）
            break;
        } else {
            System.out.println("無効な入力です。Hit（h）かStand（s）を選んでください。"); //h,s以外が入力されたとき
        }
    }

    Judge(total, dealer_total); //Blackjackの勝敗を判断
    System.out.println("ディーラーのポイントは [" + dealer_total + "] でした");
    System.out.println("");

    Finish(playerHp, dealerHp); //どちらかが死んだとき
}
}

    private void Judge(int total, int dealer_total){
        System.out.println("");
        if (total >=22){
            System.out.println("Burst!!");
            System.out.println("You lose.");
            playerHp -= dealerAttack;
            System.out.println(dealerAttack + "ダメージ受けた！");
            } else if (dealer_total >= 22){
                System.out.println("Dealer's Burst!!");
                System.out.println("You win.");
                dealerHp -= playerAttack;
                System.out.println("ディーラーに"+ playerAttack + "ダメージ与えた！");
            } else if (total == 21){
                System.out.println("BLACK JACK!!!!");
                System.out.println("You win.");
                dealerHp -= playerAttack;
                System.out.println("ディーラーに"+ playerAttack + "ダメージ与えた！");
            } else if (dealer_total == 21){
                System.out.println("Dealer's BLACK JACK!!!!");
                System.out.println("You lose.");
                playerHp -= dealerAttack;
                System.out.println(dealerAttack + "ダメージ受けた！");
            } else if (total > dealer_total && total < 21 ){
                System.out.println("You win.");
                dealerHp -= playerAttack;
                System.out.println("ディーラーに"+ playerAttack + "ダメージ与えた！");
            } else if (dealer_total > total && dealer_total < 21){
                System.out.println("You lose.");
                playerHp -= dealerAttack;
                System.out.println(dealerAttack + "ダメージ受けた！");
            } else if (total == dealer_total && total < 21){
                System.out.println("You lose.");
                playerHp -= dealerAttack;
                System.out.println(dealerAttack + "ダメージ受けた！");
            }

    }

    void Finish(int playerHp, int dealerHp){
        if (playerHp <= 0){
            System.out.println("- You die. -");
        }else if (dealerHp <= 0){
            System.out.println("- Dealer is dead. -");
        }
    }

    public void StartGame(){
        System.out.println("----- BLACK JACK スタート！ -----");
        //MakeDeck();
        playGame();
        scanner.close();
    }

}

