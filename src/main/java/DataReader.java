import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to read data from file.
 *
 * @author Timon Tonon
 */
public class DataReader {
    private static final List<Drink> drinkList = new ArrayList<>();

    public static final List<Drink> getDrinkList() {
        return drinkList;
    }

    /**
     * Reads cocktails database file and splits to fill information to RAM.
     */
    public void readFile() {
        // read textfile from textdocument
        try (BufferedReader br = new BufferedReader(new FileReader("cocktails.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> contents = Arrays.asList(line.split("\t"));

                if (contents.size() >= 4) {
                    Drink drink = new Drink(contents.get(0), Glass.getGlass(Integer.parseInt(contents.get(1))));

                    List<String> ings = new LinkedList<>();
                    for (int i = 2; i < contents.size(); ++i) {
                        ings.add(contents.get(i));
                    }

                    for (int i = 0; i < ings.size(); ++i) {
                        drink.addIngredient(Ingredient.getIngredient(Integer.parseInt(ings.get(i))),
                                Float.parseFloat(ings.get(++i)));

                    }

                    drinkList.add(drink);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}