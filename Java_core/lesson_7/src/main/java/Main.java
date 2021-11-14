import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String cityCode = RequestHandler.detectCityId("Moscow");
        System.out.println(cityCode);

        //String forecast = RequestHandler.getForecast(cityCode);
        //System.out.println(forecast);

        String oneDay = RequestHandler.oneDay(cityCode);
        System.out.println(oneDay);
    }
}