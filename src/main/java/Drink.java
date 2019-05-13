import java.util.HashMap;
import java.util.Map;

/**
 * Class to handle drinks.
 *
 * @author Amar Alibegovic
 */
public class Drink {
    /**
     * All drink types.
     */
    public enum Art {
        Alcohol,
        NoAlcohol
    }

    private Glass glass;
    private String name;
    private final Map<Ingredient, Float> ingredients = new HashMap<>();

    /**
     * Constructor sets values by params.
     *
     * @param name
     * @param glass
     */
    public Drink(String name, Glass glass) {
        setName(name);
        this.glass = glass;
    }

    /**
     * Returns name string.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name string.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns required glass volume.
     *
     * @return volume
     */
    public float getGlassVolume() {
        return glass.getVolume();
    }

    /**
     * Adds ingredient to ingredients list of drink.
     *
     * @param ingredient ingredient reference
     * @param amount     amount in litres
     */
    public void addIngredient(Ingredient ingredient, float amount) {
        ingredients.put(ingredient, amount);
    }

    /**
     * Returns ingredients list of current drink.
     *
     * @return list
     */
    public final Map<Ingredient, Float> getIngredients() {
        return ingredients;
    }
}
