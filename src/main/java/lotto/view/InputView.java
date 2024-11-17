package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;

public class InputView {
    private static final String WINNING_NUMBERS_DELIMITER = ",";

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

    public List<Integer> winningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println(System.lineSeparator() + OutputMessage.INPUT_WINNING_NUMBERS.getMessage());
        String input = Console.readLine();
        try {
            for (String number : input.split(WINNING_NUMBERS_DELIMITER)) {
                winningNumbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
        return winningNumbers;
    }

    public int bonusNumber() {
        System.out.println(System.lineSeparator() + OutputMessage.INPUT_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
        return bonusNumber;
    }
}
