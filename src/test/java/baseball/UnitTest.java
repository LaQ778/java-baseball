package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class UnitTest extends NsTest {
    @Test
    void 시작_테스트() {
        Application.playGame();
        assertThat(output()).contains("숫자 야구 게임을 실행합니다.");
    }
    @Override
    protected void runMain() {

    }
}
