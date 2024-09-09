package Movement;

import GeometryPrimitives.Point;

/**
 * The type Movement.Velocity.
 */
// Movement.Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {

    private double speed;
    private double dx;
    private double dy;
    private double angle;

    /**
     * Instantiates a new Movement.Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
// constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        this.speed = Math.sqrt(dx * dx + dy * dy);
        this.angle = Math.toDegrees(Math.atan2(dy, dx));
    }

    /**
     * From angle and speed velocity.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = Math.toRadians(angle);
        double dx = speed * Math.cos(angleRad);
        double dy = speed * Math.sin(angleRad);
        return new Velocity(dx, dy);
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Gets angle.
     *
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets angle.
     *
     * @param angle the angle
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * Sets dx.
     *
     * @param dx the dx
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return dy;
    }

    /**
     * Sets dy.
     *
     * @param dy the dy
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * Apply to point point.
     *
     * @param p the p
     * @return the point
     */
// Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), p.getY() + this.dy);
    }
}