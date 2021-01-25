package lib.utils;

public enum TimeoutLevel {
    LONG(30), NORMAL(10), LONGER(300), LONGEST(600), SHORT(5), SHORTER(2), SHORTEST(1), MS_SHORTER(1500), MS_SHORTEST(500);

    private final int timeout;

    TimeoutLevel(int timeout) {
        this.timeout = timeout;
    }

    public int value() {
        return this.timeout;
    }
}
