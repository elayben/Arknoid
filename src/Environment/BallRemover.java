package Environment;

import Objects.Ball;
import Objects.Block;

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {

    private final GameLevel gameLevel;

    private final Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param gameLevel    the game
     * @param removedBalls the removed balls
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        remainingBalls = new Counter(0);
        this.remainingBalls.increase(gameLevel.getCounterBalls().getValue() - (removedBalls.getValue()));
        gameLevel.setCounterBalls(remainingBalls);
    }

    /**
     * // Balls that are hit should be removed.
     *
     * @param beingHit the block
     * @param hitter   the ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBalls.decrease(1);
        hitter.removeFromGame(gameLevel);
    }
}