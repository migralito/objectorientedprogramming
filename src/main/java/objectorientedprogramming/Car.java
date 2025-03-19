package objectorientedprogramming;

abstract class Car {
    private boolean turnedOn = false;

    public void turnOn() {
        // TODO
        //  - change value of turnedOn attribute
        //  - first, verify if car is already turned on. In that case, throw a RuntimeException
        if (turnedOn) {
            throw new RuntimeException();
        } else {
            turnedOn = true;
        }
    }

    /**
     * Consumes a portion of the fuel.
     *
     * @return the remaining fuel after consumption. Where 0 is no fuel left, 1 is 100% left, 0.5 is 50% left, etc
     */
    public abstract float consumeFuel();
}
