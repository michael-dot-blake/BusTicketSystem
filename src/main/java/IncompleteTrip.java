/**
 * @author michaelblake 2021
 *
 * A class used to represent an Incomplete Trip, where a traveller has
 * tapped on but not tapped off.
 * It implements the calculateTripCost() method which returns a different value
 * based on which stop the traveller tapped on at.
 */

public class IncompleteTrip extends Trip implements ITripCostCalculator {

    public IncompleteTrip(Tap tapOn) {
        super(tapOn);
        started = tapOn.getDateTimeUTC();
        fromStopId = tapOn.getStopId();
        chargeAmount = calculateTripCost();
        companyId = tapOn.getCompanyId();
        busId = tapOn.getBusId();
        PAN = tapOn.getPan();
        status = Status.INCOMPLETE;
    }

    @Override
    public double calculateTripCost() {

        if (tapOn.getStopId().equalsIgnoreCase("Stop1")) {
            chargeAmount = 7.3;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop3")) {
            chargeAmount = 7.3;
        }
        if (tapOn.getStopId().equalsIgnoreCase("Stop2")) {
            chargeAmount = 5.5;
        }
        return chargeAmount;
    }

    @Override
    public String toString() {
        return "Incomplete Trip{" +
                "Started=" + tapOn.getDateTimeUTC() +
                ", Finished=" + "-----" +
                ", DurationSecs=" + 0 +
                ", FromStopId=" + tapOn.getStopId() +
                ", ToStopId=" + "-----" +
                ", ChargeAmount=" + chargeAmount +
                ", CompanyId=" + tapOn.getCompanyId() +
                ", BusID=" + tapOn.getBusId() +
                ", PAN=" + tapOn.getPan() +
                ", Status=" + this.status +
                '}';
    }
}
