package lotto.model;

import lotto.exception.ExceptionMessage;

public class Money {
    private static final int MONEY_UNIT = 1000;
    private static final int MONEY_TEST_RESULT = 0;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money % MONEY_UNIT != MONEY_TEST_RESULT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

    public int getPurchaseQuantity() {
        return money / MONEY_UNIT;
    }

    public int getMoney() {
        return money;
    }
}
