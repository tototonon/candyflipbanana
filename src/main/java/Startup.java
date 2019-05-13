/**
 * Little software for printing cocktail recipes in a fast way.
 * A new Glasses instance creates all new Glass instances to fill a list with all available glasses.
 * A new Ingredients instance creates all new Ingredient instances to fill a list with all available ingredients.
 * DataReader contains a method for reading the cocktails.txt file which contains all cocktail recipes.
 * UserInput is the class where the user input is handled. Commands such as 'list' or cocktail are handled there.
 * <p>
 * Use 'list' for printing all available cocktails
 * Use 'cocktail (id)' for printing a cocktail recipe.
 * Use 'exit' for exiting the software.
 *
 * @author Amar Alibegovic
 */
public class Startup {
    /**
     * Main function entering user input loop.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        new Glasses();
        new Ingredients();
        DataReader dr = new DataReader();
        dr.readFile();
        UserInput ui = new UserInput();
        ui.enterLoop();
    }
}
