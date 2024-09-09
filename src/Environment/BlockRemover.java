package Environment;

import Objects.Ball;
import Objects.Block;

/**
 * The type Block remover.
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {

    private final GameLevel gameLevel;

    private final Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel     the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        remainingBlocks = new Counter(0);
        this.remainingBlocks.increase(gameLevel.getCounterBlocks().getValue() - (removedBlocks.getValue()));
        gameLevel.setCounterBlocks(remainingBlocks);
    }

    /**
     * // Block that are hit should be removed.
     * increase the score and delete the block.
     * @param beingHit the block
     * @param hitter   the ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        Counter c = gameLevel.getScore();
        c.increase(5);
        gameLevel.setScore(c);
        remainingBlocks.decrease(1);
        beingHit.removeFromGame(gameLevel);
    }
}