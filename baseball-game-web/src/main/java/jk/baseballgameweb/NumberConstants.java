package jk.baseballgameweb;

public enum NumberConstants {
    NUMBER_GENERATE_SIZE(3);

    private final int value;

    NumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
