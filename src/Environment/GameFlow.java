package Environment;

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {

    private final AnimationRunner ar;
    private final KeyboardSensor ks;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter currScore = new Counter(0);
        int i = 0;
        ScoreIndicator scoreIndicator = new ScoreIndicator(currScore);
        for (LevelInformation levelInfo : levels) {
            i++;
            GameLevel level = new GameLevel(levelInfo, ks, currScore, ar);
            level.initialize();
            scoreIndicator.addToGame(level);
            level.run();
            if (level.getCounterBalls().getValue() == 0) {
                level.getRunner().run(new KeyPressStoppableAnimation(level.getKeyboard(), "SPACE_KEY",
                        new LoseScreen(level.getScore())));
                break;
            }
            if (level.getCounterBlocks().getValue() == 0 && i == levels.size()) {
                level.getRunner().run(new KeyPressStoppableAnimation(level.getKeyboard(), "SPACE_KEY",
                        new WinScreen(level.getScore())));
            }
        }
    }
}
