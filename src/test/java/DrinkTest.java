import java.security.Key;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class to test Drink functions.
 *
 * @author Amar Alibegovic
 */
public class DrinkTest {
    private static Logger logger = Logger.getLogger(DrinkTest.class.getName());

    /**
     * Tests addIngredient() function if float volume is negative
     */
    @Test
    public void testAddIngredient() {
        Glass g = new Glass(0.5F, "Testglass");
        Drink d = new Drink("Testcase", Glass.getGlass(0));

        float amount = -1000.0F;

        Ingredient i = new Ingredient("Testingredient");
        d.addIngredient(Ingredient.getIngredient(0), amount);

        Set<Ingredient> keySet = d.getIngredients().keySet();

        for (Ingredient ing : keySet) {
            Assert.assertEquals(amount, d.getIngredients().get(ing), 0.01F);
        }

    }
}