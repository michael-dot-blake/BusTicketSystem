import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

import java.time.LocalDateTime;

public class Tap implements Comparable<Tap> {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvCustomBindByPosition(position = 1, converter = LocalDateTimeConverter.class)
    private LocalDateTime dateTimeUTC;

    @CsvBindByPosition(position = 2)
    private String tapType;

    @CsvBindByPosition(position = 3)
    private String stopId;

    @CsvBindByPosition(position = 4)
    private String companyId;

    @CsvBindByPosition(position = 5)
    private String busId;

    @CsvBindByPosition(position = 6)
    private String pan;

    public Tap() {

    }


    public Tap(String id, LocalDateTime dateTimeUTC, String tapType, String stopId, String companyId, String busId, String pan) {
        this.id = id;
        this.dateTimeUTC = dateTimeUTC;
        this.tapType = tapType;
        this.stopId = stopId;
        this.companyId = companyId;
        this.busId = busId;
        this.pan = pan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeUTC() {
        return dateTimeUTC;
    }

    public void setDateTimeUTC(LocalDateTime dateTimeUTC) {
        this.dateTimeUTC = dateTimeUTC;
    }

    public String getTapType() {
        return tapType;
    }

    public void setTapType(String tapType) {
        this.tapType = tapType;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Override
    public int compareTo(Tap anotherTap) {
        return this.getDateTimeUTC().compareTo(anotherTap.getDateTimeUTC());
    }

    @Override
    public String toString() {
        return "Tap{" +
                "id=" + id +
                ", dateTimeUTC=" + dateTimeUTC +
                ", TapType=" + tapType +
                ", stopId='" + stopId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", busId='" + busId + '\'' +
                ", pan='" + pan + '\'' +
                '}';
    }


}
