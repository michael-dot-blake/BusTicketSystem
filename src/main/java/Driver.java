import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.*;

public class Driver {

    HashMap<String, Tap> activeTaps = new HashMap<>();
    HashMap<String, Tap> completedTaps = new HashMap<>();
    ArrayList<Trip> finishedTrips = new ArrayList<>();

    private void tripCalculate(ArrayList<Tap> arr) {

        for (Tap t : arr) {
            if (t.getTapType().equalsIgnoreCase("ON")) {
                activeTaps.putIfAbsent(t.getPan(), t);
            }
            if (activeTaps.containsKey(t.getPan()) && t.getTapType().equalsIgnoreCase("OFF")) {
                if (activeTaps.get((t.getPan())).getStopId().equalsIgnoreCase(t.getStopId())) {
                    CancelledTrip cancel = new CancelledTrip(activeTaps.get(t.getPan()), t);
                    finishedTrips.add(cancel);
                    completedTaps.put(cancel.getTapOn().getId(), cancel.getTapOn());
                    completedTaps.put(cancel.getTapOff().getId(), cancel.getTapOff());
                } else {
                    CompletedTrip complete = new CompletedTrip(activeTaps.get(t.getPan()), t);
                    finishedTrips.add(complete);
                    completedTaps.put(complete.getTapOn().getId(), complete.getTapOn());
                    completedTaps.put(complete.getTapOff().getId(), complete.getTapOff());
                }
                activeTaps.clear();
            }
        }

        for (Tap t : arr) {
            if (t.getTapType().equalsIgnoreCase("ON") &&
                    !completedTaps.containsKey(t.getId())) {
                IncompleteTrip inc = new IncompleteTrip(t);
                finishedTrips.add(inc);
            }
        }

    }

    private void run() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        ArrayList<Tap> mainTaps = CSVReadWrite.readCSVtoBean();
        Collections.sort(mainTaps);
        tripCalculate(mainTaps);
        Collections.sort(finishedTrips);
        CSVReadWrite.writeListToCsv(finishedTrips);

    }

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Driver dr = new Driver();
        dr.run();
    }


}









