import java.util.LinkedList;
import java.util.List;

/**
 * Simple class which keeps id data (for saving) and volume of certain glasses.
 *
 * @author Hanan Rasho
 */
public class Glass {
    private static final List<Glass> glassList = new LinkedList<>();

    private int id;
    private float volume;
    private String name;

    /**
     * Constructor sets default id by picking last element in glassList and sets value of volume.
     *
     * @param volume volume in litres
     * @param name   name of glass
     */
    public Glass(float volume, String name) {
        if (glassList.isEmpty()) {
            this.id = 0;
        } else {
            this.id = glassList.get(glassList.size() - 1).id;
        }
        glassList.add(this);
        this.volume = volume;
        this.name = name;
    }

    /**
     * Returns unique id number of glass.
     *
     * @return id
     */
    public final int getId() {
        return id;
    }

    /**
     * Returns volume of glass.
     *
     * @return volume
     */
    public final float getVolume() {
        return volume;
    }

    /**
     * Returns name of glass.
     *
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns glass instance by id.
     *
     * @param id
     * @return glass reference
     */
    public static final Glass getGlass(int id) {
        if (id < 0 || id >= glassList.size()) {
            return glassList.get(0);
        }
        return glassList.get(id);
    }
}
