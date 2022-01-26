package internal.domain.logic;

import java.util.ArrayList;
import java.util.List;

import internal.domain.entity.CaptureBall;
import internal.domain.entity.Player;

public class PlayerManager {
    private static final int NUMBER_OF_PLAYER = 1;

    List<Player> players;
    CaptureBallManager captureBallManager;

    public PlayerManager() {
        captureBallManager = new CaptureBallManager();
        players = new ArrayList<>();
        generatePlayer();
    }

    private void generatePlayer() {
        List<CaptureBall> balls = captureBallManager.getAllCaptureBall();

        for (int i = 0; i < NUMBER_OF_PLAYER; i++) {
            players.add(new Player(balls));
        }
    }

    public Player getPlayer(int id) {
        return players.get(id);
    }
}
