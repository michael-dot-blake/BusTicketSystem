public class IncompleteTrip extends Trip implements ITripCostCalculator {

    public IncompleteTrip(Tap tapOn) {
        super(tapOn);
        cost = calculateTripCost();
    }

    @Override
    public double calculateTripCost() {

        if (tapOn.getStopId().equalsIgnoreCase("Stop1")) {
            cost = 7.3;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop3")) {
            cost = 7.3;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop2")) {
            cost = 5.5;
        }
        return cost;
    }

    @Override
    public String toString() {
        return "IncompleteTrip{" +
                "tapOn=" + tapOn +
                ", cost=" + cost +
                '}';
    }
}
