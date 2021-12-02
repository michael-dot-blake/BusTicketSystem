public abstract class Trip {

    protected Tap tapOn;
    protected double cost;

    public Trip(Tap tapOn) {
        this.tapOn = tapOn;
    }

    public Tap getTapOn() {
        return tapOn;
    }

}
