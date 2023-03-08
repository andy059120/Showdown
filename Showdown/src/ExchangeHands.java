import java.util.ArrayList;
import java.util.List;

public class ExchangeHands {
    private int exchangeHandsCount = 3;

    public void changeHands(Player exchanger, Player exchanges){
        List<Card> tempHand = exchanger.getHand();
        exchanger.setHand(exchanges.getHand());
        exchanges.setHand(tempHand);
        count();
    }

    public void count(){
        this.exchangeHandsCount = --exchangeHandsCount;
        if(exchangeHandsCount==0){
            returnHands();
        }
    }

    public void returnHands(){

    }
}
