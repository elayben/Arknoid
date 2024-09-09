package Environment;


import GeometryPrimitives.Rectangle;
import Movement.Velocity;
import Objects.Ball;
import Objects.Block;
import Objects.Paddle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Environment.Game.
 */
public class GameLevel implements Animation {
    /**
     * The constant WIDTH.
     */
    public static final int WIDTH = 800;
    /**
     * The constant HEIGHT.
     */
    public static final int HEIGHT = 600;
    /**
     * The constant LEFTBOUND.
     */
    public static final int LEFTBOUND = 0;
    /**
     * The constant RADIUS.
     */
    public static final int RADIUS = 4;
    //private final GUI gui;
    private final SpriteCollection sprites;
    private final AnimationRunner runner;
    private final KeyboardSensor keyboard;
    private final LevelInformation li;
    private GameEnvironment environment;
    private Counter counterBalls;
    private Counter counterBlocks;
    private Counter score;
    private boolean running;

    /**
     * Instantiates a new Environment.Game.
     *
     * @param li              the li
     * @param ks              the ks
     * @param score           the score
     * @param animationRunner the animation runner
     */
    public GameLevel(LevelInformation li, KeyboardSensor ks, Counter score, AnimationRunner animationRunner) {
        this.li = li;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.score = score;
        counterBalls = new Counter(li.numberOfBalls());
        counterBlocks = new Counter(li.numberOfBlocksToRemove());
        runner = animationRunner;
        keyboard = ks;

    }

    /**
     * Gets sprites.
     *
     * @return the sprites
     */
    public SpriteCollection getSprites() {
        return sprites;
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
     * Gets runner.
     *
     * @return the runner
     */
    public AnimationRunner getRunner() {
        return runner;
    }

    /**
     * Gets counter balls.
     *
     * @return the counter balls
     */
    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     * Sets counter balls.
     *
     * @param counterBalls the counter balls
     */
    public void setCounterBalls(Counter counterBalls) {
        this.counterBalls = counterBalls;
    }

    /**
     * Gets counter blocks.
     *
     * @return the counter blocks
     */
    public Counter getCounterBlocks() {
        return counterBlocks;
    }

    /**
     * Sets counter blocks.
     *
     * @param counterBlocks the counter blocks
     */
    public void setCounterBlocks(Counter counterBlocks) {
        this.counterBlocks = counterBlocks;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Counter getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param n the n
     */
    public void setScore(Counter n) {
        this.score = n;
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * Sets environment.
     *
     * @param environment the environment
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    /**
     * Add collidable.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    private void createBoundsAndPaddle() {
        BallRemover ballRemover = new BallRemover(this, new Counter(0));
        GeometryPrimitives.Rectangle recPaddel =
                new GeometryPrimitives.Rectangle(new GeometryPrimitives.Point(((double) WIDTH - li.paddleWidth()) / 2,
                        560),
                        li.paddleWidth(), 20);
        Paddle paddle = new Paddle(recPaddel, Color.yellow, keyboard, li.paddleSpeed());
        paddle.addToGame(this);
        GeometryPrimitives.Rectangle rec1 = new
                GeometryPrimitives.Rectangle(new GeometryPrimitives.Point(LEFTBOUND, 20), WIDTH, 20);
        GeometryPrimitives.Rectangle recRight =
                new Rectangle(new GeometryPrimitives.Point(WIDTH - 20, 40), 20, HEIGHT - 40);
        GeometryPrimitives.Rectangle recBottom =
                new GeometryPrimitives.Rectangle(new GeometryPrimitives.Point(20, HEIGHT - 1), WIDTH - 40, 1);
        Block bBottom = new Block(recBottom, Color.red);
        GeometryPrimitives.Rectangle recLeft =
                new GeometryPrimitives.Rectangle(new GeometryPrimitives.Point(LEFTBOUND, 40), 20, HEIGHT - 40);
        Block b1 = new Block(rec1, Color.gray);
        Block b2 = new Block(recRight, Color.gray);
        Block b4 = new Block(recLeft, Color.gray);
        Block[] blocksBounds = new Block[]{b1, b2, b4};
        bBottom.addToGame(this);
        bBottom.addHitListener(ballRemover);
        for (Block block : blocksBounds) {
            block.addToGame(this);
        }
    }

    /**
     * Initialize.
     */
// Initialize a new game: create the Blocks and Objects.Ball (and Objects.Paddle)
    // and add them to the game.
    public void initialize() {
        BlockRemover blockRemover = new BlockRemover(this, new Counter(0));
        List<Block> blockList = new ArrayList<>(li.blocks());
        // Notify all listeners about a hit event:
        for (Block b : blockList) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
        }
    }

    /**
     * Run.
     */
// Run the game -- start the animation loop.
    public void run() {
        this.createBallsOnTopOfPaddle();
        this.createBoundsAndPaddle();
        this.runner.run(new CountdownAnimation(2 * 1000, 3, this.getSprites()));
        this.running = true;
        this.runner.run(this);
    }

    private void createBallsOnTopOfPaddle() {
        GeometryPrimitives.Point center = new GeometryPrimitives.Point(400, 540);
        for (Velocity v : li.initialBallVelocities()) {
            Ball b = new Ball(v, this.getEnvironment(), center,
                    RADIUS, new java.awt.Color((int) (Math.random() * 0x1000000)));
            b.addToGame(this);
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        li.getBackground().drawOn(d);
        // game-specific logic
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "p", new PauseScreen()));
        }

        if (counterBlocks.getValue() <= 0) {
            score.increase(100);
            this.running = false;
        }
        if (counterBalls.getValue() <= 0) {
            this.running = false;
        }
    }
}