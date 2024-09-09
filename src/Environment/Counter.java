package Environment;

/**
 * The type Counter.
 */
public class Counter {
    private int count;

    /**
     * Instantiates a new Counter.
     *
     * @param count the count
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * Increase.
     *
     * @param number the number
     */
// add number to current count.
    void increase(int number) {
        count += number;
    }

    /**
     * Decrease.
     *
     * @param number the number
     */
// subtract number from current count.
    void decrease(int number) {
        count -= number;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
// get current count.
    int getValue() {
        return count;
    }
}