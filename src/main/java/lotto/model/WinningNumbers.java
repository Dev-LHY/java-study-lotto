package lotto.model;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class WinningNumbers {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersDuplicate(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.SIZE_ERROR.getMessage());
        }
    }

    private void validateWinningNumbersDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < LOTTO_START_NUMBER || winningNumber > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.getMessage());
            }
        }
    }
}
