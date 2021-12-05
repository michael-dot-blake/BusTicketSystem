import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;

import java.time.LocalDateTime;

public abstract class Trip implements Comparable<Trip>{

    protected Tap tapOn;

    @CsvBindByPosition(position = 0)
    protected LocalDateTime started;
    @CsvBindByPosition(position = 1)
    protected LocalDateTime finished;
    @CsvBindByPosition(position = 2)
    protected String fromStopId;
    @CsvBindByPosition(position = 3)
    protected String toStopId;
    @CsvBindByPosition(position = 4)
    protected long tripDuration;
    @CsvNumber("$0.00")
    @CsvBindByPosition(position = 5)
    protected double chargeAmount;
    @CsvBindByPosition(position = 6)
    protected String companyId;
    @CsvBindByPosition(position = 7)
    protected String busId;
    @CsvBindByPosition(position = 8)
    protected String PAN;
    @CsvBindByPosition(position = 9)
    protected Status status;

    public Trip(Tap tapOn) {
        this.tapOn = tapOn;
    }

    public Tap getTapOn() {
        return tapOn;
    }

    public int compareTo(Trip anotherTrip) {
        return this.getTapOn().getDateTimeUTC().compareTo(anotherTrip.getTapOn().getDateTimeUTC());
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tapOn=" + tapOn +
                ", started=" + started +
                ", finished=" + finished +
                ", fromStopId='" + fromStopId + '\'' +
                ", toStopId='" + toStopId + '\'' +
                ", tripDuration=" + tripDuration +
                ", chargeAmount=" + chargeAmount +
                ", companyId='" + companyId + '\'' +
                ", busId='" + busId + '\'' +
                ", PAN='" + PAN + '\'' +
                ", status=" + status +
                '}';
    }
}

