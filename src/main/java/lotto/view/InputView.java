package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

public class InputView {
    public int money() {
        System.out.println(OutputMessage.INPUT_MONEY.getMessage());
        String input = Console.readLine();
        int money = 0;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
        return money;
    }
}
