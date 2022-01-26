package internal.domain.entity;

import java.util.Random;

public class Monster {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 100;
    private static final int BIAS = 10;
    private static final int START_RATE = 0;

    private String name; // 名前
    private int hpValue; // HP
    private int powerValue; // 攻撃
    private int defenseValue; // 防御
    private int encountRate; // 発生率
    private int captureRate; // 捕獲率

    public Monster(
            String name,
            int hpValue,
            int powerValue,
            int defenseValue,
            int encountRate,
            int captureRate) {
        this.name = name;
        this.hpValue = hpValue;
        this.powerValue = powerValue;
        this.defenseValue = defenseValue;
        this.encountRate = encountRate;
        this.captureRate = captureRate;
    }

    public String getName() {
        return name;
    }

    public int getHpValue() {
        return hpValue;
    }

    public int getPowerValue() {
        return powerValue;
    }

    public int getDefenceValue() {
        return defenseValue;
    }

    public int getEncountRate() {
        return encountRate;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    /**
     * 捕獲ポイントを取得（式：(HP+攻撃+防御)*10）
     * 
     * @return 捕獲ポイント
     */
    public int calcCaputuredPoint() {
        return (hpValue + powerValue + defenseValue) * BIAS;
    }

    /**
     * 捕獲できたかどうかの判定を行う
     * 
     * @param correctValue 捕獲率の補正値
     * @return true: 捕獲成功 / false: 捕獲失敗
     */
    public boolean canCaputured(int correctValue) {
        int random = RANDOM.nextInt(BOUND);
        int rate = captureRate + correctValue;
        if (START_RATE < random && random < rate) {
            return true;
        }
        return false;
    }
}