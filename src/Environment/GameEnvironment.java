package Environment;

import GeometryPrimitives.Line;
import GeometryPrimitives.Point;
import Movement.CollisionInfo;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Environment.Game environment.
 */
public class GameEnvironment {
    private final List<Collidable> collection = new ArrayList<>();

    /**
     * Add collidable.
     *
     * @param c the c
     */
// add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        this.collection.add(c);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
// remove the given collidable from the environment.
    public void removeCollidable(Collidable c) {
        this.collection.remove(c);
    }

    /**
     * Gets closest collision.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
// Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point temp = null;
        Collidable rec = null;
        List<Collidable> c = new ArrayList<>(this.collection);
        // Notify all listeners about a hit event:
        for (Collidable collidable : c) {
            Point p;
            p = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            if (p == null) {
                continue;
            }
            if (temp == null) {
                temp = p;
                rec = collidable;
            } else {
                if (temp.distance(trajectory.start()) > p.distance(trajectory.start())) {
                    temp = p;
                    rec = collidable;
                }
            }
        }
        return new CollisionInfo(temp, rec);
    }


    /**
     * Draw on.
     *
     * @param d the d
     */
    public void drawOn(DrawSurface d) {
        for (Collidable collection : collection) {
            collection.drawOn(d);
        }
    }
}

