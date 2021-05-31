package objectorientedprogramming;

abstract class Auto {
    private boolean turnedOn = false;

    public void turnOn() {
        // TODO
        //  - change value of turnedOn attribute
        //  - first, verify if car is already turned on. In that case, throw a RuntimeException
    }

    /**
     * @return the remaining fuel after consumption. Where 0 is no fuel left, 1 is 100% left, 0.5 is 50% left, etc
     */
    public abstract float getFuelLeft();

    /**
     * Consumes a portion of the fuel.
     *
     * @return the remaining fuel after consumption. Where 0 is no fuel left, 1 is 100% left, 0.5 is 50% left, etc
     */
    public abstract float consumeFuel();
}
