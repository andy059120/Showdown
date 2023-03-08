public enum Rank {
    //最小排到最大
    /*DEUCE("[2]"),
    THREE("[3]"),
    FOUR("[4]"),
    FIVE("[5]"),
    SIX("[6]"),
    SEVEN("[7]"),
    EIGHT("[8]"),
    NINE("[9]"),
    TEN("[10]"),
    JACK("[J]"),
    QUEEN("[Q]"),
    KING("[K]"),
    ACE("[A]");*/

    //最大排到最小
    ACE("[A]"),
    KING("[K]"),
    QUEEN("[Q]"),
    JACK("[J]"),
    TEN("[10]"),
    NINE("[9]"),
    EIGHT("[8]"),
    SEVEN("[7]"),
    SIX("[6]"),
    FIVE("[5]"),
    FOUR("[4]"),
    THREE("[3]"),
    DEUCE("[2]");

    private String rankName;

    Rank() {}

    Rank(String rankName) {
        this.rankName = rankName;
    }

    public String getName() {
        return rankName;
    }
}