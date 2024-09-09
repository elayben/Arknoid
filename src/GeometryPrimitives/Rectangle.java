package GeometryPrimitives;

import java.util.ArrayList;
import java.util.List;

/**
 * The type GeometryPrimitives.Rectangle.
 */
public class Rectangle {
    private final Point upperLeft;
    private final double width;
    private final double height;
    private final Point upperRight;
    private final Point bottomLeft;
    private final Point bottomRight;

    /**
     * Instantiates a new GeometryPrimitives.Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
// Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
        this.upperRight = new Point(this.upperLeft.getX() + width,
                this.upperLeft.getY());
        this.bottomLeft = new Point(this.upperLeft.getX(),
                this.upperLeft.getY() + height);
        this.bottomRight = new Point(this.upperLeft.getX() + width,
                this.upperLeft.getY() + height);
    }

    /**
     * Gets upper right.
     *
     * @return the upper right
     */
    public Point getUpperRight() {
        return upperRight;
    }

    /**
     * Gets bottom left.
     *
     * @return the bottom left
     */
    public Point getBottomLeft() {
        return bottomLeft;
    }

    /**
     * Gets bottom right.
     *
     * @return the bottom right
     */
    public Point getBottomRight() {
        return bottomRight;
    }

    /**
     * Is inside rectangle boolean.
     *
     * @param p the p
     * @return the true if the point is inside the rectangle
     */
    public boolean isInsideRec(Point p) {
        if (p.getY() >= 600) {
            return true;
        }
        return p.getX() >= this.getUpperLeft().getX()
                && p.getX() <= this.getUpperRight().getX()
                && p.getY() <= this.getBottomLeft().getY()
                && p.getY() >= this.getUpperLeft().getY();
    }

    /**
     * Intersection points java . util . list.
     *
     * @param line the line
     * @return the java . util . list
     */
// Return a (possibly empty) List of intersection points
    // with the specified line.
    public java.util.List<Point> intersectionPoints(Line line) {

        Line lineTop = new Line(upperLeft, upperRight);
        Line lineRight = new Line(upperRight, bottomRight);
        Line lineBottom = new Line(bottomRight, bottomLeft);
        Line lineLeft = new Line(bottomLeft, upperLeft);
        List<Point> list = new ArrayList<>();
        Point temp;
        temp = lineTop.intersectionWith(line);
        if (temp != null) {
            list.add(temp);
        }
        temp = lineRight.intersectionWith(line);
        if (temp != null) {
            list.add(temp);
        }
        temp = lineBottom.intersectionWith(line);
        if (temp != null) {
            list.add(temp);
        }
        temp = lineLeft.intersectionWith(line);
        if (temp != null) {
            list.add(temp);
        }
        return list;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
// Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
// Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}