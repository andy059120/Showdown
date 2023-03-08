import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Showdown {
    private int round = 13;
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);

    public Showdown(Player player1, Player player2, Player player3, Player player4) {
        setPlayers(player1, player2, player3, player4);
    }

    public void setPlayers(Player player1, Player player2, Player player3, Player player4) {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).choice(i+1);
        }
    }

    public void gameStart() {
        playerNameSelf();
        deck.shuffle();
        deck.drawCard(players);
        for (int i = 1; i <= round; i++) {
            startGameRound(i);
        }
        gameFinish();
    }

    public void playerNameSelf() {
        for(int i = 0; i < players.size(); i++){
            System.out.print("player " + (i+1) + " nameSelf: ");
            players.get(i).nameSelf();
        }
    }

    public void startGameRound(int round) {
        List<Card> temps = new ArrayList<>();
        System.out.println("Round " + round + " : ");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + (i + 1) + "'s turn: ");
            //----------------------------------------------
            if (players.get(i).isExchangeHandsAvailable()) {
                System.out.println("do you want to use Exchange Hands? (Y/N)");
                String choice = scanner.nextLine();
                if (choice.equals("Y") || choice.equals("y")) {
                    players.get(i).doExchangeHands(i, players);
                }
            }
            //----------------------------------------------
            Card card = players.get(i).showCard(players.get(i));
            temps.add(card);
            for (int j = 0; j < players.get(i).getHand().size(); j++) {
                if(players.get(i).getHand().get(j).getRank().equals(card.getRank()) && players.get(i).getHand().get(j).getSuit().equals(card.getSuit())){
                    players.get(i).getHand().remove(j);
                    break;
                }
            }

        }
        displayCards(temps);
        judge(temps);
    }

    public void displayCards(List<Card> Cards) {
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Display:   ");
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i).getName()+": ");
            System.out.print(Cards.get(i).getSuit().getName());
            System.out.print(Cards.get(i).getRank().getName() + "    ");
        }
        System.out.println();
    }

    public void judge(List<Card> Cards) {
        int[] maxCard = new int[4];
        findMax:
        for (Rank rank : Rank.values()) {
            for (int i = 0; i < players.size(); i++) {
                if (rank == Cards.get(i).getRank()) {
                    maxCard[i] = 1;
                }
            }
            int sum = 0;
            for (int i : maxCard) {
                if (i == 1) {
                    sum++;
                }
            }
            if (sum == 1) {
                break;
            } else if (sum > 1) {
                for (Suit suit : Suit.values()) {
                    for (int i = 0; i < players.size(); i++) {
                        if (maxCard[i] == 0) {
                            continue;
                        }
                        if (suit == Cards.get(i).getSuit()) {
                            for (int j = 0; j < players.size(); j++) {
                                maxCard[j] = 0;
                            }
                            maxCard[i] = 1;
                            break findMax;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < players.size(); i++) {
            if (maxCard[i] == 1) {
                System.out.println("player " + (i + 1) + ": " + players.get(i).getName() + " get a point");
                players.get(i).setPoint(players.get(i).getPoint());
            }
        }
        checkScore();
        System.out.println("\n-----------------------------------------------------------------");
    }

    public void checkScore() {
        System.out.print("Scoreboard:   ");
        for (Player player : players) {
            System.out.print(player.getName() + ": " + player.getPoint() + "   ");
        }
    }

    public void gameFinish() {
        int maxScore = 0;
        String winner = "";
        for (Player player : players) {
            if (player.getPoint() > maxScore) {
                maxScore = player.getPoint();
                winner = player.getName();
            }
        }
        System.out.println("player " + winner + " gets " + maxScore + " points");
        System.out.println(winner + " win!");
    }

    public List<Player> getPlayers() {
        return players;
    }
}
