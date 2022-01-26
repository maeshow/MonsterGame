package internal.domain.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import internal.domain.entity.Monster;

public class MonsterManager {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 100;
    List<Monster> monsters;

    public MonsterManager() {
        monsters = new ArrayList<>();
        generateMonster();
    }

    private void generateMonster() {
        monsters.add(new Monster("ザコモン", 30, 20, 20, 30, 72));
        monsters.add(new Monster("フツモン", 50, 20, 30, 30, 50));
        monsters.add(new Monster("ツヨモン", 100, 50, 30, 25, 28));
        monsters.add(new Monster("ボスモン", 100, 50, 50, 10, 25));
        monsters.add(new Monster("レアモン", 150, 100, 100, 5, 14));

        Collections.sort(
                monsters,
                new Comparator<Monster>() {
                    @Override
                    public int compare(Monster monster1, Monster monster2) {
                        return monster2.getEncountRate() - monster1.getEncountRate();
                    }
                });
    }

    public Monster encountMonster() {
        int random = RANDOM.nextInt(BOUND);
        int count = 0;
        for (Monster monster : monsters) {
            count += monster.getEncountRate();

            if (random <= count) {
                return monster;
            }
        }

        return null;
    }
}
