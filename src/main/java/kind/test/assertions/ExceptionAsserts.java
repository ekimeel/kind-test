package kind.test.assertions;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Michael J. Lee
 */
public class ExceptionAsserts {

    public static void assertExMessage(Throwable ex, String message) {
        assertEquals(ex.getMessage(), message);
    }

    public static void assertExMessageContains(Throwable ex, String message) {
        assertTrue(ex.getMessage().toLowerCase().
                contains(message.toLowerCase()),
                "Throwable message '" + ex.getMessage() +
                        "' does not contain '" + message + "'");
    }

    public static void assertExMessageContains(Throwable ex, String... words) {
        for (String aWord : words){
            assertExMessageContains(ex, aWord);
        }
    }
}
