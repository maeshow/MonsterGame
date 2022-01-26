package internal.presentation;

import java.util.List;

import internal.domain.entity.CaptureBall;
import internal.domain.entity.Monster;
import internal.domain.entity.Player;
import internal.domain.logic.CaptureBallManager;
import internal.domain.logic.MonsterManager;
import internal.domain.logic.PlayerManager;

public class MonsterGame {
    private static final int PLAYER_ID = 0;
    private static final int NUMBER_OF_MONSTER = 10;
    private static final int FIRST_COUNT = 1;
    private static final int FIRST_ACTION_NUMBER = 1;
    private static final int MIN_BALL_COUNT = 0;

    PlayerInput playerInput;
    PlayerManager playerManager;
    MonsterManager monsterManager;
    CaptureBallManager captureBallManager;

    public MonsterGame() {
        playerInput = new PlayerInput();
        playerManager = new PlayerManager();
        monsterManager = new MonsterManager();
        captureBallManager = new CaptureBallManager();
    }

    public void onGame() {
        Messages.showFormattedMessage(Messages.START_MESSAGE);
        Messages.showNewLine();
        startTurn();
    }

    private void startTurn() {
        Player player = playerManager.getPlayer(PLAYER_ID);
        int count = FIRST_COUNT;
        while (isWithinTurn(count)) {
            Monster monster = encountMonster();
            action(player, monster);
            if (!hasBall(player)) {
                Messages.showWithNewLine(Messages.ALL_BALL_USED);
                break;
            }
            count++;
        }
        calcScore(player);
        Messages.showResult(player);
    }

    private boolean isWithinTurn(int count) {
        return count < NUMBER_OF_MONSTER;
    }

    private Monster encountMonster() {
        Monster monster = monsterManager.encountMonster();
        if (monster != null) {
            Messages.showFormattedMessage(Messages.ENCOUNT_MONSTER, monster.getName(), monster.getHpValue(),
                    monster.getPowerValue(), monster.getDefenceValue(), monster.getEncountRate(),
                    monster.getCaptureRate());
            return monster;
        }
        return encountMonster();
    }

    private void action(Player player, Monster monster) {
        if (!hasBall(player)) {
            return;
        }
        int actionNumber = playerInput(player);
        List<CaptureBall> balls = captureBallManager.getAllCaptureBall();
        if (actionNumber - 1 < balls.size()) {
            captureMonster(player, monster, player.getBalls().get(actionNumber - 1));
            return;
        }
        Messages.showWithNewLine(Messages.MERCY_MONSTER);
    }

    private int playerInput(Player player) {
        Messages.showWithNewLine(Messages.WAITING_INPUT);
        int count = FIRST_ACTION_NUMBER;
        for (CaptureBall ball : player.getBalls()) {
            Messages.showFormattedMessage(Messages.USE_BALL, count, ball.getName(), ball.getCount(),
                    ball.getCorrectValue());
            count++;
        }
        Messages.showFormattedMessage(Messages.MERCY, count);
        return playerInput.getPlayerInput();
    }

    private void captureMonster(Player player, Monster monster, CaptureBall ball) {
        if (canUseBall(ball.getCount())) {
            ball.use();
            if (monster.canCaputured(ball.getCorrectValue())) {
                player.addPets(monster);
                Messages.showWithNewLine(Messages.CAPTURE_SUCCESS);
                return;
            }
            Messages.showWithNewLine(Messages.CAPTURE_FAILURE);
            action(player, monster);
            return;
        }
        Messages.showWithNewLine(Messages.NOT_ENOUGH_BALL_WARN);
        action(player, monster);
    }

    private boolean canUseBall(int count) {
        return MIN_BALL_COUNT < count;
    }

    private boolean hasBall(Player player) {
        int ballCount = 0;
        for (CaptureBall ball : player.getBalls()) {
            ballCount += ball.getCount();
        }
        return 0 < ballCount;
    }

    private void calcScore(Player player) {
        for (Monster monster : player.getPets()) {
            player.addScore(monster.calcCaputuredPoint());
        }
    }
}
