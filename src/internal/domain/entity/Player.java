package internal.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int DEFAULT_SCORE = 0;

    private int score;
    private List<CaptureBall> balls;
    private List<Monster> pets;

    public Player(List<CaptureBall> balls) {
        this.balls = balls;
        score = DEFAULT_SCORE;
        pets = new ArrayList<>();
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public List<CaptureBall> getBalls() {
        return balls;
    }

    public void addPets(Monster monster) {
        pets.add(monster);
    }

    public List<Monster> getPets() {
        return pets;
    }
}
