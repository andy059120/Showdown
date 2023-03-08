public enum Suit {
    //最小排到最大
    /*CLUB("C"),
    DIAMOND("D"),
    HEART("H"),
    SPADE("S");*/

    //最大排到最小
    SPADE("S"),
    HEART("H"),
    DIAMOND("D"),
    CLUB("C");

    Suit() {}

    private String suitName;

    Suit(String suitName) { this.suitName = suitName;}

    public String getName() {
        return suitName;
    }
}