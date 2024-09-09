package Environment;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private final Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score.getValue();
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(400, 19, "" + getScore() + "", 17);
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
