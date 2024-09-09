package Objects;

import Environment.Collidable;
import Environment.GameLevel;
import Environment.Sprite;
import GeometryPrimitives.Rectangle;
import Movement.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Objects.Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private final int speed;
    private GeometryPrimitives.Rectangle rectangle;
    private Color color;
    private biuoop.KeyboardSensor keyboard;


    /**
     * Instantiates a new Objects.Paddle.
     *
     * @param rectangle the rectangle
     * @param color     the color
     * @param keyboard  the keyboard
     * @param speed     the speed
     */
    public Paddle(GeometryPrimitives.Rectangle rectangle, Color color, KeyboardSensor keyboard, int speed) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard = keyboard;
        this.speed = speed;
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

    /**
     * Gets keyboard.
     *
     * @return the keyboard
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * Sets keyboard.
     *
     * @param keyboard the keyboard
     */
    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * Move left.
     */
    public void moveLeft() {

    }

    /**
     * Move right.
     */
    public void moveRight() {

    }

    /**
     * Time passed.
     * Moves the paddle by the user presses
     */
    public void timePassed() {
        GeometryPrimitives.Rectangle rec = this.rectangle;
        GeometryPrimitives.Point p = this.rectangle.getUpperLeft();
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            p.setX(p.getX() - speed);
            rec = new GeometryPrimitives.Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
            if (rec.getUpperLeft().getX() < 20) {
                rec = new GeometryPrimitives.Rectangle(new GeometryPrimitives.Point(20, 560),
                        this.rectangle.getWidth(), this.rectangle.getHeight());
            }
            this.setRectangle(rec);
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            p.setX(p.getX() + speed);
            rec = new Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
            if (rec.getUpperRight().getX() > 780) {
                rec = new GeometryPrimitives.Rectangle(new GeometryPrimitives.Point(780 - this.rectangle.getWidth(),
                        560),
                        this.rectangle.getWidth(), this.rectangle.getHeight());
            }
            this.setRectangle(rec);
        }
    }

    /**
     * Draw on.
     * Draws the paddle
     */
    @Override
    public void drawOn(DrawSurface d) {
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        int w = (int) this.rectangle.getWidth();
        int h = (int) this.rectangle.getHeight();
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, w, h);
        d.setColor(this.getColor());
        d.fillRectangle(x, y, w, h);
    }

    /**
     * getCollisionRectangle.
     *
     * @return the rectangle shape of the paddle
     */
    public GeometryPrimitives.Rectangle getCollisionRectangle() {
        return this.getRectangle();
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
    /*
    @Override
    public Movement.Velocity hit(Ball hitter, GeometryPrimitives.Point collisionPoint,
     Movement.Velocity currentVelocity) {
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
    @Override
    public Movement.Velocity hit(Ball hitter, GeometryPrimitives.Point collisionPoint,
                                 Movement.Velocity currentVelocity) {
        double temp;
        if (doubleCompare(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())) {
            if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX()
                    && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                    + this.rectangle.getWidth() / 5) {
                currentVelocity = Velocity.fromAngleAndSpeed(300 - 90, currentVelocity.getSpeed());
            } else if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 5
                    && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                    + 2 * this.rectangle.getWidth() / 5) {
                currentVelocity = Velocity.fromAngleAndSpeed(330 - 90, currentVelocity.getSpeed());
            } else if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX()
                    + 3 * this.rectangle.getWidth() / 5
                    && collisionPoint.getX() <= this.rectangle.getUpperLeft().getX()
                    + 4 * this.rectangle.getWidth() / 5) {
                currentVelocity = Velocity.fromAngleAndSpeed(30 - 90, currentVelocity.getSpeed());
            } else if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX()
                    + 5 * this.rectangle.getWidth() / 5
                    && collisionPoint.getX() <= this.rectangle.getUpperRight().getX()) {
                currentVelocity = Velocity.fromAngleAndSpeed(60 - 90, currentVelocity.getSpeed());
            } else {
                temp = currentVelocity.getDy();
                currentVelocity.setDy(temp * -1);
            }
        }
        if (doubleCompare(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())
                || doubleCompare(collisionPoint.getX(), this.rectangle.getBottomRight().getX())) {
            temp = currentVelocity.getDx();
            currentVelocity.setDx(temp * -1);
        }
        return currentVelocity;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
// Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}