package internal.presentation;

import internal.domain.entity.Monster;
import internal.domain.entity.Player;

public class Messages {
    public static final String START_MESSAGE = "あなたは最強のポ◯モンマスターを目指しています。%n１０匹のモンスターが次々と現れてきますので、捕獲玉を使って捕獲しよう！%nモンスターを捕獲できれば、モンスターごとに設定されたポイントを獲得できます。%n３種類ある捕獲玉をうまく使って、高得点を目指そう！%n";

    public static final String ENCOUNT_MONSTER = "%s（HP： %d, 攻撃： %d, 防御： %d, 出現率： %d％, 捕獲率： %d％）が現れた！%n";

    public static final String WAITING_INPUT = "行動を選んでください";
    public static final String USE_BALL = "%d.%sを使う（残り%d個, 捕獲成功率：%d％）%n";
    public static final String MERCY = "%d.モンスターを見逃す%n";

    public static final String CAPTURE_SUCCESS = "捕獲に成功！！";
    public static final String CAPTURE_FAILURE = "捕獲に失敗した！";
    public static final String MERCY_MONSTER = "モンスターを見逃してあげた";
    public static final String ALL_BALL_USED = "全てのボールを使い切った";

    public static final String NOT_ENOUGH_BALL_WARN = "ボールを持っていません";
    public static final String INPUT_WARN = "入力が不正です";

    private static final String MONSTER_RESULT = "---捕獲したモンスター---";
    private static final String MONSTER_INFO = "%s（HP： %d, 攻撃： %d, 防御： %d, 出現率： %d％, 捕獲率： %d％）%n";
    private static final String LINE = "----------";
    private static final String SCORE = "スコア：%d%n";

    public static void showResult(Player player) {
        Messages.showWithNewLine(Messages.MONSTER_RESULT);
        for (Monster monster : player.getPets()) {
            Messages.showFormattedMessage(Messages.MONSTER_INFO, monster.getName(), monster.getHpValue(),
                    monster.getPowerValue(), monster.getDefenceValue(), monster.getEncountRate(),
                    monster.getCaptureRate());
        }
        Messages.showWithNewLine(Messages.LINE);
        Messages.showFormattedMessage(Messages.SCORE, player.getScore());
    }

    public static void showWithNewLine(String message) {
        System.out.println(message);
    }

    public static void showWithoutNewLine(String message) {
        System.out.printf(message);
    }

    public static void showNewLine() {
        System.out.println();
    }

    public static void showFormattedMessage(String message) {
        System.out.format(message);
    }

    public static void showFormattedMessage(String message, int a) {
        System.out.format(message, a);
    }

    public static void showFormattedMessage(String message, String a) {
        System.out.format(message, a);
    }

    public static void showFormattedMessage(String message, String a, int b, int c) {
        System.out.format(message, a, b, c);
    }

    public static void showFormattedMessage(String message, String a, int b, int c, int d, int e, int f) {
        System.out.format(message, a, b, c, d, e, f);
    }

    public static void showFormattedMessage(String message, int a, int b, String c, int d, String e) {
        System.out.format(message, a, b, c, d, e);
    }

    public static void showFormattedMessage(String message, int a, String b, int c, int d) {
        System.out.format(message, a, b, c, d);
    }
}
