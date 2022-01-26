package internal.presentation;

import java.util.Scanner;

public class PlayerInput {
    private static final Scanner STDIN = new Scanner(System.in);
    private static final int START_INPUT = 1;
    private static final int END_INPUT = 4;

    public int getPlayerInput() {
        String input = STDIN.next();
        Messages.showNewLine();
        return getCorrectInput(input);
    }

    private int getCorrectInput(String input) {
        int inputNumber = START_INPUT;

        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Messages.showWithNewLine(Messages.INPUT_WARN);
            Messages.showNewLine();
            return getPlayerInput();
        }

        if (START_INPUT <= inputNumber && inputNumber <= END_INPUT) {
            return inputNumber;
        }
        Messages.showWithNewLine(Messages.INPUT_WARN);
        return getPlayerInput();
    }
}
