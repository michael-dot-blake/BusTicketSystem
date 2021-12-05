import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReadWrite {

    private static final String INPUT = "src/main/resources/taps.csv";
    private static final String OUTPUT = "src/main/resources/trips.csv";

    public static ArrayList<Tap> readCSVtoBean() throws FileNotFoundException {

        Reader reader = new BufferedReader(new FileReader(INPUT));

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

    public static void writeListToCsv(ArrayList<Trip> list) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OUTPUT));
        ) {

            ICSVWriter csvWriter = new CSVWriterBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                    .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .build();

            String[] columnNames = {"Started", "Finished", "FromStopID", "ToStopID", "TripDuration", "ChargeAmount",
                    "CompanyID", "BusID", "PAN", "Status"};
            csvWriter.writeNext(columnNames);

            StatefulBeanToCsv<Trip> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(',')
                    .build();
            beanToCsv.write(list);
        }
    }
}









