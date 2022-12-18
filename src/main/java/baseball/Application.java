package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void playGame() {
        printStartMsg();
    }

    public static void printStartMsg() {
        System.out.println("숫자 야구 게임을 실행합니다.");
    }

    public static List<Integer> makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGame();
    }
}
