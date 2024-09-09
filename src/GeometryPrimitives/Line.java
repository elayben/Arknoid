package GeometryPrimitives;

import java.util.List;

/**
 * The type GeometryPrimitives.Line.
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * Instantiates a new GeometryPrimitives.Line.
     *
     * @param start the start
     * @param end   the end
     */
// constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;

    }

    /**
     * Instantiates a new GeometryPrimitives.Line.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);

    }

    /**
     * Length double.
     *
     * @return the double
     */
// Return the length of the line
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Middle point.
     *
     * @return the point
     */
// Returns the middle point of the line
    public Point middle() {
        double xM = (this.start.getX() + this.end.getX()) / 2;
        double yM = (this.start.getY() + this.end.getY()) / 2;
        return new Point(xM, yM);
    }

    /**
     * Start point.
     *
     * @return the point
     */
// Returns the start point of the line
    public Point start() {
        return this.start;
    }

    /**
     * End point.
     *
     * @return the point
     */
// Returns the end point of the line
    public Point end() {
        return this.end;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * Is intersecting boolean.
     *
     * @param other the other
     * @return the boolean
     */
// Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {

        double lowerY1 = Math.min(this.start.getY(), this.end.getY());
        double upperY1 = Math.max(this.start.getY(), this.end.getY());
        double lowerY2 = Math.min(other.start.getY(), other.end.getY());
        double upperY2 = Math.max(other.start.getY(), other.end.getY());
        boolean b = (lowerY1 > lowerY2 && lowerY1 < upperY2)
                || (upperY1 > lowerY2 && upperY1 < upperY2)
                || (lowerY1 < lowerY2 && lowerY2 < upperY1)
                || (lowerY1 < upperY2 && upperY2 < upperY1);
        double lowerX1 = Math.min(this.start.getX(), this.end.getX());
        double upperX1 = Math.max(this.start.getX(), this.end.getX());
        double lowerX2 = Math.min(other.start.getX(), other.end.getX());
        double upperX2 = Math.max(other.start.getX(), other.end.getX());
        boolean betweenX = (lowerX1 > lowerX2 && lowerX1 < upperX2)
                || (upperX1 > lowerX2 && upperX1 < upperX2)
                || (lowerX1 < lowerX2 && lowerX2 < upperX1)
                || (lowerX1 < upperX2 && upperX2 < upperX1);
        if (this.equals(other)) {
            return true;
        }
        if (doubleCompare(this.start.getX(), this.end.getX())
                || doubleCompare(other.start.getX(), other.end.getX())) {
            if (doubleCompare(lowerY1, upperY2)) {
                return true;
            }
            if (doubleCompare(lowerY2, upperY1)) {
                return true;
            }
            if (doubleCompare(this.start.getX(), this.end.getX())
                    && doubleCompare(other.start.getX(), other.end.getX())) {
                if (doubleCompare(this.start.getX(), other.start.getX())) {
                    return b;
                } else {
                    return false;
                }
            }
            if (doubleCompare(this.start.getX(), this.end.getX())
                    && !doubleCompare(other.start.getX(), other.end.getX())) {
                double x1 = this.start.getX();
                double y1 = other.slope() * x1 + other.getB();
                Point p = new Point(x1, y1);
                return (!(p.distance(this.start) > this.length()))
                        && (!(p.distance(other.start) > other.length()))
                        && (!(p.distance(this.end) > this.length()))
                        && (!(p.distance(other.end) > other.length()));
            }
            if (!doubleCompare(this.start.getX(), this.end.getX())
                    && doubleCompare(other.start.getX(), other.end.getX())) {
                double x1 = other.end.getX();
                double y1 = this.slope() * x1 + this.getB();
                Point p = new Point(x1, y1);
                return (!(p.distance(this.start) > this.length()))
                        && (!(p.distance(other.start) > other.length()))
                        && (!(p.distance(this.end) > this.length()))
                        && (!(p.distance(other.end) > other.length()));
            }
        }

        if (doubleCompare(this.slope(), other.slope())
                && !doubleCompare(this.getB(), other.getB())) {
            return false;
        }
        if (doubleCompare(this.slope(), other.slope())
                && doubleCompare(this.getB(), other.getB())) {

            return this.start.equals(other.start) || this.start.equals(other.end)
                    || this.end.equals(other.start) || this.end.equals(other.end)
                    || betweenX;


        }
        double x1 = (other.getB() - this.getB()) / (this.slope() - other.slope());
        double y1 = this.slope() * x1 + this.getB();
        if (Double.isNaN(x1) || Double.isNaN(y1)) {
            return false;
        }
        Point p = new Point(x1, y1);
        return (!(p.distance(this.start) > this.length()))
                && (!(p.distance(other.start) > other.length()))
                && (!(p.distance(this.end) > this.length()))
                && (!(p.distance(other.end) > other.length()));

    }

    /**
     * Check is on line boolean.
     *
     * @param p  the p
     * @param l1 the l 1
     * @param l2 the l 2
     * @return the boolean
     */
    public boolean checkIsOnLine(Point p, Line l1, Line l2) {
        return (!(p.distance(l1.start) > l1.length()))
                && (!(p.distance(l2.start) > l2.length()))
                && (!(p.distance(l1.end) > l1.length()))
                && (!(p.distance(l2.end) > l2.length()));
    }

    /**
     * Intersection with point.
     *
     * @param other the other
     * @return the point
     */
// Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        double lowerY1 = Math.min(this.start.getY(), this.end.getY());
        double upperY1 = Math.max(this.start.getY(), this.end.getY());
        double lowerY2 = Math.min(other.start.getY(), other.end.getY());
        double upperY2 = Math.max(other.start.getY(), other.end.getY());
        boolean betweenY = (lowerY1 >= lowerY2 && lowerY1 <= upperY2)
                || (upperY1 >= lowerY2 && upperY1 <= upperY2)
                || (lowerY1 <= lowerY2 && lowerY2 <= upperY1)
                || (lowerY1 <= upperY2 && upperY2 <= upperY1);
        double lowerX1 = Math.min(this.start.getX(), this.end.getX());
        double upperX1 = Math.max(this.start.getX(), this.end.getX());
        double lowerX2 = Math.min(other.start.getX(), other.end.getX());
        double upperX2 = Math.max(other.start.getX(), other.end.getX());
        boolean betweenX = (lowerX1 >= lowerX2 && lowerX1 <= upperX2)
                || (upperX1 >= lowerX2 && upperX1 <= upperX2)
                || (lowerX1 <= lowerX2 && lowerX2 <= upperX1)
                || (lowerX1 <= upperX2 && upperX2 <= upperX1);
        if (this.equals(other)) {
            return null;
        }
        if (doubleCompare(this.start.getX(), this.end.getX())
                || doubleCompare(other.start.getX(), other.end.getX())) {

            if (doubleCompare(this.start.getX(), this.end.getX())
                    && doubleCompare(other.start.getX(), other.end.getX())) {
                if (doubleCompare(lowerY1, upperY2)) {
                    return new Point(this.start.getX(), lowerY1);
                }
                if (doubleCompare(lowerY2, upperY1)) {
                    return new Point(this.start.getX(), lowerY2);
                }

                if (doubleCompare(this.start.getX(), other.start.getX())) {
                    if (betweenY) {
                        return start;
                    } else {
                        return null;
                    }

                }
            }
            if (doubleCompare(this.start.getX(), this.end.getX())
                    && !doubleCompare(other.start.getX(), other.end.getX())) {
                double x1 = this.start.getX();
                double y1 = other.slope() * x1 + other.getB();
                Point p = new Point(x1, y1);
                if ((betweenY && betweenX) || this.start.equals(other.start) || this.start.equals(other.end)
                        || this.end.equals(other.start) || this.end.equals(other.end) || betweenX) {
                    if (checkIsOnLine(p, this, other)) {
                        return p;
                    }
                    return null;
                }

            }
            if (!doubleCompare(this.start.getX(), this.end.getX())
                    && doubleCompare(other.start.getX(), other.end.getX())) {
                double x1 = other.start.getX();
                double y1 = this.slope() * x1 + this.getB();
                Point p = new Point(x1, y1);
                if ((betweenY && betweenX) || this.start.equals(other.start) || this.start.equals(other.end)
                        || this.end.equals(other.start) || this.end.equals(other.end) || betweenX) {
                    if (checkIsOnLine(p, this, other)) {
                        return p;
                    }
                    return null;
                }
            }
        }

        if (doubleCompare(this.slope(), other.slope()) && !doubleCompare(this.getB(), other.getB())) {
            return null;
        }
        if (doubleCompare(this.slope(), other.slope()) && doubleCompare(this.getB(), other.getB())) {
            if (!betweenX) {
                if (this.start.equals(other.start)) {
                    return this.start;
                }
                if (this.start.equals(other.end)) {
                    return this.start;
                }
                if (this.end.equals(other.start)) {
                    return this.end;
                }
                if (this.end.equals(other.end)) {
                    return this.end;
                }
            } else {
                return null;
            }


        }
        double x1 = (other.getB() - this.getB()) / (this.slope() - other.slope());
        double y1 = this.slope() * x1 + this.getB();
        if (Double.isNaN(x1) || Double.isNaN(y1)) {
            return null;
        }
        Point p = new Point(x1, y1);
        if (((!(p.distance(this.start) > this.length()))
                && (!(p.distance(other.start) > other.length()))
                && (!(p.distance(this.end) > this.length()))
                && (!(p.distance(other.end) > other.length())))) {
            return new Point(x1, y1);
        } else {
            return null;
        }


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
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
// equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return ((this.start.equals(other.start)) && (this.end.equals(other.end)))
                || ((this.end.equals(other.start)) && (this.start.equals(other.end)));
    }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rect
     * @return the point
     */
// If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list1;
        list1 = rect.intersectionPoints(this);
        if (list1.isEmpty()) {
            return null;
        }
        Point temp = list1.get(0);
        for (Point p : list1) {
            if (temp.distance(this.start()) > p.distance(this.start())) {
                temp = p;
            }
        }
        return temp;
    }

    /**
     * Slope double.
     *
     * @return the double
     */
    public double slope() {
        return ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public double getB() {
        return (this.start.getY() - (this.slope() * this.start.getX()));
    }


}