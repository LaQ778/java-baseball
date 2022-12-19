package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void playGame() {
        printStartMsg();
        List<Integer> computer = makeComputerNumber();
        boolean status = true;

        while(status) {
            List<Integer> user = getUserNumber();
            int ball = countBall(computer, user);
            int strike = countStrike(computer, user);
            printBallAndStrike(ball, strike);
            if (strike == 3) {
                status = setStatus();
                computer = resetComputer(status, computer);
            }
        }

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

    public static List<Integer> getUserNumber() {
        printInputMsg();
        String userInput = Console.readLine();
        List<Integer> user = checkValidUserInput(userInput);
        return user;
    }

    public static void printInputMsg() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static List<Integer> checkValidUserInput(String userInput) {
        List<Integer> user = new ArrayList<>();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < userInput.length(); i++) {
            int cnt = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            if (user.contains(cnt)) {
                throw new IllegalArgumentException();
            } else {
                user.add(cnt);
            }
        }
        return user;
    }

    public static int countBall(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) != user.get(i) && user.contains(computer.get(i))) {
                ball ++;
            }
        }
        return ball;
    }

    public static int countStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike ++;
            }
        }
        return strike;
    }

    public static void printBallAndStrike(int ball, int strike) {
        String msg = "";
        if (ball == 0 && strike == 0) {
            msg = "낫싱";
        }
        if (ball > 0) {
            msg = msg + ball + "볼 ";
        }
        if (strike > 0) {
            msg = msg + strike +"스트라이크";
        }
        System.out.println(msg);
    }
    public static void printGameOverMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printGameStatusMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public static boolean setStatus() {
        printGameOverMsg();
        printGameStatusMsg();
        String userInput = Console.readLine();
        if (Objects.equals(userInput, "1")) {
            return true;
        } else if (Objects.equals(userInput, "2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public static List<Integer> resetComputer(boolean status, List<Integer> computer) {
        if (status) {
            computer = makeComputerNumber();
        }
        return computer;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGame();
    }
}
