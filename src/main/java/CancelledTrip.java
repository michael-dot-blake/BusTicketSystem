import java.time.temporal.ChronoUnit;

/**
 * @author michaelblake 2021
 *
 * A class used to represent a Cancelled Trip, where a traveller has
 * tappen on and tapped off at the same stop.
 * The value of this trip is hardcoded in.
 */

public class CancelledTrip extends Trip {

    private Tap tapOff;
    private final double CANCELLED_TRIP_COST = 0.0;

    public CancelledTrip(Tap tapOn, Tap tapOff) {
        super(tapOn);
        this.tapOff = tapOff;
        started = tapOn.getDateTimeUTC();
        finished = tapOff.getDateTimeUTC();
        fromStopId = tapOn.getStopId();
        toStopId = tapOff.getStopId();
        tripDuration = ChronoUnit.SECONDS.between(tapOn.getDateTimeUTC(), tapOff.getDateTimeUTC());
        chargeAmount = CANCELLED_TRIP_COST;
        companyId = tapOn.getCompanyId();
        busId = tapOn.getBusId();
        PAN = tapOn.getPan();
        status = Status.CANCELLED;
    }

    public Tap getTapOff() {
        return tapOff;
    }

    @Override
    public String toString() {
        return "Cancelled Trip{" +
                "Started=" + tapOn.getDateTimeUTC() +
                ", Finished=" + tapOff.getDateTimeUTC() +
                ", DurationSecs=" + tripDuration +
                ", FromStopId=" + tapOn.getStopId() +
                ", ToStopId=" + tapOn.getStopId() +
                ", ChargeAmount=" + chargeAmount +
                ", CompanyId=" + tapOn.getCompanyId() +
                ", BusID=" + tapOn.getBusId() +
                ", PAN=" + tapOn.getPan() +
                ", Status=" + this.status +
                '}';
    }
}
