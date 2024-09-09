package Objects;

import Environment.Collidable;
import Environment.GameLevel;
import Environment.HitListener;
import Environment.HitNotifier;
import Environment.Sprite;
import GeometryPrimitives.Point;
import Movement.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Objects.Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    /**
     * The Hit listeners.
     */
    private List<HitListener> hitListeners;
    private GeometryPrimitives.Rectangle rectangle;
    private Color color;

    /**
     * Instantiates a new Objects.Block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     */
    public Block(GeometryPrimitives.Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Gets hit listeners.
     *
     * @return the hit listeners
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
    }

    /**
     * Sets hit listeners.
     *
     * @param hitListeners the hit listeners
     */
    public void setHitListeners(List<HitListener> hitListeners) {
        this.hitListeners = hitListeners;
    }

    // Return the "collision shape" of the object.
    @Override
    public GeometryPrimitives.Rectangle getCollisionRectangle() {
        return this.getRectangle();
    }

    /*
        // Notify the object that we collided with it at collisionPoint with
        // a given velocity.
        // The return is the new velocity expected after the hit (based on
        // the force the object inflicted on us).
        @Override
        public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
            double temp;
            if (doubleCompare(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())
                    || doubleCompare(collisionPoint.getY(), this.rectangle.getBottomRight().getY())) {
                temp = currentVelocity.getDy();
                currentVelocity.setDy(temp * -1);
            }
            if (doubleCompare(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())
                    || doubleCompare(collisionPoint.getX(), this.rectangle.getBottomRight().getX())) {
                temp = currentVelocity.getDx();
                currentVelocity.setDx(temp * -1);
            }
            return currentVelocity;
        }


     */
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double temp;
        if (doubleCompare(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())
                || doubleCompare(collisionPoint.getY(), this.rectangle.getBottomRight().getY())) {
            temp = currentVelocity.getDy();
            currentVelocity.setDy(temp * -1);
        }
        if (doubleCompare(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())
                || doubleCompare(collisionPoint.getX(), this.rectangle.getBottomRight().getX())) {
            temp = currentVelocity.getDx();
            currentVelocity.setDx(temp * -1);
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * Gets rectangle.
     *
     * @return the rectangle
     */
    public GeometryPrimitives.Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * Sets rectangle.
     *
     * @param rectangle the rectangle
     */
    public void setRectangle(GeometryPrimitives.Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * Double compare boolean.
     *
     * @param d1 the d 1
     * @param d2 the d 2
     * @return the boolean
     */
    public boolean doubleCompare(double d1, double d2) {
        double eps = 0.0001d;
        return Math.abs(d1 - d2) < eps;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int x = (int) this.getRectangle().getUpperLeft().getX();
        int y = (int) this.getRectangle().getUpperLeft().getY();
        int w = (int) this.getRectangle().getWidth();
        int h = (int) this.getRectangle().getHeight();
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, w, h);
        d.setColor(this.getColor());
        d.fillRectangle(x, y, w, h);
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    @Override
    public void timePassed() {

    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
