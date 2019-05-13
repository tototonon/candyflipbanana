import org.junit.Test;

import java.util.logging.Logger;

/**
 * Class to test Glass functions.
 *
 * @author Hanan Rasho
 */
public class GlassTest {
    private static Logger logger = Logger.getLogger(GlassTest.class.getName());

    /**
     * Tests if there is a crash if index is wrong in getGlass function.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetGlass() {
        logger.info("Testing indices of Ingredient.getIngredient(int)");
        Glass.getGlass(-1);
        Glass.getGlass(10000);
        logger.info("Test passed.");
    }
}