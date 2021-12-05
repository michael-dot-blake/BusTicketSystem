import com.opencsv.bean.AbstractBeanField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author michaelblake 2021
 *
 * Class to handle converting String values to LocalDateTime objects.
 * A requirement for the opencsv library
 */

public class LocalDateTimeConverter extends AbstractBeanField {

    @Override
    protected Object convert(String value) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(value, formatter);
    }

}
