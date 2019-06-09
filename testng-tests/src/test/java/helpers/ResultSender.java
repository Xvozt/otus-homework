package helpers;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class ResultSender {
    private static final InfluxDB INFLUXDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
    private static final String DATABASE = "selenium";

    static {
        INFLUXDB.setDatabase(DATABASE);
    }

    public static void send(final Point point) {
        INFLUXDB.write(point);
    }
}
