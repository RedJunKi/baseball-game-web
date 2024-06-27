package jk.baseballgameweb.rank;

public enum GameType {
    HANOI_TOWER("하노이의 탑"),
    NUMBER_BASEBALL("숫자야구"),
    BLACKJACK("블랙잭");

    private final String displayName;

    GameType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
