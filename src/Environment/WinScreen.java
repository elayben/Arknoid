package Environment;

import biuoop.DrawSurface;

/**
 * The type Win screen.
 */
public class WinScreen implements Animation {
    private final boolean stop;
    private final Counter score;

    /**
     * Instantiates a new Win screen.
     *
     * @param score the score
     */
    public WinScreen(Counter score) {
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 32);
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}