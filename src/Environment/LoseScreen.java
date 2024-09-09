package Environment;

import biuoop.DrawSurface;

/**
 * The type Lose screen.
 */
public class LoseScreen implements Animation {
    private final Counter score;
    private final boolean stop;

    /**
     * Instantiates a new Lose screen.
     *
     * @param score the score
     */
    public LoseScreen(Counter score) {
        this.stop = false;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), 32);
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }

}