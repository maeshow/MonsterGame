package internal.domain.logic;

import java.util.ArrayList;
import java.util.List;

import internal.domain.entity.CaptureBall;

public class CaptureBallManager {
    List<CaptureBall> balls;

    public CaptureBallManager() {
        balls = new ArrayList<>();
        generateCaptureBall();
    }

    private void generateCaptureBall() {
        balls.add(new CaptureBall("ノーマル捕獲玉", 0, 6));
        balls.add(new CaptureBall("スーパー捕獲玉", 20, 3));
        balls.add(new CaptureBall("ミラクル捕獲玉", 50, 1));
    }

    public List<CaptureBall> getAllCaptureBall() {
        return balls;
    }
}
