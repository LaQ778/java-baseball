package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UnitTest extends NsTest {
    @Test
    @DisplayName("시작 테스트")
    void 시작_테스트() {
        Application.playGame();
        assertThat(output()).contains("숫자 야구 게임을 실행합니다.");
    }

    @RepeatedTest(3)
    @DisplayName("랜덤 숫자 생성 테스트")
    void 랜덤_숫자_생성_테스트() {
        List<Integer> computer = Application.makeComputerNumber();
        System.out.println(computer);
        assertEquals(computer.size(), 3);
    }

    @Test
    @DisplayName("사용자 숫자 입력 테스트")
    void 사용사_숫자_입력_테스트() {
        String userInput = "512";
        List<Integer> output = new ArrayList<>();
        output.add(5);
        output.add(1);
        output.add(2);
        assertEquals(Application.checkValidUserInput(userInput), output);
    }

    @Override
    protected void runMain() {

    }
}
