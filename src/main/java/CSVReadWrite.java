import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReadWrite {

    private static final String FILEPATH = "src/main/resources/taps.csv";

    public static ArrayList<Tap> readCSVtoBean() throws FileNotFoundException {

        Reader reader = new BufferedReader(new FileReader(FILEPATH));

        CsvToBean<Tap> csvReader = new CsvToBeanBuilder<Tap>(reader)
                .withType(Tap.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .withSkipLines(1)
                .build();

        List<Tap> csv = csvReader.parse();
        ArrayList<Tap> tapList = new ArrayList<>();

        for (Tap t : csv) {
            Tap myTap = new Tap(t.getId(), t.getDateTimeUTC(), t.getTapType(), t.getStopId(),
                    t.getCompanyId(), t.getBusId(), t.getPan());
            tapList.add(myTap);
        }
        return tapList;

    }
}






