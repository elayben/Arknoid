package Levels;

import Environment.LevelInformation;
import Environment.Sprite;
import Movement.Velocity;
import Objects.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Green 3.
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        /*Random rand = new Random();*/
        List<Velocity> l = new ArrayList<>();
        Velocity v1 = Velocity.fromAngleAndSpeed(220 /*rand.nextInt(330 - 210 + 1) + 210*/, 5);
        Velocity v2 = Velocity.fromAngleAndSpeed(320/*rand.nextInt(330 - 210 + 1) + 210*/, 5);
        l.add(v1);
        l.add(v2);
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return " Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new BGGreen3();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        Color color = Color.gray;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 12; j++) {
                if (!(j >= 12 - i)) {
                    if (i == 1) {
                        color = Color.red;
                    }
                    if (i == 2) {
                        color = Color.yellow;
                    }
                    if (i == 3) {
                        color = Color.blue;
                    }
                    if (i == 4) {
                        color = Color.white;
                    }
                    GeometryPrimitives.Rectangle rec = new GeometryPrimitives.
                            Rectangle(new GeometryPrimitives.Point(740 - j * 40, 200 + i * 20), 40, 20);
                    Block b = new Block(rec, color);
                    l.add(b);
                }
            }
        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
