import ch.qos.logback.classic.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TriangleTest {




    private static ch.qos.logback.classic.Logger logger = (Logger) LoggerFactory.getLogger(TriangleArea.class);

    // Позитивные проверки
    // 3 позитивных случая
    @ParameterizedTest
    @CsvSource({"1, 1, 1, 0.4330127018922193", "2, 2, 2, 1.7320508075688772", "3, 4, 5, 6.0"})
    void testCorrectTriangleArea(int a, int b, int c, double expectedArea) {
        logger.info("Стороны треугольника: " + a + "," + b + "," + c + ", ожидаемая площадь: " + expectedArea);
        assertEquals(TriangleArea.calcTriangleArea(a, b, c), expectedArea);
    }

    // Негативные проверки
    // 3 негативных случая
    @ParameterizedTest
    @CsvSource({"1, 1, 1, 1.0", "2, 2, 2, 2.0", "3, 4, 5, 3.0"})
    void testIncorrectTriangleArea(int a, int b, int c, double expectedArea) {
        logger.warn("Стороны треугольника: " + a + "," + b + "," + c + ", ожидаемая площадь: " + expectedArea);
        assertNotEquals(TriangleArea.calcTriangleArea(a, b, c), expectedArea);
    }



}