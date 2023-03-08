import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        setCards(cards);
    }

    public void setCards(List<Card> cards) {
        for (Rank rank : Rank.values())
            for (Suit suit : Suit.values())
                cards.add(new Card(rank, suit));
    }

    public void shuffle() {
        int[] randomNum = new int[52];
        for (int i = 0; i < 52; i++) {
            randomNum[i] = (int) (Math.random() * 52);
            for (int j = 0; j < i; j++) {
                if (randomNum[i] == randomNum[j]) {
                    i--;
                    break;
                }
            }
        }
        for(int i = 0 ; i < 52 ; i++) {
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomNum[i]));
            cards.set(randomNum[i], temp);
        }
    }
    public void drawCard(List<Player> players){
        for (int i = 0 ; i < 4; i++) {
            //System.out.print("players "+(i+1)+" get: ");
            for (int j = 0 ; j < 13; j++) {
                players.get(i).getHand().add(cards.get(0));
                //System.out.print(cards.get(0).getSuit().getName());
                //System.out.print(cards.get(0).getRank().getName()+" ");
                cards.remove(0);
            }
            //System.out.println();
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
