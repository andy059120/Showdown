public class Main {

    public static void main(String[] args) {
        Showdown showdown = new Showdown(new HumanPlayer(), new AIPlayer(), new AIPlayer(), new AIPlayer());
        showdown.gameStart();


        /* to do list:
        1.出牌那邊可以寫 try catch
        2.AIPlayer 實作
        3.ExchangeHands 實作

         */




    } // ctrl + alt + L 自動排版
}
