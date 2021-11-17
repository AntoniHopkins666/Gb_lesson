public class Weather {
    String date;
    String maxTemp;
    String minTemp;

    @Override
    public String toString() {
        return "[" + date + "," + minTemp + " - " + maxTemp + "]";
    }
}