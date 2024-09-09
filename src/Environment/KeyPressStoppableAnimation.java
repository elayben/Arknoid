package Environment;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor sensor;
    private final String key;
    private final Animation animation;
    private boolean stop;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (key.equals("p")) {
            if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
                stop = true;
            }
        } else if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            System.exit(0);
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }

}