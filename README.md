# java-lotto-precourse

### model

로또

* 로또 생성기
* 로또 번호 검증기

로또 당첨 번호

* 로또 번호 검증기
* 보너스 번호 검증기

로또 티켓

* 로또 티켓에 로또 추가
* 로또 티켓 반환

로또 순위

* 각 순위 조건에 맞게 결과 값을 반환

### service

* 로또 순위 계산기

### view

OutputView

* 구입 금액에 따른 로또 번호 출력
* 당첨 통계 출력

InputView

* 로또 금액 입력
    * 사용자 입력 값 검증(숫자인지)
    * 로또 금액 검증(1,000원 단위인지)
* 당첨 번호 입력
    * 사용자 입력 값 검증(숫자인지)
    * 당첨 번호 검증(중복 번호가 없는지)
* 보너스 번호 입력
    * 사용자 입력 값 검증(숫자인지)
    * 보너스 번호 검증(당첨 번호와 중복 번호가 없는지)

OutputMessage

### controller

로또 실행기

### exception

ExceptionMessage