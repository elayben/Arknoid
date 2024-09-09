package GeometryPrimitives;

/**
 * The type GeometryPrimitives.Point.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Instantiates a new GeometryPrimitives.Point.
     *
     * @param x the x
     * @param y the y
     */
// constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance double.
     *
     * @param other the other
     * @return the double
     */
// distance -- return the distance of this point to the other point
    public double distance(Point other) {
        double x1 = this.x;
        double x2 = other.x;
        double y1 = this.y;
        double y2 = other.y;

        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
// equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        double x1 = this.x;
        double x2 = other.x;
        double y1 = this.y;
        double y2 = other.y;

        return (doubleCompare(x1, x2) && doubleCompare(y1, y2));
    }

    /**
     * Double compare boolean.
     * compares the two doubles
     *
     * @param d1 the d 1
     * @param d2 the d 2
     * @return true is true,false if not equal
     */
    public boolean doubleCompare(double d1, double d2) {
        double eps = 0.0001d;
        return Math.abs(d1 - d2) < eps;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
// Return the x and y values of this point
    public double getX() {
        return this.x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(double y) {
        this.y = y;
    }
}