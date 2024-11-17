package lotto.exception;

public enum ExceptionMessage {
    EXCEPTION_PREFIX("[ERROR] "),
    SIZE_ERROR("로또 번호는 6개여야 합니다."),
    INVALID_INPUT("1~45 사이의 숫자만 입력 가능합니다."),
    INVALID_MONEY_UNIT("구입 금액은 1,000원 단위로만 가능합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_PREFIX.message + message;
    }
}
