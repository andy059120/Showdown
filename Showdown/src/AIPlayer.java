public class AIPlayer extends Player{
    private int AInumber;

    @Override
    public void choice(int AInumber) {
        this.AInumber = AInumber;
    }
    @Override
    public void nameSelf() {
        this.name = ("AI" + AInumber);
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("AI"+ AInumber);
    }
    @Override
    public Card showCard(Player currentPlayer) {
        Card temp;
        for (int i = 0; i < currentPlayer.getHand().size(); i++) {
            System.out.print("(" + (i + 1) + "): " + currentPlayer.getHand().get(i).getSuit().getName() + currentPlayer.getHand().get(i).getRank().getName() + "  ");
        }
        System.out.println();
        try {
            Thread.sleep(1300);
        }catch(Exception e) {
            System.out.println(e);
        }
        int choice = (int) (Math.random() * (currentPlayer.getHand().size()) + 1);
        System.out.println(choice);
        temp = new Card(currentPlayer.getHand().get(choice-1).getRank(), currentPlayer.getHand().get(choice-1).getSuit());
        return temp;
    }
}
