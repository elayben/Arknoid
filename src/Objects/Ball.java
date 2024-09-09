package Objects;

import Environment.GameEnvironment;
import Environment.GameLevel;
import Environment.Sprite;
import GeometryPrimitives.Line;
import GeometryPrimitives.Point;
import Movement.CollisionInfo;
import Movement.Velocity;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;


/**
 * The type Objects.Ball.
 */
public class Ball implements Sprite {
    /**
     * The constant TOPBOUND.
     */
    public static final int TOPBOUND = 0;
    /**
     * The constant RIGHTBOUND.
     */
    public static final int RIGHTBOUND = 800;
    /**
     * The constant BOTTOMBOUND.
     */
    public static final int BOTTOMBOUND = 600;
    /**
     * The constant LEFTBOUND.
     */
    public static final int LEFTBOUND = 0;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private DrawSurface d;
    private GUI gui;
    private GeometryPrimitives.Point center;
    private int r;
    private java.awt.Color color;

    /**
     * Instantiates a new Objects.Ball.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
    public Ball(GeometryPrimitives.Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * Instantiates a new Objects.Ball.
     *
     * @param velocity        the velocity
     * @param gameEnvironment the game environment
     * @param point           the point
     * @param r               the r
     * @param color           the color
     */
    public Ball(Velocity velocity, GameEnvironment gameEnvironment,
                GeometryPrimitives.Point point, int r, Color color) {
        this.velocity = velocity;
        this.gameEnvironment = gameEnvironment;
        this.center = point;
        this.r = r;
        this.color = color;
    }

    // constructor


    /**
     * Instantiates a new Objects.Ball.
     *
     * @param x     the x
     * @param y     the y
     * @param r     the r
     * @param color the color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new GeometryPrimitives.Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * End point of line point.
     *
     * @param b1 the b 1
     * @return the point
     */
    public static GeometryPrimitives.Point endPointOfLine(Ball b1) {
        if (doubleCompare(b1.getVelocity().getDx(), LEFTBOUND) && b1.getVelocity().getDy() > TOPBOUND) {
            return new GeometryPrimitives.Point(b1.getX(), BOTTOMBOUND);
        }
        if (doubleCompare(b1.getVelocity().getDx(), LEFTBOUND) && b1.getVelocity().getDy() < TOPBOUND) {
            return new GeometryPrimitives.Point(b1.getX(), TOPBOUND);
        }
        if (doubleCompare(b1.getVelocity().getDy(), TOPBOUND) && b1.getVelocity().getDx() > LEFTBOUND) {
            return new GeometryPrimitives.Point(RIGHTBOUND, b1.getY());
        }
        if (doubleCompare(b1.getVelocity().getDy(), TOPBOUND) && b1.getVelocity().getDx() < LEFTBOUND) {
            return new GeometryPrimitives.Point(LEFTBOUND, b1.getY());
        }
        double slope = b1.getVelocity().getDy() / b1.getVelocity().getDx();
        double bOfLine = b1.getY() - (slope * b1.getX());

        // Calculate the intersection points with the left and right edges of the screen
        double yLeft = bOfLine;
        double yRight = slope * RIGHTBOUND + bOfLine;
        double xRight = RIGHTBOUND;
        double xLeft = LEFTBOUND;
        if (yRight > BOTTOMBOUND) {
            xRight = (BOTTOMBOUND - bOfLine) / slope;
            yRight = BOTTOMBOUND;
        }
        if (yRight < 0) {
            xRight = (TOPBOUND - bOfLine) / slope;
            yRight = TOPBOUND;
        }
        if (yLeft > BOTTOMBOUND) {
            xLeft = (BOTTOMBOUND - bOfLine) / slope;
            yLeft = BOTTOMBOUND;
        }
        if (yLeft < TOPBOUND) {
            xLeft = (TOPBOUND - bOfLine) / slope;
            yLeft = TOPBOUND;
        }
        if (b1.velocity.getDx() > LEFTBOUND) {
            return new GeometryPrimitives.Point(xRight, yRight);
        }
        if (b1.velocity.getDx() < LEFTBOUND) {
            return new GeometryPrimitives.Point(xLeft, yLeft);
        }
        return null;
    }

    /**
     * Double compare boolean.
     *
     * @param d1 the d 1
     * @param d2 the d 2
     * @return true if the two doubles are equal,else - false.
     */
    public static boolean doubleCompare(double d1, double d2) {
        double eps = 0.0001d;
        return Math.abs(d1 - d2) < eps;
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
     * Sets gui.
     *
     * @param gui the gui
     */
    public void setGui(GUI gui) {
        this.gui = gui;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public DrawSurface getD() {
        return d;
    }

    /**
     * Sets d.
     *
     * @param d the d
     */
    public void setD(DrawSurface d) {
        this.d = d;
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * Sets game environment.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * Gets center.
     *
     * @return the center
     */
    public GeometryPrimitives.Point getCenter() {
        return center;
    }

    /**
     * Sets center.
     *
     * @param center the center
     */
    public void setCenter(GeometryPrimitives.Point center) {
        this.center = center;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
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
     * Gets r.
     *
     * @return the r
     */
    public int getR() {
        return r;
    }

    /**
     * Sets r.
     *
     * @param r the r
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param d the surface
     */
    public void drawOn(DrawSurface d) {
        int x = this.getX();
        int y = this.getY();
        int r = this.getR();
        d.setColor(Color.BLACK);
        d.drawCircle(x, y, r);
        d.setColor(this.getColor());
        d.fillCircle(x, y, r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Sets velocity.
     *
     * @param v the v
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

    /**
     * Move One Step.
     * Moves the ball one step
     */
    public void moveOneStep() {
        Line l = new Line(this.getCenter(), endPointOfLine(this));
        CollisionInfo ci = this.getGameEnvironment().getClosestCollision(l);
        if (ci.collisionPoint() == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        Point p = new Point(velocity.getDx() + getX(), velocity.getDy() + getY());
        if (/*center.distance(ci.collisionPoint()) < center.distance(p)
                || */ci.collisionObject().getCollisionRectangle().isInsideRec(p)) {
            /*
            double dist = this.center.distance(ci.collisionPoint()) - 0.1;
            Velocity tempV = Velocity.fromAngleAndSpeed(this.velocity.getAngle(), dist);
            this.center = tempV.applyToPoint(this.center);
             */
            Movement.Velocity v = ci.collisionObject().hit(this, ci.collisionPoint(), this.getVelocity());
            this.setVelocity(v);
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }
}

