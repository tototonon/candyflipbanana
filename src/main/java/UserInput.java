import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Class to handle user input in console.
 *
 * @author Sahin Gündogan
 */
public class UserInput {
    private String command = "";
    private String[] params = new String[1];
    private Scanner s = new Scanner(System.in);

    /**
     * Loop contains requesting a command input and handles each entered command if it is allowed.
     */
    public void enterLoop() {
        while (!command.equals("exit")) {
            writeInputRequest();
            readUserInput();

            if (command.equals("list")) {
                writeCocktailList();
            } else if (command.equals("cocktail") && params.length == 1) {
                writeCocktailRecipe();
            }

        }
    }

    /**
     * Prints command input request with a list of all available commands.
     */
    private void writeInputRequest() {
        System.out.println();
        System.out.println("Bitte geben Sie einen Befehl ein.");
        System.out.println("Erlaubte Befehle: ");
        System.out.println("    cocktail <id>   //Cocktailrezept ausgeben");
        System.out.println("    list            //Liste von verfügbaren Cocktails ausgeben");
        System.out.println("    exit            //Programm beenden");
        System.out.println();
    }

    /**
     * Reads user command.
     */
    private void readUserInput() {
        String[] cmd = s.nextLine().split(" ");
        switch (cmd.length) {
            case 2:
                params = new String[cmd.length - 1];
                for (int i = 1; i < cmd.length; ++i) {
                    params[i - 1] = cmd[i];
                }
            case 1:
                command = cmd[0];
                break;
            default:
                break;
        }
    }

    /**
     * Prints list with all available cocktails.
     */
    private void writeCocktailList() {
        List<Drink> drinkList = DataReader.getDrinkList();

        for (int i = 0; i < drinkList.size(); ++i) {
            System.out.println(i + " " + drinkList.get(i).getName());
        }
    }

    /**
     * Prints cocktail ingredients by command "cocktail" with id as parameter.
     */
    private void writeCocktailRecipe() {
        if (params.length == 0) {
            return;
        }

        int index = Integer.parseInt(params[0]);

        if (index < 0 || index >= DataReader.getDrinkList().size()) {
            System.out.print("Die eingegebene Cocktail-ID ist nicht im erlaubten Bereich");
            System.out.println("(0 - " + (DataReader.getDrinkList().size() - 1) + ").");
            return;
        }

        Drink d = DataReader.getDrinkList().get(Integer.parseInt(params[0]));
        System.out.println("Cocktail: " + d.getName());
        System.out.println("    Glas: " + d.getGlassVolume() + " Liter");
        Map<Ingredient, Float> ingredients = d.getIngredients();
        Set<Ingredient> keySet = ingredients.keySet();

        for (Ingredient i : keySet) {
            System.out.print("  - " + i.getName() + ", " + ingredients.get(i));
            if (i.getId() >= 34 && i.getId() <= 41) {
                System.out.println(" Stück/Prisen");
            } else {
                System.out.println(" Liter");
            }
        }
    }
}
