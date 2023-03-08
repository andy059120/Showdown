import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Player {
    protected String name;
    private List<Card> hand = new ArrayList<>();
    private int point = 0;
    private boolean exchangeHandsAvailable = true;
    Scanner scanner = new Scanner(System.in);

    public Player() {}

    public abstract void choice(int number);
    public abstract void nameSelf();
    public abstract Card showCard(Player currentPlayer);

    public void doExchangeHands(int exchanger, List<Player> players) {
        System.out.println("Do you want to do ExchangeHands with?");
        for (int i = 0; i < players.size(); i++) {
            if (i == exchanger) {
                continue;
            }
            System.out.println("Player" + (i + 1) + "   ");
        }
        int choose = scanner.nextInt();
        ExchangeHands exchangeHands = new ExchangeHands();
        exchangeHands.changeHands(players.get(exchanger), players.get(choose-1));
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void setPoint(int point) {
        this.point = ++point;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getPoint() {
        return point;
    }

    public boolean isExchangeHandsAvailable() {
        return exchangeHandsAvailable;
    }
}
