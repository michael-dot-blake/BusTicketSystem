import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.*;

/**
 * @author michaelblake 2021
 * Main class to run the application
 */

public class Driver {

    HashMap<String, Tap> activeTaps = new HashMap<>();
    HashMap<String, Tap> completedTaps = new HashMap<>();
    ArrayList<Trip> finishedTrips = new ArrayList<>();

    /**
     * Method which accepts an array of Tap objects and creates Trip objects to be written
     * to the output file
     * @param arrayTaps
     */

    private void tripCalculate(ArrayList<Tap> arrayTaps) {

        //loop through array of Tap objects and add them to HashMap activeTaps if not present
        for (Tap t : arrayTaps) {
            if (t.getTapType().equalsIgnoreCase("ON")) {
                activeTaps.putIfAbsent(t.getPan(), t);
            }

            if (activeTaps.containsKey(t.getPan()) && t.getTapType().equalsIgnoreCase("OFF")) {

                //if the next Tap with the same PAN no. is a Tap off at the same Stop then trip has been cancelled
                if (activeTaps.get((t.getPan())).getStopId().equalsIgnoreCase(t.getStopId())) {
                    CancelledTrip cancel = new CancelledTrip(activeTaps.get(t.getPan()), t);
                    finishedTrips.add(cancel);
                    completedTaps.put(cancel.getTapOn().getId(), cancel.getTapOn());
                    completedTaps.put(cancel.getTapOff().getId(), cancel.getTapOff());

                    //if the next Tap is of type Tap off and the stop is different, then the trip was Complete
                } else {
                    CompletedTrip complete = new CompletedTrip(activeTaps.get(t.getPan()), t);
                    finishedTrips.add(complete);
                    completedTaps.put(complete.getTapOn().getId(), complete.getTapOn());
                    completedTaps.put(complete.getTapOff().getId(), complete.getTapOff());
                }
                activeTaps.clear();
            }
        }

        //if at the end of the program there are taps which are incomplete
        //create Incomplete Trip objects and add them to the finishedTrips Array
        for (Tap t : arrayTaps) {
            if (t.getTapType().equalsIgnoreCase("ON") &&
                    !completedTaps.containsKey(t.getId())) {
                IncompleteTrip inc = new IncompleteTrip(t);
                finishedTrips.add(inc);
            }
        }

    }

    /**
     * Method which takes in input file and saves it as an arrayList.
     * ArrayList is then sorted chronologically and trips costs are calculated.
     * An arrayList of finishedTrips is then written to the output file
     * in .csv format
     *
     * @throws IOException
     * @throws CsvRequiredFieldEmptyException
     * @throws CsvDataTypeMismatchException
     */

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









