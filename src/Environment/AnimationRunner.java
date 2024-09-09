package Environment;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The type Animation runner.
 */
public class AnimationRunner {
    private final GUI gui;
    private final int framesPerSecond;

    /**
     * Instantiates a new Animation runner.
     */
    public AnimationRunner() {
        this.gui = new GUI(" ", 800, 600);
        this.framesPerSecond = 1000 / 60;
    }

    /**
     * Gets gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Run.
     *
     * @param animation the animation
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);

            gui.show(d);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = framesPerSecond - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}