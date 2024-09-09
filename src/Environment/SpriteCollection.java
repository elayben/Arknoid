package Environment;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Environment.Sprite collection.
 */
public class SpriteCollection {
    private final List<Sprite> spritecollection;

    /**
     * Instantiates a new Environment.Sprite collection.
     */
    public SpriteCollection() {
        this.spritecollection = new ArrayList<>();
    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.spritecollection.add(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.spritecollection.remove(s);
    }

    /**
     * Notify all time passed.
     */
// call timePassed() on all sprites.
    public void notifyAllTimePassed() {
        List<Sprite> s = new ArrayList<>(this.spritecollection);
        // Notify all listeners about a hit event:
        for (Sprite spritecollection : s) {
            spritecollection.timePassed();
        }
    }

    /**
     * Draw all on.
     *
     * @param d the d
     */
// call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        List<Sprite> s = new ArrayList<>(this.spritecollection);
        // Notify all listeners about a hit event:
        for (Sprite spritecollection : s) {
            spritecollection.drawOn(d);
        }
    }
}