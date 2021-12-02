public class CompletedTrip extends Trip implements ITripCostCalculator {

    protected Tap tapOff;

    public CompletedTrip(Tap tapOn, Tap tapOff) {
        super(tapOn);
        this.tapOff = tapOff;
        cost = calculateTripCost();
    }

    @Override
    public double calculateTripCost() {

        if (tapOn.getStopId().equalsIgnoreCase("Stop1") &&
                tapOff.getStopId().equalsIgnoreCase("Stop2")) {
            cost = 3.25;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop2") &&
                tapOff.getStopId().equalsIgnoreCase("Stop1")) {
            cost = 3.25;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop2") &&
                tapOff.getStopId().equalsIgnoreCase("Stop3")) {
            cost = 5.50;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop3") &&
                tapOff.getStopId().equalsIgnoreCase("Stop2")) {
            cost = 5.50;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop1") &&
                tapOff.getStopId().equalsIgnoreCase("Stop3")) {
            cost = 7.30;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop3") &&
                tapOff.getStopId().equalsIgnoreCase("Stop1")) {
            cost = 7.30;
        }
        return cost;

    }

    public Tap getTapOff() {
        return tapOff;
    }

    @Override
    public String toString() {
        return "CompletedTrip{" +
                "Pan=" + tapOn.getPan() +
                ", Tap On ID=" + tapOn.getId() +
                ", Tap Off ID=" + tapOff.getId() +
                ", Tapped on at=" + tapOn.getStopId() +
                ", Tapped off at=" + tapOff.getStopId() +
                ". Cost = " + cost +
                '}';
    }
}
