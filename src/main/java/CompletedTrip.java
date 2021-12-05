import java.time.temporal.ChronoUnit;

public class CompletedTrip extends Trip implements ITripCostCalculator {

    private Tap tapOff;

    public CompletedTrip(Tap tapOn, Tap tapOff) {
        super(tapOn);
        this.tapOff = tapOff;
        started = tapOn.getDateTimeUTC();
        finished = tapOff.getDateTimeUTC();
        fromStopId = tapOn.getStopId();
        toStopId = tapOff.getStopId();
        tripDuration = ChronoUnit.SECONDS.between(tapOn.getDateTimeUTC(), tapOff.getDateTimeUTC());
        chargeAmount = calculateTripCost();
        companyId = tapOn.getCompanyId();
        busId = tapOn.getBusId();
        PAN = tapOn.getPan();
        status = Status.COMPLETED;
    }

    @Override
    public double calculateTripCost() {

        if (tapOn.getStopId().equalsIgnoreCase("Stop1") &&
                tapOff.getStopId().equalsIgnoreCase("Stop2")) {
            chargeAmount = 3.25;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop2") &&
                tapOff.getStopId().equalsIgnoreCase("Stop1")) {
            chargeAmount = 3.25;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop2") &&
                tapOff.getStopId().equalsIgnoreCase("Stop3")) {
            chargeAmount = 5.50;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop3") &&
                tapOff.getStopId().equalsIgnoreCase("Stop2")) {
            chargeAmount = 5.50;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop1") &&
                tapOff.getStopId().equalsIgnoreCase("Stop3")) {
            chargeAmount = 7.30;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop3") &&
                tapOff.getStopId().equalsIgnoreCase("Stop1")) {
            chargeAmount = 7.30;
        }
        return chargeAmount;

    }

    public Tap getTapOff() {
        return tapOff;
    }

    @Override
    public String toString() {
        return "Completed Trip{" +
                "Started=" + tapOn.getDateTimeUTC() +
                ", Finished=" + tapOff.getDateTimeUTC() +
                ", DurationSecs=" + tripDuration +
                ", FromStopId=" + tapOn.getStopId() +
                ", ToStopId=" + tapOff.getStopId() +
                ", ChargeAmount=" + chargeAmount +
                ", CompanyId=" + tapOn.getCompanyId() +
                ", BusID=" + tapOn.getBusId() +
                ", PAN=" + tapOn.getPan() +
                ", Status=" + this.status +
                '}';
    }
}
