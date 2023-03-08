import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void choice(int number) {
    }
    @Override
    public void nameSelf() {
        this.name = scanner.nextLine();
    }
    @Override
    public Card showCard(Player currentPlayer) {
        Card temp;
        for (int i = 0; i < currentPlayer.getHand().size(); i++) {
            System.out.print("(" + (i + 1) + "): " + currentPlayer.getHand().get(i).getSuit().getName() + currentPlayer.getHand().get(i).getRank().getName() + "  ");
        }
        System.out.println();
        int choice = scanner.nextInt();
        temp = new Card(currentPlayer.getHand().get(choice-1).getRank(), currentPlayer.getHand().get(choice-1).getSuit());
        return temp;
    }
}
