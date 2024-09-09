package Environment;

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * The type Countdown animation.
 */
// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private final SpriteCollection gameScreen;
    private final int countFrom;
    private int tempCountFrom;
    private boolean stop;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.stop = false;
        this.tempCountFrom = countFrom;
    }

   // f;
    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(Color.black);
        d.drawText(400, 300, "" + tempCountFrom + "", 30);
        if (tempCountFrom == 0) {
            stop = true;
        }
        tempCountFrom--;
        Sleeper sleeper = new Sleeper();
        sleeper.sleepFor((long) (numOfSeconds / countFrom));
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }

}