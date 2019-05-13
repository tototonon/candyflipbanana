import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class to manage any ingredients.
 *
 * @author Hanan Rasho
 */
public class Ingredient {
    private int id;
    private String name;
    private static final List<Ingredient> ingredients = new ArrayList<>();

    /**
     * Returns id.
     *
     * @return id
     */
    public int getId() {
        return id;
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
     * Ctor sets default values (automatically calculates new id) and sets name by param. Adds reference to list.
     *
     * @param name
     */
    public Ingredient(String name) {
        if (ingredients.isEmpty()) {
            this.id = 0;
        } else {
            this.id = ingredients.get(ingredients.size() -1).id + 1;
        }
        ingredients.add(this);
        this.name = name;
    }

    /**
     * Returns ingredient from list by id.
     *
     * @param id
     * @return ingredient reference
     */
    public static final Ingredient getIngredient(int id) {
        if (id < 0 || id >= ingredients.size()) {
            return ingredients.get(0);
        }
        return ingredients.get(id);
    }
}
