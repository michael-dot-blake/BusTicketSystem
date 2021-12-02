public class CancelledTrip extends Trip {

    private Tap tapOff;
    private final double CANCELLED_TRIP_COST = 0.0;

    public CancelledTrip(Tap tapOn, Tap tapOff) {
        super(tapOn);
        this.tapOff = tapOff;
        cost = CANCELLED_TRIP_COST;

    }

    public Tap getTapOff() {
        return tapOff;
    }

    @Override
    public String toString() {
        return "CancelledTrip{" +
                "tapOff=" + tapOff +
                ", CANCELLED_TRIP_COST=" + CANCELLED_TRIP_COST +
                '}';
    }
}
