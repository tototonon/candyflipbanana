import org.junit.Test;

import java.util.logging.Logger;

/**
 * Class to test ingredient functions
 *
 * @author Hanan Rasho
 */
class IngredientTest {
    private static Logger logger = Logger.getLogger(IngredientTest.class.getName());

    /**
     * Tests if negative or too big indices may encouter a crash.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetIngredient() {
        logger.info("Testing indices of Ingredient.getIngredient(int)");
        Ingredient.getIngredient(-1);
        Ingredient.getIngredient(10000);
        logger.info("Test passed.");
    }
}